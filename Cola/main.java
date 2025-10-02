import Pila.Nodo;

public class main {

    public main(String[] args) {
        Cola cola = new Cola();
        cola.encolar(new Nodo(1));
        cola.encolar(new Nodo(2));

        cola.desencolar();
        System.out.println(cola.getTamano());
    }
}   
    