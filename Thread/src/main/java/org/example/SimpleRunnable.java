package org.example;

public class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(
                "Running in thread: " + Thread.currentThread().getName()
        );
    }
}

 class Main2 {
    public static void main(String[] args) {
        Thread t = new Thread(new SimpleRunnable());
        t.start();
    }
}
