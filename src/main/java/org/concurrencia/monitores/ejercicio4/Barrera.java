package org.concurrencia.monitores.ejercicio4;

public class Barrera {
    public Barrera(int cupo){
        this.cupo = cupo;
    }
    private int cupo;
    public synchronized void esperar() throws InterruptedException {
        cupo--;
        if(cupo>0){
            wait();
        }
        cupo++;
        notify();
    }

}
