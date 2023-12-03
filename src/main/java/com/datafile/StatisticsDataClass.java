/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datafile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.apdplat.word.WordFrequencyStatistics;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;


//进行词频统计

public class StatisticsDataClass {

    public static void statistic(String wordOut, String wordApart, String wordStatistics) throws Exception {
        //词频统计设置
        PathClass pa = new PathClass();
        PrintStream ps = new PrintStream(pa.log);/*过滤屏幕信息,存储日志*/
        PrintStream out = System.out;
        System.setOut(ps);
        WordFrequencyStatistics wordFrequencyStatistics = new WordFrequencyStatistics();
        wordFrequencyStatistics.setRemoveStopWord(true);//去掉虚词和一般的连词
        wordFrequencyStatistics.setResultPath(wordStatistics);
        wordFrequencyStatistics.setSegmentationAlgorithm(SegmentationAlgorithm.MaxNgramScore);//最大Ngram分值算法
//        wordFrequencyStatistics.setSegmentationAlgorithm(SegmentationAlgorithm.MaximumMatching);//正向最大匹配算法
//        wordFrequencyStatistics.setSegmentationAlgorithm(SegmentationAlgorithm.FullSegmentation);//全切分算法,计算量非常大，通常不太适用于大规模文本
//        wordFrequencyStatistics.setSegmentationAlgorithm(SegmentationAlgorithm.BidirectionalMinimumMatching);//双向最小匹配算法
//        wordFrequencyStatistics.setSegmentationAlgorithm(SegmentationAlgorithm.BidirectionalMaximumMinimumMatching);//双向最大最小匹配算法
        wordFrequencyStatistics.seg(new File(wordOut), new File(wordApart));
        wordFrequencyStatistics.dump();//输出词频统计结果
        System.setOut(out);
        wordFrequencyStatistics.dump();

    }
}
