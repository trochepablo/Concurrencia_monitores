package org.concurrencia.monitores;

public class HelloWord implements Runnable {
    public static void main(String[] args) {
        int write = 0;
        System.out.println(write++);
        System.out.println(write);
    }

    @Override
    public void run() {
        
    }
}