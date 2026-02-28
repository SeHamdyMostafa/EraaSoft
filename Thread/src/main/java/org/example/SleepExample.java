package org.example;

public class SleepExample {

    public void run(){
        for (int i=0;i<5;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();}
        }
    }
}

class Main3 {
    public static void main(String[] args) {
        SleepExample sleepExample=new SleepExample();
        sleepExample.run();
    }
}