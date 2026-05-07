package practica5;
public abstract class abs5 implements interfaz5 {
    protected int[] elementos;
    protected int cantidad;

    public abs5(int capacidad) {
        this.elementos = new int[capacidad];
        this.cantidad = 0;
    }

    @Override
    public boolean estaVacia() {
        return cantidad == 0;
    }

    @Override
    public boolean estaLlena() {
        return cantidad == elementos.length;
    }

    @Override
    public int tamaño() {
        return cantidad;
    }
}