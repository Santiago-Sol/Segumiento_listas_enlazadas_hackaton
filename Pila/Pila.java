package Pila;

public class Pila<T> {
    private Nodo<T> primero;
    private int tamano;

    public Pila() {
        this.primero = null;
        this.tamano = 0;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public void empilar(Nodo<T> nuevoNodo) {
        if (this.primero == null) {
            this.primero = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(primero);
            this.primero = nuevoNodo;
        }
        this.tamano++;
    }

    public void desempilar(){
        if (this.primero != null) {
            this.primero = primero.getSiguiente();
            this.tamano--;
        }
    }
}
