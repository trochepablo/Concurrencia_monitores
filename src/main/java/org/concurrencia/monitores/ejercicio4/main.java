package org.concurrencia.monitores.ejercicio4;

public class main {
    public static void main(String[] args) {
        Barrera miBarrera = new Barrera(3);
        Thread uno = new Thread(() -> {
            System.out.println("a");
            try {
                miBarrera.esperar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("1");
        });
        Thread dos = new Thread(() -> {
            System.out.println("b");
            try {
                miBarrera.esperar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("2");
        });
        Thread tres = new Thread(() -> {
            System.out.println("c");
            try {
                miBarrera.esperar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("3");
        });
        uno.start();
        dos.start();
        tres.start();
    }
}
