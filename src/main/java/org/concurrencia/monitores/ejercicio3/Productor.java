package org.concurrencia.monitores.ejercicio3;

public class Productor extends Thread {
    private final Buffer buffer;

    public Productor(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        int i = 0;
        while (true){
            try {
                buffer.push(i);
                System.out.println("Valor escribido: " + i);
                i++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
