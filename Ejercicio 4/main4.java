import java.util.Scanner;
import java.util.InputMismatchException;

public class main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        interfaz4 miCola = null;

        while (miCola == null) {
            try {
                System.out.print("Capacidad de la cola: ");
                miCola = new implementacion4(sc.nextInt());
            } catch (Exception e) {
                System.out.println("Error de capacidad");
                sc.next();
            }
        }

        int opcion = -1;
        do {
            System.out.println("1. Enqueue | 2. Dequeue | 3. Mostrar | 4. Burbuja | 5. Quicksort | 6. Mergesort | 0. Salir");
            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> { System.out.print("Número: "); miCola.enqueue(sc.nextInt()); }
                    case 2 -> System.out.println("Atendido: " + miCola.dequeue());
                    case 3 -> miCola.mostrarCola();
                    case 4 -> miCola.ordenarBurbuja();
                    case 5 -> miCola.ordenarQuicksort();
                    case 6 -> miCola.ordenarMergesort();
                }
            } catch (InputMismatchException e) {
                System.out.println("Error");
                sc.next();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 0);
    }
}