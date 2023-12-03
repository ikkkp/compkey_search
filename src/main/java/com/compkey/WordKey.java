/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compkey;

public class WordKey {
    public String wordKey;
    public String wordMidKey;
    public String wordCompKey;
    public double compPower;
    
    public void wordKeyInit(String str_wordKey, String str_wordMidKey, String str_wordCompKey, double dou_compPower){
        wordKey = str_wordKey;
        wordMidKey = str_wordMidKey;
        wordCompKey = str_wordCompKey;
        compPower = dou_compPower;
    }
    public void wordKeyPrint() {
        System.out.println("(种子)" + wordKey +  "\t" + "(中介)" + wordMidKey + "\t" +  "(竞争)" + wordCompKey + "\t竞争度：" + String.format("%.16f", compPower));
    }
}
