package org.concurrencia.monitores.ejercicio5;

public class Event {

    private int epoch;

    public synchronized void publish() throws InterruptedException {
        epoch++;
        wait();
    }
    public synchronized void suscribe(){
        int current = epoch;
        while(current >= epoch){
            notifyAll();
        }
    }
}
