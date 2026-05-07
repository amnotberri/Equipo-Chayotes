import java.util.Scanner;

public class main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        implementacion6 miPila = new implementacion6();

        int opcion = -1;
        do {
            System.out.println("1. Push | 2. Pop | 3. Mostrar | 4. Burbuja | 5. Quicksort | 6. Mergesort | 0. Salir");
            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> { System.out.print("Valor: "); miPila.push(sc.nextInt()); }
                    case 2 -> System.out.println("Extraído: " + miPila.pop());
                    case 3 -> miPila.mostrarPila();
                    case 4 -> miPila.ordenarBurbuja();
                    case 5 -> miPila.ordenarQuicksort();
                    case 6 -> miPila.ordenarMergesort();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        } while (opcion != 0);
    }
}