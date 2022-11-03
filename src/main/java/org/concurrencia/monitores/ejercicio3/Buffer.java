package org.concurrencia.monitores.ejercicio3;

public class Buffer {
    private final Integer[] buffer;
    private int begin = 0;
    private int end = 0;

    public Buffer(int m){
        buffer = new Integer[m+1];
    }

    public Integer[] getBuffer() {
        return buffer;
    }

    public synchronized void push(int i) throws InterruptedException {
        while (isFull()) wait();
        buffer[begin] = i;
        begin = next(begin);
        notifyAll();
    }

    public synchronized int pop() throws InterruptedException {
        while(isEmpty()){
            wait();
        }
        int result = buffer[end];
        end = next(end);
        notifyAll();
        return result;
    }

    private boolean isEmpty() {
        return begin == end;
    }

    private boolean isFull() {
        return next(begin) == end;
    }

    private int next(int i){
        return (i+1)%(buffer.length);
    }
}

