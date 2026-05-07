public abstract class PilaBase implements Pila {
    protected int[] elementos;
    protected int tope;

    public PilaBase(int capacidad) {
        this.elementos = new int[capacidad];
        this.tope = -1;
    }

    @Override
    public boolean estaVacia() {
        return tope == -1;
    }

    @Override
    public boolean estaLlena() {
        return tope == elementos.length - 1;
    }
}