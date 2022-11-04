package org.concurrencia.monitores.ejercicio7;

import java.util.Random;

public class Writer implements Runnable {
    private final RW rw;

    public Writer(RW rw) {
        this.rw = rw;
    }

    public void serialize() throws InterruptedException {
        rw.beginWrite();
        Thread.sleep(5000);
        int random = new Random().nextInt();
        System.out.println("estoy writeando el valor: " + random);
        rw.setSerializable(random);
        rw.endWrite();
    }

    @Override
    public void run() {
        try {
            serialize();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
