package org.concurrencia.monitores;

import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            IntStream.range(0, 3).

                    forEachOrdered(n ->
                    {
                    });
        }).start();

        new Thread(() -> {
            IntStream.range(0, 3).forEachOrdered(n -> {
            });
        }).start();

    }
}
