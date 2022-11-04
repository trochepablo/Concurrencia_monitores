package org.concurrencia.monitores.ejercicio6;

import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Promise promise = new Promise();

        new Thread(() -> {
            IntStream.range(0, 3).

                    forEachOrdered(n ->
                    {
                        try {
                            System.out.println("value : " + promise.get());
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }).start();

        new Thread(() -> {
            IntStream.range(0, 3).forEachOrdered(n -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                promise.set(n);
            });
        }).start();

    }
}
