public class PilaEstatica extends PilaBase {

    public PilaEstatica(int capacidad) {
        super(capacidad);
    }

    @Override
    public void push(int elemento) {
        if (estaLlena()) throw new RuntimeException("Error: Pila llena");
        elementos[++tope] = elemento;
    }

    @Override
    public int pop() {
        if (estaVacia()) throw new RuntimeException("Error: Pila vacía");
        return elementos[tope--];
    }

    @Override
    public void ordenarBurbuja() {
        for (int i = 0; i < tope; i++) {
            for (int j = 0; j < tope - i; j++) {
                if (elementos[j] > elementos[j + 1]) {
                    intercambiar(j, j + 1);
                }
            }
        }
    }

    @Override
    public void ordenarQuicksort() {
        quicksort(0, tope);
    }

    private void quicksort(int bajo, int alto) {
        if (bajo < alto) {
            int pi = particion(bajo, alto);
            quicksort(bajo, pi - 1);
            quicksort(pi + 1, alto);
        }
    }

    private int particion(int bajo, int alto) {
        int pivote = elementos[alto];
        int i = (bajo - 1);
        for (int j = bajo; j < alto; j++) {
            if (elementos[j], <= pivote) {
                i++;
                intercambiar(i, j);
            }
        }
        intercambiar(i + 1, alto);
        return i + 1;
    }

    @Override
    public void ordenarMergesort() {
        if (tope < 1) return;
        mergesort(0, tope);
    }

    private void mergesort(int izq, int der) {
        if (izq < der) {
            int m = izq + (der - izq) / 2;
            mergesort(izq, m);
            mergesort(m + 1, der);
            merge(izq, m, der);
        }
    }

    private void merge(int izq, int m, int der) {
        int n1 = m - izq + 1;
        int n2 = der - m;
        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(elementos, izq, L, 0, n1);
        System.arraycopy(elementos, m + 1, R, 0, n2);

        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) elementos[k++] = L[i++];
            else elementos[k++] = R[j++];
        }
        while (i < n1) elementos[k++] = L[i++];
        while (j < n2) elementos[k++] = R[j++];
    }

    private void intercambiar(int i, int j) {
        int temp = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = temp;
    }

    public void mostrarPila() {
        if (estaVacia()) {
            System.out.println("Pila vacía.");
            return;
        }
        System.out.print("Estado de la pila: ");
        for (int i = 0; i <= tope; i++) {
            System.out.print("[" + elementos[i] + "] ");
        }
        System.out.println();
    }
}