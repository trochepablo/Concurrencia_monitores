package org.concurrencia.monitores.ejercicio3;

public class Consumidor extends Thread {
    private final Buffer buffer;

    public Consumidor(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        while (true){
            try {
                System.out.println("Valor leido: " + buffer.pop());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
