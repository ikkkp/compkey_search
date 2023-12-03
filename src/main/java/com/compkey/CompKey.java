/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compkey;

import com.datafile.*;
import com.entity.KeywordEntity;
import com.service.KeywordService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class CompKey {
    public static void compkey(String wordKey, int n) throws UnsupportedEncodingException, IOException, Exception {
        PathClass pa = new PathClass();
        System.out.println("开始从总搜索量中提取出与种子关键字相关的搜索信息...");
        new MainDataClass().data(wordKey);  //已完成从原数据中提取出与种子关键字相关的搜索信息

        System.out.println("开始查找中介关键词...");
        /*用关键字的频率来代替权重，找出前10个中介关键字，并将保存到文件wordMidKey中*/
        InputStreamReader inStream = new InputStreamReader(new FileInputStream(pa.wordStatistics), "utf-8");
        BufferedReader bf = new BufferedReader(inStream);
        PrintStream ps = new PrintStream(pa.wordMidKey);/*保存屏幕信息*/
        PrintStream out = System.out;
        System.setOut(ps);
        String valueString = null;
        //int n = 6;
        int sum = 0;
        valueString = bf.readLine();
        while ((valueString = bf.readLine()) != null) {
            int temp = valueString.indexOf(" ");
            valueString = valueString.substring(0, temp);
            char c = valueString.charAt(0);
            if(valueString.length() <= 1 || valueString.contains(wordKey) || (c >= '0' && c <= '9')) { //过滤掉一个字的中介关键词
                continue;
            } else {
                System.out.println(valueString);
                sum++;
            }
            if (sum == n) {
                break;
            }
        }
        //ps.close();
        System.setOut(out);

        System.out.println("开始查找竞争性关键词，并计算竞争度...");
        /*寻找竞争性关键词*/
        InputStreamReader inStreamR = new InputStreamReader(new FileInputStream(new File(pa.wordMidKey)), "GBK");//读取文件
        BufferedReader bfr = new BufferedReader(inStreamR);

        WordKey[] wordK = new WordKey[n];
        for(int i = 0; i < n; i++) {
            wordK[i] = new WordKey();
        }
        for (int i = 0; i < n; i++) {
            String wordMidKey = bfr.readLine();   //中介关键词
            //System.out.println(wordMidKey);
            InputStreamReader inStream1 = new InputStreamReader(new FileInputStream(new File(pa.wordOut)), "utf-8");//读取文件
            OutputStreamWriter outStream = new OutputStreamWriter(new FileOutputStream(new File(pa.wordTempKey)), "utf-8");
            BufferedReader bf1 = new BufferedReader(inStream1);
            BufferedWriter bw1 = new BufferedWriter(outStream);
            String valueString1 = null;
            int a = 0; //所有含中介关键词的搜索量
            int ka = 0; //同时包含关键字和中介关键字的搜索量
            int sa = 0; //同时包含竞争关键字和中介关键字的搜索量
            while ((valueString1 = bf1.readLine()) != null) {  //与种子关键字相关的搜索信息
                if (valueString1.contains(wordMidKey)) {
                    bw1.write(valueString1);
                    bw1.newLine();
                    a++;
                }
            }
            bw1.close();
            new StatisticsDataClass().statistic(pa.wordTempKey, pa.wordTempApart, pa.wordTempStatistics);//对相关信息进行分词和词频统计

            /*寻找竞争关键词*/
            InputStreamReader inStream2 = new InputStreamReader(new FileInputStream(new File(pa.wordTempStatistics)), "utf-8");//读取文件
            BufferedReader bf2 = new BufferedReader(inStream2);
            String wordCompKey = null;
            while((wordCompKey = bf2.readLine()) != null) {
                int temp = wordCompKey.indexOf(" ");
                wordCompKey = wordCompKey.substring(0, temp);
                char c = wordCompKey.charAt(0);
                if(wordCompKey.length() <= 1 || (c >= '0' && c <= '9')) continue;/*去掉一个字的关键字*/
                if(!wordCompKey.contains(wordMidKey) && !wordCompKey.contains(wordKey)) {
                    break;
                }
            }

            /*统计同时包含竞争关键字和中介关键字的搜索量*/
            InputStreamReader inStream3 = new InputStreamReader(new FileInputStream(new File(pa.wordTempApart)), "utf-8");//读取文件
            BufferedReader bf3 = new BufferedReader(inStream3);
            String valueString3 = null;
            while ((valueString3 = bf3.readLine()) != null) {
                if (valueString3.contains(wordMidKey) && valueString3.contains(wordKey) && !valueString3.contains(wordCompKey)) {
                    ka++;
                }
                if (valueString3.contains(wordMidKey) && valueString3.contains(wordCompKey) && !valueString3.contains(wordKey)) {
                    sa++;
                }
            }
            double ans;
            if(a - sa == 0) {
                ans = -1;
            } else {
                ans = (double)ka / (double)(a - sa);
            }

            wordK[i].wordKeyInit(wordKey, wordMidKey, wordCompKey, ans);
            //wordK[i].wordKeyPrint();
            //System.out.println("已完成第" + (i + 1) + "条数据统计:" + "(种子)" + wordKey + ":"+ ka + "\t\t" + "(中介)" + wordMidKey + ":" + a + "\t\t" + "(竞争)" + wordCompKey + ":" + sa + "\t\t竞争度：" + String.format("%.16f", ans));
            System.out.println("已完成第" + (i + 1) + "条数据统计:" + "(种子)" + wordKey + "\t" + "(中介)" + wordMidKey + "\t" + "(竞争)" + wordCompKey + "\t竞争度：" + String.format("%.16f", ans));
            new KeywordService().insertKeyword(new KeywordEntity(wordKey,wordMidKey,wordCompKey,(float)ans));
        }

        /*竞争性关键词排序打印*/
        WordKey tempWord;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(wordK[j].compPower < wordK[j + 1].compPower) {
                    tempWord = wordK[j];
                    wordK[j] = wordK[j + 1];
                    wordK[j + 1] = tempWord;
                }
            }
        }
        String Result = pa.wordResult + wordKey + pa.txt;
        PrintStream ps1 = new PrintStream(Result);/*保存屏幕信息*/
        System.setOut(ps1);
        System.out.println("“" + wordKey + "”的竞争性关键词关于竞争度排序如下:");
        for(int i = 0; i < n; i++) {
            wordK[i].wordKeyPrint();
        }
        System.setOut(out);
        System.out.println("CompKey算法结束...");
        System.out.println();
    }
}