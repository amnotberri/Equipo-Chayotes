import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PilaEstatica miPila = null;

        while (miPila == null) {
            try {
                System.out.print("Capacidad de la pila: ");
                int tam = sc.nextInt();
                miPila = new PilaEstatica(tam);
            } catch (InputMismatchException e) {
                System.out.println("Error");
                sc.next();
            }
        }

        int opcion = -1;
        do {
            System.out.println("1. Push (Insertar) | 2. Pop (Eliminar) | 3. Mostrar");
            System.out.println("4. Burbuja         | 5. Quicksort      | 6. Mergesort");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> {
                        System.out.print("Ingresar número: ");
                        miPila.push(sc.nextInt());
                    }
                    case 2 -> System.out.println("Elemento extraído: " + miPila.pop());
                    case 3 -> miPila.mostrarPila();
                    case 4 -> { miPila.ordenarBurbuja(); System.out.println("Ordenado por Burbuja."); }
                    case 5 -> { miPila.ordenarQuicksort(); System.out.println("Ordenado por Quicksort."); }
                    case 6 -> { miPila.ordenarMergesort(); System.out.println("Ordenado por Mergesort."); }
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Error: Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida.");
                sc.next();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 0);
        
        sc.close();
    }
}