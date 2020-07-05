package com.immoc.concurrent.base;

/**
 * Created by ealldy on 2020/7/5.
 */
public class KeyPersonThread extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始了战斗！");
        for (int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"左突右杀");
        }
        System.out.println(Thread.currentThread().getName()+"结束了战斗！");
    }
}
