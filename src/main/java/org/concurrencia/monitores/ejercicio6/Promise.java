package org.concurrencia.monitores.ejercicio6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Promise implements Future {
    private Object object = null;

    @Override
    public synchronized Object get() throws InterruptedException {
        while (object == null) {
            System.out.println("duermo");
            wait();
            System.out.println("despierto; " + "valor object: " + object.toString());
        }
        Object objectResult = object;
        object = null;
        return objectResult;
    }



    public synchronized void set(Object o) {
        System.out.println("seteo " + o.toString());
        object = o;
        notify();
    }

    public Future asynch(Object x) {
        Promise promise = new Promise();
        new Thread(() -> {
            // computo costo en funcion de x que genera un resultado
            promise.set(x);
        });
        return promise;
    }


    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }
    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
