import java.util.Arrays;

public class implementacion4 extends abs4 {

    public implementacion4 (int capacidad) {
        super(capacidad);
    }

    @Override
    public void enqueue(int elemento) {
        if (estaLlena()) throw new RuntimeException("Error: Cola llena");
        finalCola = (finalCola + 1) % elementos.length;
        elementos[finalCola] = elemento;
        tamActual++;
    }

    @Override
    public int dequeue() {
        if (estaVacia()) throw new RuntimeException("Error: Cola vacía");
        int aux = elementos[frente];
        frente = (frente + 1) % elementos.length;
        tamActual--;
        return aux;
    }

    @Override
    public void ordenarBurbuja() {
        for (int i = 0; i < tamActual - 1; i++) {
            for (int j = 0; j < tamActual - i - 1; j++) {
                int idx1 = (frente + j) % elementos.length;
                int idx2 = (frente + j + 1) % elementos.length;
                if (elementos[idx1] > elementos[idx2]) {
                    intercambiar(idx1, idx2);
                }
            }
        }
    }

    @Override
    public void ordenarQuicksort() {
        ejecutarQuicksort(0, tamActual - 1);
    }

    private void ejecutarQuicksort(int bajo, int alto) {
        if (bajo < alto) {
            int pi = particion(bajo, alto);
            ejecutarQuicksort(bajo, pi - 1);
            ejecutarQuicksort(pi + 1, alto);
        }
    }

    private int particion(int bajo, int alto) {
        int realAlto = (frente + alto) % elementos.length;
        int pivote = elementos[realAlto];
        int i = (bajo - 1);
        for (int j = bajo; j < alto; j++) {
            int realJ = (frente + j) % elementos.length;
            if (elementos[realJ] < pivote) {
                i++;
                int realI = (frente + i) % elementos.length;
                intercambiar(realI, realJ);
            }
        }
        int realIplus1 = (frente + i + 1) % elementos.length;
        intercambiar(realIplus1, realAlto);
        return i + 1;
    }

    @Override
    public void ordenarMergesort() {
        if (tamActual > 1) ejecutarMergesort(0, tamActual - 1);
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

        for (int i = 0; i < n1; i++) L[i] = elementos[(frente + izq + i) % elementos.length];
        for (int j = 0; j < n2; j++) R[j] = elementos[(frente + m + 1 + j) % elementos.length];

        int i = 0, j = 0, k = izq;
        while (i < n1 && j < n2) {
            int realK = (frente + k) % elementos.length;
            if (L[i] <= R[j]) elementos[realK] = L[i++];
            else elementos[realK] = R[j++];
            k++;
        }
        while (i < n1) elementos[(frente + k++) % elementos.length] = L[i++];
        while (j < n2) elementos[(frente + k++) % elementos.length] = R[j++];
    }

    private void intercambiar(int i, int j) {
        int temp = elementos[i];
        elementos[i] = elementos[j];
        elementos[j] = temp;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("Cola vacía.");
            return;
        }
        System.out.print("Estado de la cola: ");
        for (int i = 0; i < tamActual; i++) {
            System.out.print("[" + elementos[(frente + i) % elementos.length] + "] ");
        }
        System.out.println();
    }
}