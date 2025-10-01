

import java.util.Iterator;

import Pila.Nodo;

public class ListaSimpleEnlazada<T extends Comparable<T>> implements Iterable<T> {
    private Nodo<T> primero;

    private int tamano;

    public ListaSimpleEnlazada() {
        this.primero = null;
        this.tamano = 0;
    }

    public void agregarNatural(Nodo<T> newNodo) {
        if (primero == null || newNodo.getDato().compareTo(primero.getDato()) < 0) {
            newNodo.setSiguiente(primero);
            primero = newNodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null &&
                    newNodo.getDato().compareTo(actual.getSiguiente().getDato()) > 0) {
                actual = actual.getSiguiente();
            }
            newNodo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(newNodo);
        }
        tamano++;
    }

    public boolean buscar(T dato) {
        Nodo<T> actual = primero;
        boolean flag = false;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                flag = true;
                break;
            }

            actual = actual.getSiguiente();
        }
        return flag;
    }

    public boolean eliminar(T dato) {
        Nodo<T> actual = primero;

        if (actual.getDato().equals(dato)) {
            primero = actual.getSiguiente();
            tamano--;
            return true;
        } else {

            while (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getDato().equals(dato)) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    tamano--;
                    return true;

                }
                actual = actual.getSiguiente();
            }
        }
        return false;
    }

    public void agregarPrimero(Nodo<T> newNodo) {
        newNodo.setSiguiente(primero);
        primero = newNodo;
        tamano++;
    }

    public void agregarEn(Nodo<T> nuevo, int indice) {
        if (indice == 0) {
            agregarPrimero(nuevo);
            return;
        }

        Nodo<T> actual = primero;
        int contador = 0;

        while (actual != null & contador < indice - 1) {
            actual = actual.getSiguiente();
            contador++;
        }

        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);

    }

    public void agregarFinal(Nodo<T> newNodo) {
        if (primero == null) {
            primero = newNodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(newNodo);
        }
        tamano++;
    }

    public void mostrar() {
        Nodo<T> actual = primero;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
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
        int contador = 0;
        while (actual != null) {
            if (contador == indice) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
            contador++;
        }
        return null;
    }

    public T buscarPorIndice(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo<T> actual = primero;
        int contador = 0;
        while (actual != null) {
            if (contador == indice) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
            contador++;
        }
        return null; // Nunca debería llegar aquí si el índice es válido
    }

    public boolean eliminarPorIndice(int indice) {
        if (indice < 0 || indice >= tamano) {
            return false;
        }
        if (indice == 0) {
            primero = primero.getSiguiente();
            tamano--;
            return true;
        }
        Nodo<T> actual = primero;
        int contador = 0;
        while (actual != null && contador < indice - 1) {
            actual = actual.getSiguiente();
            contador++;
        }
        if (actual != null && actual.getSiguiente() != null) {
            actual.setSiguiente(actual.getSiguiente().getSiguiente());
            tamano--;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = primero;

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
