package com.immoc.concurrent.base;

/**
 * Created by ealldy on 2020/7/5.
 * 隋唐演义大戏舞台
 */
public class Stage extends Thread {
    volatile boolean p = true;

    public void run() {
        //若百姓不安居乐业，则一直发动战争
        while (p == true) {
            ArmyRunnalbe armyTaskOfRevolt = new ArmyRunnalbe();
            ArmyRunnalbe armyTaskOfSuiDynasty = new ArmyRunnalbe();


            Thread armyOfRevolt1 = new Thread(armyTaskOfRevolt, "农民起义军1");
            Thread armyOfRevolt2 = new Thread(armyTaskOfRevolt, "农民起义军2");

            Thread armyOfSuiDynasty1 = new Thread(armyTaskOfSuiDynasty, "隋军1");
            Thread armyOfSuiDynasty2 = new Thread(armyTaskOfSuiDynasty, "隋军2");

            //启动线程，让军队开始作战
            armyOfRevolt1.start();
            //armyOfRevolt2.start();
            armyOfSuiDynasty1.start();
            armyOfSuiDynasty2.start();



            //舞台线程休眠，大家专心观看军队厮杀
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("正当双方激战正酣，半路杀出了个程咬金");
            Thread mrCheng = new KeyPersonThread();
            mrCheng.setName("程咬金");


            armyTaskOfSuiDynasty.keepRunning = false;
            armyTaskOfRevolt.keepRunning = false;

            mrCheng.start();
            try {
                mrCheng.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("农民起义军造成了" + armyTaskOfRevolt.Hurt + "点伤害");
            System.out.println("隋军造成了" + armyTaskOfSuiDynasty.Hurt + "点伤害");
            if (armyTaskOfRevolt.Hurt > armyTaskOfSuiDynasty.Hurt) {
                System.out.println("农民起义军胜利！");
                System.out.println("程咬金的理想就是结束战争，使百姓安居乐业！");
                System.out.println("战争结束，使人民安居乐业");
                p = false;

            } else {
                System.out.println("隋军胜利！");
                System.out.println("程咬金将军战死！");
                System.out.println("虽然战争结束，但依旧人们苦不堪言，将继续发动战争");
                p = true;

            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Stage stage = new Stage();
        stage.start();
    }
}
