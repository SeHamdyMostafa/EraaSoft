package org.example;

public class JoinExample extends Thread{

    private String NameOfThread;

    JoinExample(String Name){
        this.NameOfThread=Name;
    }

    public void run(){
        try {
        System.out.println(NameOfThread + "  started");
            Thread.sleep(1000);
        System.out.println(NameOfThread + "  finished");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
 class Main4 {
    public static void main(String[] args) throws InterruptedException {
        JoinExample t1 = new JoinExample("Thread-1");
        JoinExample t2 = new JoinExample("Thread-2");

        t1.start();
        t2.start();

        t1.join(); // main waits for t1
        t2.join(); // main waits for t2

        System.out.println("Main thread finished after workers");
    }
}