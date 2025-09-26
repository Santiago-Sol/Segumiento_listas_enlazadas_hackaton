package lista_doble_simple;

public class MainSimpleDoble {
    

    public static void main(String[] args) {
        ListaDobleSimple<String> lista = new ListaDobleSimple<>();
        lista.agregarInicio("uno");
        lista.agregarInicio("dos");
        lista.agregarInicio("tres");
        lista.agregarInicio("cuatro");

        lista.mostrar();
    }
}
