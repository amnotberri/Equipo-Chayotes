public abstract class abs6 implements interfaz6 {
    protected nodo6 cima;
    protected int tamano;

    public abs6() {
        this.cima = null;
        this.tamano = 0;
    }

    @Override
    public boolean estaVacia() {
        return cima == null;
    }
}