package practica5;
public class implementacion5 extends abs5 {

    public implementacion5(int capacidad) {
        super(capacidad);
    }

    @Override
    public void insertar(int elemento) {
        if (estaLlena()) throw new RuntimeException("Lista llena");
        elementos[cantidad++] = elemento;
    }

    @Override
    public void insertarEn(int indice, int elemento) {
        if (estaLlena()) throw new RuntimeException("Lista llena");
        if (indice < 0 || indice > cantidad) throw new IndexOutOfBoundsException("Fuera de rango");

        for (int i = cantidad; i > indice; i--) {
            elementos[i] = elementos[i - 1];
        }
        elementos[indice] = elemento;
        cantidad++;
    }

    @Override
    public int eliminar(int indice) {
        if (estaVacia()) throw new RuntimeException("Lista vacía");
        if (indice < 0 || indice >= cantidad) throw new IndexOutOfBoundsException("Inválido.");

        int eliminado = elementos[indice];
        for (int i = indice; i < cantidad - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        cantidad--;
        return eliminado;
    }

    @Override
    public int obtener(int indice) {
        if (indice < 0 || indice >= cantidad) throw new IndexOutOfBoundsException("Inválido.");
        return elementos[indice];
    }

    @Override
    public void ordenarBurbuja() {
        for (int i = 0; i < cantidad - 1; i++) {
            for (int j = 0; j < cantidad - i - 1; j++) {
                if (elementos[j] > elementos[j + 1]) {
                    intercambiar(j, j + 1);
                }
            }
        }
    }

    @Override
    public void ordenarQuicksort() {
        if (cantidad > 0) ejecutarQuicksort(0, cantidad - 1);
    }

    private void ejecutarQuicksort(int bajo, int alto) {
        if (bajo < alto) {
            int pi = particion(bajo, alto);
            ejecutarQuicksort(bajo, pi - 1);
            ejecutarQuicksort(pi + 1, alto);
        }
    }

    private int particion(int bajo, int alto) {
        int pivote = elementos[alto];
        int i = (bajo - 1);
        for (int j = bajo; j < alto; j++) {
            if (elementos[j] < pivote) {
                i++;
                intercambiar(i, j);
            }
        }
        intercambiar(i + 1, alto);
        return i + 1;
    }

    @Override
    public void ordenarMergesort() {
        if (cantidad > 1) ejecutarMergesort(0, cantidad - 1);
    }

    private void ejecutarMergesort(int izq, int der) {
        if (izq < der) {
            int m = izq + (der - izq) / 2;
            ejecutarMergesort(izq, m);
            ejecutarMergesort(m + 1, der);
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

    public void mostrarLista() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        System.out.print("Contenido de la lista: ");
        for (int i = 0; i < cantidad; i++) {
            System.out.print("[" + elementos[i] + "] ");
        }
        System.out.println();
    }
}