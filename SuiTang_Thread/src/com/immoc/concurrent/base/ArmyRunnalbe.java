package com.immoc.concurrent.base;

/**
 * Created by ealldy on 2020/7/5.
 * 军队线程
 * 模拟作战双方行为
 */
public class ArmyRunnalbe implements Runnable{
    //volatile保证线程可以正确读取其他线程写入的值
    //可见性
    volatile boolean keepRunning = true;
    int Hurt = 0;
    @Override
    public void run() {

        while (keepRunning){
            //发动5连击
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]"+"["+(++Hurt)+"]");
                //让出了处理器时间，下次该谁进攻还不一定呢！
                Thread.yield();
            }
        }
    }
}
