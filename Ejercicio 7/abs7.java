public abstract class abs7 implements interfaz7 {
    protected nodo7 frente;
    protected nodo7 fin;
    protected int tamano;

    public abs7() {
        this.frente = null;
        this.fin = null;
        this.tamano = 0;
    }

    @Override
    public boolean estaVacia() {
        return frente == null;
    }
}