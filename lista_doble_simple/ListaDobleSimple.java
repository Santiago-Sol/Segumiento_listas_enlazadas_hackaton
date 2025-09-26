package lista_doble_simple;

import java.util.Iterator;

public class ListaDobleSimple<T extends Comparable<T>> implements Iterable<T> {
    private int tamano;
    private NodoDoble<T> primero;
    private NodoDoble<T> ultimo;

    public ListaDobleSimple() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    public void agregarFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (primero == null) {
            primero = ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
        tamano++;
    }

    public void agregarInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (primero == null) {
            primero = ultimo = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
        tamano++;
    }

    public void agregarEnIndice(int indice, T dato) {
        if (indice < 0 || indice > tamano) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (indice == 0) {
            agregarInicio(dato);
            return;
        }
        if (indice == tamano) {
            agregarFinal(dato);
            return;
        }
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        NodoDoble<T> actual = primero;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        NodoDoble<T> anterior = actual.getAnterior();
        anterior.setSiguiente(nuevo);
        nuevo.setAnterior(anterior);
        nuevo.setSiguiente(actual);
        actual.setAnterior(nuevo);
        tamano++;
    }

    public boolean eliminar(T dato) {
        NodoDoble<T> actual = primero;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                if (actual == primero) {
                    primero = actual.getSiguiente();
                    if (primero != null)
                        primero.setAnterior(null);
                } else if (actual == ultimo) {
                    ultimo = actual.getAnterior();
                    if (ultimo != null)
                        ultimo.setSiguiente(null);
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                tamano--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void mostrar() {
        NodoDoble<T> actual = primero;
        while (actual != null) {
            T anterior = (actual.getAnterior() != null) ? actual.getAnterior().getDato() : null;
            T siguiente = (actual.getSiguiente() != null) ? actual.getSiguiente().getDato() : null;
            System.out.println("Dato: " + actual.getDato() +
                    " | Anterior: " + anterior +
                    " | Siguiente: " + siguiente);
            actual = actual.getSiguiente();
        }
    }

    public int getTamano() {
        return tamano;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private NodoDoble<T> actual = primero;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T dato = actual.getDato();
                actual = actual.getSiguiente();
                return dato;
            }
        };
    }
}