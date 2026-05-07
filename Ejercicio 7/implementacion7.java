import java.util.Arrays;

public class implementacion7 extends abs7 {

    @Override
    public void enqueue(int elemento) {
        nodo7 nuevo = new nodo7(elemento);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.siguiente = nuevo;
        }
        fin = nuevo;
        tamano++;
    }

    @Override
    public int dequeue() {
        if (estaVacia()) throw new RuntimeException("Error: Cola vacía");
        int valor = frente.valor;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        tamano--;
        return valor;
    }

    private int[] copiarAArreglo() {
        int[] arr = new int[tamano];
        nodo7 temp = frente;
        for (int i = 0; i < tamano; i++) {
            arr[i] = temp.valor;
            temp = temp.siguiente;
        }
        return arr;
    }

    private void reconstruirDesdeArreglo(int[] arr) {
        frente = null;
        fin = null;
        tamano = 0;
        for (int valor : arr) {
            enqueue(valor);
        }
    }

    @Override
    public void ordenarBurbuja() {
        if (tamano < 2) return;
        int[] arr = copiarAArreglo();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = t;
                }
            }
        }
        reconstruirDesdeArreglo(arr);
    }

    @Override
    public void ordenarQuicksort() {
        if (tamano < 2) return;
        int[] arr = copiarAArreglo();
        quicksort(arr, 0, arr.length - 1);
        reconstruirDesdeArreglo(arr);
    }

    private void quicksort(int[] a, int b, int h) {
        if (b < h) {
            int p = particion(a, b, h);
            quicksort(a, b, p - 1);
            quicksort(a, p + 1, h);
        }
    }

    private int particion(int[] a, int b, int h) {
        int pivote = a[h];
        int i = b - 1;
        for (int j = b; j < h; j++) {
            if (a[j] < pivote) {
                i++;
                int t = a[i]; a[i] = a[j]; a[j] = t;
            }
        }
        int t = a[i + 1]; a[i + 1] = a[h]; a[h] = t;
        return i + 1;
    }

    @Override
    public void ordenarMergesort() {
        if (tamano < 2) return;
        int[] arr = copiarAArreglo();
        mergesort(arr, 0, arr.length - 1);
        reconstruirDesdeArreglo(arr);
    }

    private void mergesort(int[] a, int i, int d) {
        if (i < d) {
            int m = i + (d - i) / 2;
            mergesort(a, i, m);
            mergesort(a, m + 1, d);
            merge(a, i, m, d);
        }
    }

    private void merge(int[] a, int i, int m, int d) {
        int[] L = Arrays.copyOfRange(a, i, m + 1);
        int[] R = Arrays.copyOfRange(a, m + 1, d + 1);
        int x = 0, y = 0, k = i;
        while (x < L.length && y < R.length) {
            if (L[x] <= R[y]) a[k++] = L[x++];
            else a[k++] = R[y++];
        }
        while (x < L.length) a[k++] = L[x++];
        while (y < R.length) a[k++] = R[y++];
    }

    public void mostrarCola() {
        if (estaVacia()) { System.out.println("Cola vacía"); return; }
        nodo7 temp = frente;
        System.out.print("Frente -> ");
        while (temp != null) {
            System.out.print("[" + temp.valor + "] ");
            temp = temp.siguiente;
        }
        System.out.println("Fin");
    }
}