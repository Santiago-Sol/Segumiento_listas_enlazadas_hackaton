

public class MainListas {

    public static void main(String[] args) {
        ListaSimpleEnlazada<String> lista = new ListaSimpleEnlazada<>();
        lista.agregarPrimero(new Nodo<>("uno"));
        lista.agregarPrimero(new Nodo<>("dos"));
        lista.agregarNatural(new Nodo<>("cinco"));
        lista.agregarFinal(new Nodo<>("cuatro"));
        lista.agregarPrimero(new Nodo<>("tres"));
        lista.agregarEn(new Nodo<>("Diez"), 3);
        ListaSimpleEnlazada<Integer> listaInt = new ListaSimpleEnlazada<>();
        listaInt.agregarNatural(new Nodo<>(2));
        listaInt.agregarNatural(new Nodo<>(1));
        listaInt.agregarNatural(new Nodo<>(4));
        listaInt.agregarNatural(new Nodo<>(3));

        System.out.println("Elemento encontrado en índice 3: " + listaInt.buscarPorIndice(3));

        listaInt.eliminarPorIndice(1);

        listaInt.mostrar(); 
        

    }

}