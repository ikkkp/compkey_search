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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.apdplat.word.WordFrequencyStatistics;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;

public class CleanFileClass {
    public static void Clean(String wordIn, String wordOut) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        File fileOut = new File(wordOut);
        InputStreamReader inStream = new InputStreamReader(new FileInputStream(new File(wordIn)), "GBK");//读取文件
        OutputStreamWriter outStream = new OutputStreamWriter(new FileOutputStream(new File(wordOut)), "utf-8");
        BufferedReader bf = new BufferedReader(inStream);
        BufferedWriter bw = new BufferedWriter(outStream);
        String valueString = null;
        char c[];
        int sign = -1;
        while ((valueString=bf.readLine())!=null){
            c = valueString.toCharArray(); 
            for(int i = 0; i < valueString.length(); i++) { //只保留下关键字
                if(c[i] == '[') {
                     sign = 1;
                     i++;
                }
                if(c[i] == ']') sign = -1;
                if(sign == 1) {
                    //System.out.print(c[i]);
                    bw.append(c[i]);
                }
            }
            //System.out.println();
            bw.newLine();
            
            //if(fileOut.length() > 10000000) break;//取10M的数据10*1024*1024
//            sum++;//通过行数来退出写文件
//            if(sum == 10) {
//                break;
//            }
        }
        bw.close();
        //ps.close();
    }
}
//fileIn2的处理
//            sum++;
//            c = valueString.toCharArray(); 
//            for(int i = 39; i < valueString.length(); i++) {
//                if(c[i] == '\t') {
//                    System.out.println(new String());
//                    continue;
//                }
//                System.out.print(c[i]);
//            }*/
//            if(sum == 2) break;
