package lista_doble_simple;

import java.util.Iterator;

public class ListaDobleSimple<T extends Comparable<T>> implements Iterable<T> {
    private int tamano;
    private NodoCircular<T> primero;
    private NodoCircular<T> ultimo;

    public ListaDobleSimple() {
        this.primero = null;
        this.ultimo = null;
        this.tamano = 0;
    }

    public void agregarNatural(NodoCircular<T> newNodoCircular) {
        if (primero == null || newNodoCircular.getDato().compareTo(primero.getDato()) < 0) {
            newNodoCircular.setSiguiente(primero);
            primero = newNodoCircular;
        } else {
            NodoCircular<T> actual = primero;
            while (actual.getSiguiente() != null &&
                    newNodoCircular.getDato().compareTo(actual.getSiguiente().getDato()) > 0) {
                actual = actual.getSiguiente();
            }
            newNodoCircular.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(newNodoCircular);
        }
        tamano++;
    }

    public boolean buscar(T dato) {
        NodoCircular<T> actual = primero;
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
        NodoCircular<T> actual = primero;

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

    public void agregarPrimero(NodoCircular<T> newNodoCircular) {
        newNodoCircular.setSiguiente(primero);
        primero = newNodoCircular;
        tamano++;
    }

    public void agregarEn(NodoCircular nuevo, int indice) {
        if (indice == 0) {
            agregarPrimero(nuevo);
            return;
        }

        NodoCircular actual = primero;
        int contador = 0;

        while (actual != null & contador < indice - 1) {
            actual = actual.getSiguiente();
            contador++;
        }

        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);

    }

    public void agregarFinal(NodoCircular<T> newNodoCircular) {
        if (primero == null) {
            primero = newNodoCircular;
        } else {
            NodoCircular<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(newNodoCircular);
        }
        tamano++;
    }

    public void mostrar() {
        NodoCircular<T> actual = primero;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    public NodoCircular<T> getPrimero() {
        return primero;
    }

    public void setPrimero(NodoCircular<T> primero) {
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
        NodoCircular<T> actual = primero;
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
        NodoCircular<T> actual = primero;
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
        NodoCircular<T> actual = primero;
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
            private NodoCircular<T> actual = primero;

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
