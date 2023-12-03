/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;





//数据预处理
public class NewCleanFileClass {
    public static void Clean(String wordIn, String wordOut) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        File fileOut = new File(wordOut);
        InputStreamReader inStream = new InputStreamReader(new FileInputStream(new File(wordIn)), "GBK");//读取文件
        OutputStreamWriter outStream = new OutputStreamWriter(new FileOutputStream(new File(wordOut)), "utf-8");
        BufferedReader bf = new BufferedReader(inStream);
        BufferedWriter bw = new BufferedWriter(outStream);
        String valueString = null;
        char c[];
        while ((valueString=bf.readLine())!=null){
            c = valueString.toCharArray(); 
            for(int i = 39; i < valueString.length(); i++) { //只保留下关键字
                bw.append(c[i]);
                if(c[i] == '\t') {
                    bw.newLine();
                }
            }            
            if(fileOut.length() > 10000000) break;//取10M的数据10*1024*1024
        }
        bw.close();
    }
}
