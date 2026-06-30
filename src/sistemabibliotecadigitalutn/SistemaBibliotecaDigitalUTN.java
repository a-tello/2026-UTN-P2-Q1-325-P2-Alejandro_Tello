package sistemabibliotecadigitalutn;

import java.util.Scanner;

public class SistemaBibliotecaDigitalUTN {
    
    public static Scanner scanner = new Scanner(System.in);
    public static Biblioteca biblioteca = new Biblioteca();
    
    public static void main(String[] args) {
        int opcion;
        
        do {
            Consola.mostrarMenu();
            opcion = Validaciones.leerEntero("\nSeleccione una opcion: ");
            Consola.procesarOpcion(opcion);
        } while (opcion != 10);
        
        System.out.println("Saliendo del sistema...");
        
    }
    
}
