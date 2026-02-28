package org.example;

 class SimpleThread extends Thread {

    public void run(){
        System.out.println("Hello from thread");
    }
}

 class Main1 {
    public static void main(String[] args){
        SimpleThread simpleThread=new SimpleThread();
        simpleThread.start();
    }
}


