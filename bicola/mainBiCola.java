import Pila.Nodo;

public class mainBiCola {

    public static void main(String[] args) {
        BiCola biCola = new BiCola();
        biCola.agregarFinal(new Nodo(1));
        biCola.agregarFinal(new Nodo(2));
        biCola.agregarInicio(new Nodo(0));
        biCola.desencolar();
        biCola.desencolarFinal();
        System.out.println(biCola.getTamano());
    }
}   
    