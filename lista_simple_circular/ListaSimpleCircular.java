

import java.util.Iterator;

import Pila.Nodo;

public class ListaSimpleCircular<T extends Comparable<T>> implements Iterable<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamano;

    public ListaSimpleCircular() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    public void ordenarAscendente(Nodo<T> newNodo) {
        if (primero == null) {
            primero = ultimo = newNodo;
            ultimo.setSiguiente(primero);
        } else if (newNodo.getDato().compareTo(primero.getDato()) < 0) {
            newNodo.setSiguiente(primero);
            primero = newNodo;
            ultimo.setSiguiente(primero);
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != primero &&
                    newNodo.getDato().compareTo(actual.getSiguiente().getDato()) > 0) {
                actual = actual.getSiguiente();
            }
            newNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(newNodo);
            if (actual == ultimo) {
                ultimo = newNodo;
            }
        }
        tamano++;
    }

    public void agregarNatural(Nodo<T> newNodo) {
        if (primero == null) {
            primero = ultimo = newNodo;
            ultimo.setSiguiente(primero);
        } else if (newNodo.getDato().compareTo(primero.getDato()) < 0) {
            newNodo.setSiguiente(primero);
            primero = newNodo;
            ultimo.setSiguiente(primero);
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != primero &&
                    newNodo.getDato().compareTo(actual.getSiguiente().getDato()) > 0) {
                actual = actual.getSiguiente();
            }
            newNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(newNodo);
            if (actual == ultimo) {
                ultimo = newNodo;
            }
        }
        tamano++;
    }

    public boolean buscar(T dato) {
        if (primero == null) return false;
        Nodo<T> actual = primero;
        do {
            if (actual.getDato().equals(dato)) return true;
            actual = actual.getSiguiente();
        } while (actual != primero);
        return false;
    }

    public boolean eliminar(T dato) {
        if (primero == null) return false;
        Nodo<T> actual = primero;
        Nodo<T> anterior = ultimo;
        do {
            if (actual.getDato().equals(dato)) {
                if (actual == primero) {
                    if (primero == ultimo) {
                        primero = ultimo = null;
                    } else {
                        primero = primero.getSiguiente();
                        ultimo.setSiguiente(primero);
                    }
                } else {
                    anterior.setSiguiente(actual.getSiguiente());
                    if (actual == ultimo) {
                        ultimo = anterior;
                    }
                }
                tamano--;
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        } while (actual != primero);
        return false;
    }

    public void agregarPrimero(Nodo<T> newNodo) {
        if (primero == null) {
            primero = ultimo = newNodo;
            ultimo.setSiguiente(primero);
        } else {
            newNodo.setSiguiente(primero);
            primero = newNodo;
            ultimo.setSiguiente(primero);
        }
        tamano++;
    }

    public void agregarEn(Nodo<T> nuevo, int indice) {
        if (indice < 0 || indice > tamano) return;
        if (indice == 0) {
            agregarPrimero(nuevo);
            return;
        }
        Nodo<T> actual = primero;
        for (int i = 0; i < indice - 1; i++) {
            actual = actual.getSiguiente();
        }
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        if (actual == ultimo) {
            ultimo = nuevo;
        }
        tamano++;
    }

    public void agregarFinal(Nodo<T> newNodo) {
        if (primero == null) {
            primero = ultimo = newNodo;
            ultimo.setSiguiente(primero);
        } else {
            ultimo.setSiguiente(newNodo);
            ultimo = newNodo;
            ultimo.setSiguiente(primero);
        }
        tamano++;
    }

    public void mostrar() {
        if (primero == null) return;
        Nodo<T> actual = primero;
        do {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        } while (actual != primero);
    }

    public Nodo<T> getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo<T> primero) {
        this.primero = primero;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public T localizarPorIndice(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo<T> actual = primero;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    public T buscarPorIndice(int indice) {
        return localizarPorIndice(indice);
    }

    public boolean eliminarPorIndice(int indice) {
        if (indice < 0 || indice >= tamano) return false;
        if (indice == 0) {
            if (primero == ultimo) {
                primero = ultimo = null;
            } else {
                primero = primero.getSiguiente();
                ultimo.setSiguiente(primero);
            }
            tamano--;
            return true;
        }
        Nodo<T> actual = primero;
        for (int i = 0; i < indice - 1; i++) {
            actual = actual.getSiguiente();
        }
        Nodo<T> aEliminar = actual.getSiguiente();
        actual.setSiguiente(aEliminar.getSiguiente());
        if (aEliminar == ultimo) {
            ultimo = actual;
        }
        tamano--;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = primero;
            private boolean primeraVez = true;

            @Override
            public boolean hasNext() {
                return actual != null && (primeraVez || actual != primero);
            }

            @Override
            public T next() {
                T dato = actual.getDato();
                actual = actual.getSiguiente();
                primeraVez = false;
                return dato;
            }
        };
    }
}
