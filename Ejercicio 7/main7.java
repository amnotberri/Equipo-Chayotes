import java.util.Scanner;

public class main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        implementacion7 miCola = new implementacion7();

        int opcion = -1;
        do {
            System.out.println("1. Enqueue | 2. Dequeue | 3. Mostrar | 4. Burbuja | 5. Quicksort | 6. Mergesort | 0. Salir");
            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> { System.out.print("Valor: "); miCola.enqueue(sc.nextInt()); }
                    case 2 -> System.out.println("Atendido: " + miCola.dequeue());
                    case 3 -> miCola.mostrarCola();
                    case 4 -> miCola.ordenarBurbuja();
                    case 5 -> miCola.ordenarQuicksort();
                    case 6 -> miCola.ordenarMergesort();
                    case 0 -> System.out.println("Cerrando...");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        } while (opcion != 0);
    }
}