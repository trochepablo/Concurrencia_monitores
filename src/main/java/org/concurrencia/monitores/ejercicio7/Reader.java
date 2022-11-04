package org.concurrencia.monitores.ejercicio7;

public class Reader implements Runnable {
    private final RW rw;

    public Reader(RW rw) {
        this.rw = rw;
    }

    @Override
    public void run(){
        try {
            deserialize();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void deserialize() throws InterruptedException {
        rw.beginRead();
        System.out.println("Estoy leyendo");
        Thread.sleep(5000);
        System.out.println("deserialize: " + rw.getSerializable());
        rw.endRead();
    }
}
