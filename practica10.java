import java.util.Scanner;

public class practica10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] datos = new int[5]; 
        
        for (int i = 0; i < 5; i++) {
            System.out.print("Ingrese el número " + (i + 1) + ": ");
            datos[i] = sc.nextInt();
        }

        int suma = 0;
        int max = datos[0];
        int min = datos[0];

        for (int i = 0; i < 5; i++) {
            int valorActual = datos[i];
            
            suma += valorActual;

            if (valorActual > max) max = valorActual;
            if (valorActual < min) min = valorActual;
        }

        double promedio = suma / 5.0;

        java.util.Arrays.sort(datos);
        int media = datos[2]; 

        System.out.println("Suma: " + suma);
        System.out.println("Promedio: " + promedio);
        System.out.println("Media (valor central): " + media);
        System.out.println("Máximo: " + max);
        System.out.println("Mínimo: " + min);
        
        sc.close();
    }
}