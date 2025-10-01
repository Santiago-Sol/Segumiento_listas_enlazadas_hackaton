import java.util.Iterator;

public class BiCola<T>{
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamano;

    

    public BiCola() {
        this.frente = null;
        this.fin = null;
        this.tamano = 0;
    }

    public Nodo<T> getFrente() {
        return frente;
    }
    public void setFrente(Nodo<T> frente) {
        this.frente = frente;
    }
    public Nodo<T> getFin() {
        return fin;
    }
    public void setFin(Nodo<T> fin) {
        this.fin = fin;
    }
    public int getTamano() {
        return tamano;
    }
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public void agregarFinal(Nodo<T> nuevoNodo){
        if (this.tamano == 0){
            this.frente = nuevoNodo;
            this.fin = nuevoNodo;
            System.out.println("cola vacia, se agrego el nodo");
        } else {
            this.fin.setSiguiente(nuevoNodo);
            this.fin = nuevoNodo;
            System.out.println("cola con elementos, se agrego el nodo");
        }
        this.tamano++;
        
    }

    
    public void desencolar(){
        if (frente == null){
            return;
        }

        Nodo<T> temp = frente;
        frente = frente.getSiguiente();
        tamano--;
        System.out.println("se desencolo el nodo: " + temp.getDato());
    }

    public void agregarInicio(Nodo<T> nuevoNodo){
        if (this.tamano == 0){
            this.frente = nuevoNodo;
            this.fin = nuevoNodo;
            System.out.println("cola vacia, se agrego el nodo");
        } else {
            nuevoNodo.setSiguiente(this.frente);
            this.frente = nuevoNodo;
            System.out.println("cola con elementos, se agrego el nodo al inicio");
        }
        this.tamano++;
    }

    public void desencolarFinal(){
        if (this.fin == null){
            return;
        } else {
            Nodo<T> actual = this.frente;
            while (actual.getSiguiente() != this.fin){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(null);
            this.fin = actual;
        }
    }




}
