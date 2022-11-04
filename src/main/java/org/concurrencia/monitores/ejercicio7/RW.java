package org.concurrencia.monitores.ejercicio7;

import org.jetbrains.annotations.Contract;

import java.io.Serializable;

public class RW {
    private int writers;
    private int readers;
    private Serializable serializable;

    private boolean canRead() {
        return writers == 0;
    }
    private boolean canWrite() {
        return writers == 0 && readers == 0;
    }

    public synchronized void beginRead() throws InterruptedException {
        while (!canRead()) wait();
        readers++;
    }

    public synchronized void endRead() {
        readers--;
        if (readers == 0) notify();
    }

    public synchronized void beginWrite() throws InterruptedException {
        while (!canWrite()) wait();
        writers = 1;
    }

    public synchronized void endWrite() {
        writers = 0;
        notifyAll();
    }

    public Serializable getSerializable() {
        return serializable;
    }

    public void setSerializable(Serializable serializable) {
        this.serializable = serializable;
    }
}
