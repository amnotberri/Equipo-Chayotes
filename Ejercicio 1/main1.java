import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        implementacion1 lista = new implementacion1();

        System.out.println("¿Cuántas personas deseas registrar?");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nPersona " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine();
            
            lista.agregarPersona(nombre, edad);
        }

        lista.mostrarLista();
        
        System.out.println("\n¿Deseas ordenar la lista por edad? (1: Sí / 0: No)");
        if (sc.nextInt() == 1) {
            lista.ordenarPorEdadBurbuja();
            lista.mostrarLista();
        }

        System.out.println("Fin");
        sc.close();
    }
}