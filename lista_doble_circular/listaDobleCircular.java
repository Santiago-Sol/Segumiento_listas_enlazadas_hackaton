package lista_doble_circular;

public class listaDobleCircular<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamano;

    public listaDobleCircular() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    public void agregarInicio(Nodo<T> newNodo) {
        if (primero == null) {
            primero = ultimo = newNodo;
            ultimo.setSiguiente(primero);
            primero.setAnterior(ultimo);
        } else {
            newNodo.setSiguiente(primero);
            primero.setAnterior(newNodo);
            primero = newNodo;
            ultimo.setSiguiente(primero);
            primero.setAnterior(ultimo);
        }
        tamano++;
    }

    public void ordenarAscendente(Nodo<T> newNodo) {
        if (primero == null) {
            primero = ultimo = newNodo;
            ultimo.setSiguiente(primero);
            primero.setAnterior(ultimo);
        } else if (newNodo.getDato().toString().compareTo(primero.getDato().toString()) < 0) {
            newNodo.setSiguiente(primero);
            primero.setAnterior(newNodo);
            primero = newNodo;
            ultimo.setSiguiente(primero);
            primero.setAnterior(ultimo);
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != primero &&
                    newNodo.getDato().toString().compareTo(actual.getSiguiente().getDato().toString()) > 0) {
                actual = actual.getSiguiente();
            }
            newNodo.setSiguiente(actual.getSiguiente());
            newNodo.setAnterior(actual);
            actual.getSiguiente().setAnterior(newNodo);
            actual.setSiguiente(newNodo);
            if (actual == ultimo) {
                ultimo = newNodo;
            }
        }
        tamano++;
    }

    public void insertarOrdenNatural(Nodo<T> newNodo) {
        if (primero == null) {
            primero = ultimo = newNodo;
            ultimo.setSiguiente(primero);
            primero.setAnterior(ultimo);
        } else if (newNodo.getDato().toString().compareTo(primero.getDato().toString()) < 0) {
            newNodo.setSiguiente(primero);
            primero.setAnterior(newNodo);
            primero = newNodo;
            ultimo.setSiguiente(primero);
            primero.setAnterior(ultimo);
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != primero &&
                    newNodo.getDato().toString().compareTo(actual.getSiguiente().getDato().toString()) > 0) {
                actual = actual.getSiguiente();
            }
            newNodo.setSiguiente(actual.getSiguiente());
            newNodo.setAnterior(actual);
            actual.getSiguiente().setAnterior(newNodo);
            actual.setSiguiente(newNodo);
            if (actual == ultimo) {
                ultimo = newNodo;
            }
        }
        tamano++;
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }


    public Nodo<T> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
}