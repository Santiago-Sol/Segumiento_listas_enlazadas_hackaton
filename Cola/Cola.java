import java.util.Iterator;

public class Cola<T>{
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamano;

    

    public Cola() {
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

    

 
}
