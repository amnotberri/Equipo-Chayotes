public abstract class abs4 implements interfaz4 {
    protected int[] elementos;
    protected int frente;
    protected int finalCola;
    protected int tamActual;

    public abs4(int capacidad) {
        this.elementos = new int[capacidad];
        this.frente = 0;
        this.finalCola = -1;
        this.tamActual = 0;
    }

    @Override
    public boolean estaVacia() {
        return tamActual == 0;
    }

    @Override
    public boolean estaLlena() {
        return tamActual == elementos.length;
    }
}