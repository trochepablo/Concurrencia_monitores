package org.concurrencia.monitores;

public class Contador {
    private int contador;

    public synchronized void incrementar(){
        contador++;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
