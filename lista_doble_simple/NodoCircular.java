package lista_doble_simple;


public class NodoCircular<T>  {
    private T dato;
    private NodoCircular<T> siguiente;
    private NodoCircular<T> anterior;

    public NodoCircular(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }


    public T getDato() {
        return dato;
    }

    public NodoCircular<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircular<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoCircular<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoCircular<T> anterior) {
        this.anterior = anterior;
    }

}
