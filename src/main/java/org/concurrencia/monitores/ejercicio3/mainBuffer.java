package org.concurrencia.monitores.ejercicio3;

public class mainBuffer {
    public static void main(String[] args) {
        Buffer b = new Buffer(2);
        Productor p = new Productor(b);
        Consumidor c = new Consumidor(b);
        p.start();
        c.start();
    }
}
