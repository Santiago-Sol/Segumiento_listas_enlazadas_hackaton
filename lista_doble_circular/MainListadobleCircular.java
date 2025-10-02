package lista_doble_circular;

public class MainListadobleCircular {

    public static void main(String[] args) {
        listaDobleCircular<String> lista = new listaDobleCircular<>();
        lista.agregarInicio(new Nodo<>("C"));
        lista.agregarInicio(new Nodo<>("A"));

        lista.ordenarAscendente(new Nodo<>("B"));
    }

}