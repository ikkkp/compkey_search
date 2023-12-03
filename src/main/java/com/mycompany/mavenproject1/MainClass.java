/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;
import com.Dao.keywordMapper;
import com.compkey.*;
import com.datafile.*;
import com.entity.KeywordEntity;
import com.service.KeywordService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;


public class MainClass {
    public static void main(String[] args) throws Exception {
        System.out.println("工程初始化完成...");
        PathClass pa = new PathClass();
        System.out.println("清洗数据，获取所有关键词...");
        //CleanFileClass.Clean(pa.wordIn, pa.wordOut); //初步清洗，获取一定数量的关键词
        NewCleanFileClass.Clean(pa.wordInNew, pa.wordOut);
        String []wordKey = args;
        int num = 10;   //设定选取竞争关键字的个数
        for(int i = 0; i < wordKey.length; i++) {
            new CompKey().compkey(wordKey[i], num);
        }
    }
}
