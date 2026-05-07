public class implementacion1 extends abs1 {

    @Override
    public void agregarPersona(String nombre, int edad) {
        persona1 nuevaPersona = new persona1(nombre, edad);
        if (cabeza == null) {
            cabeza = nuevaPersona;
        } else {
            persona1 actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevaPersona;
        }
        contador++;
    }

    @Override
    public void mostrarLista() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        persona1 actual = cabeza;
        System.out.println("\n Lista de Personas:");
        while (actual != null) {
            System.out.println("Nombre: " + actual.nombre + " | Edad: " + actual.edad + " años");
            actual = actual.siguiente;
        }
    }

    @Override
    public void ordenarPorEdadBurbuja() {
        if (contador < 2) return;
        
        boolean intercambiado;
        do {
            intercambiado = false;
            persona1 actual = cabeza;
            persona1 siguienteNode = cabeza.siguiente;

            while (siguienteNode != null) {
                if (actual.edad > siguienteNode.edad) {
                    int tempEdad = actual.edad;
                    String tempNombre = actual.nombre;
                    
                    actual.edad = siguienteNode.edad;
                    actual.nombre = siguienteNode.nombre;
                    
                    siguienteNode.edad = tempEdad;
                    siguienteNode.nombre = tempNombre;
                    
                    intercambiado = true;
                }
                actual = siguienteNode;
                siguienteNode = siguienteNode.siguiente;
            }
        } while (intercambiado);
        System.out.println("Lista ordenada por edad");
    }
}