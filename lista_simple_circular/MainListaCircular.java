


public class MainListaCircular {

    public static void main(String[] args) {
        ListaSimpleCircular<String> lista = new ListaSimpleCircular<>();
        lista.agregarPrimero(new Nodo<>("uno"));
        lista.agregarPrimero(new Nodo<>("dos"));
        lista.agregarPrimero(new Nodo<>("cinco"));
        lista.agregarPrimero(new Nodo<>("cuatro"));

        lista.mostrar();
        

    }

}