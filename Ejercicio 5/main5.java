package practica5;
import java.util.Scanner;

public class main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Capacidad de la lista: ");
        implementacion5 miLista = new implementacion5(sc.nextInt());

        int opcion = -1;
        do {
            System.out.println("1. Insertar Final | 2. Insertar en Posición | 3. Eliminar por Índice");
            System.out.println("4. Mostrar        | 5. Burbuja              | 6. Quicksort");
            System.out.println("7. Mergesort      | 0. Salir");
            System.out.print("Opción: ");

            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> { System.out.print("Valor: "); miLista.insertar(sc.nextInt()); }
                    case 2 -> {
                        System.out.print("Índice: "); int idx = sc.nextInt();
                        System.out.print("Valor: "); int val = sc.nextInt();
                        miLista.insertarEn(idx, val);
                    }
                    case 3 -> {
                        System.out.print("Índice a eliminar: ");
                        System.out.println("Eliminado: " + miLista.eliminar(sc.nextInt()));
                    }
                    case 4 -> miLista.mostrarLista();
                    case 5 -> miLista.ordenarBurbuja();
                    case 6 -> miLista.ordenarQuicksort();
                    case 7 -> miLista.ordenarMergesort();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        } while (opcion != 0);
    }
}