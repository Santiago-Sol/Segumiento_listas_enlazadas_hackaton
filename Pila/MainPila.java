package Pila;

public class MainPila {
    
    public static void main(String[] args) {
        Pila pila = new Pila();
        pila.empilar(new Nodo(1));
        pila.empilar(new Nodo(2));
        pila.empilar(new Nodo(3));

        pila.desempilar();
        
        System.out.println(pila.getTamano());
    }
}
