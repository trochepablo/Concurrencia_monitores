package org.concurrencia.monitores.ejercicio7;

import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) throws InterruptedException {

        RW rw = new RW();
        Writer w1 = new Writer(rw);
        Writer w2 = new Writer(rw);

        Reader r1 = new Reader(rw);
        Reader r2 = new Reader(rw);
        Reader r3 = new Reader(rw);
        Reader r4 = new Reader(rw);

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);

        Thread t3 = new Thread(r1);
        Thread t4 = new Thread(r2);
        Thread t5 = new Thread(r3);
        Thread t6 = new Thread(r4);

        t3.start();
        t4.start();
        t5.start();
        t6.start();

        t1.start();
        t2.start();
    }
}
