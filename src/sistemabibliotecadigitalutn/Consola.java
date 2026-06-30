
package sistemabibliotecadigitalutn;

import static sistemabibliotecadigitalutn.SistemaBibliotecaDigitalUTN.biblioteca;
import static sistemabibliotecadigitalutn.SistemaBibliotecaDigitalUTN.scanner;


public class Consola {
    
    public static void mostrarMenu() {
        System.out.println("==== SISTEMA DE BIBLIOTECA DIGITAL UTN ====\n");
        System.out.println("1. Registrar nuevo socio");
        System.out.println("2. Registrar nuevo libro");
        System.out.println("3. Listar socios registrados");
        System.out.println("4. Listar libros disponibles");
        System.out.println("5. Buscar libro");
        System.out.println("6. Registrar prestamo");
        System.out.println("7. Registrar devolucion");
        System.out.println("8. Mostrar prestamos activos");
        System.out.println("9. Generar informe institucional");
        System.out.println("10. Guardar y salir");
    }
    
    public static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> {registrarSocio();pausar();}
            case 2 -> {registrarLibro();pausar();}
            case 3 -> {}
            case 4 -> {}
            case 5 -> {}
            case 6 -> {}
            case 7 -> {}
            case 8 -> {}
            case 9 -> {}
            case 10 -> {}
            case 11 -> {}
            case 0 -> {}
            default -> {System.out.println("\n");} 
        }
                
    }
    
    public static void pausar() {
        System.out.println("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
    public static void registrarSocio() {
        int legajo = Validaciones.leerEntero("Ingrese numero de legajo: ");
        
        if (biblioteca.existeSocio(legajo)) {
            System.out.println("El socio de legajo " + legajo + " ya se encuentra registrado.");
            return;
        }
        
        String nombre = Validaciones.leerTexto("Ingrese nombre: ");
        String apellido = Validaciones.leerTexto("Ingrese apellido: ");
        int dni = Validaciones.leerEnteroRango("\nIngrese numero de DNI: ", 1000000, 100000000);
        
        try {
            Socio socio = new Socio(legajo, nombre, apellido, dni);
            biblioteca.registrarSocio(socio);
            System.out.println("Socio registrado correctamente");
        } catch (Exception e) {
            System.out.println("ERROR. " + e.getMessage());
        }
    }
    
    public static void registrarLibro() {
        String codigo = Validaciones.leerTexto("Ingrese codigo del libro: ");
        
        if (biblioteca.existeLibro(codigo)) {
            System.out.println("\nERROR. El libro de codigo " + codigo + " ya se encuentra registrado.");
            return;
        }
        
        String titulo = Validaciones.leerTexto("Ingrese titulo del libro: ");
        String autor = Validaciones.leerTexto("Ingrese autor: ");
        String materia = Validaciones.leerTexto("Ingrese materia: ");
        
        try {
            Libro libro = new Libro(codigo, titulo, autor, materia);
            biblioteca.registrarLibro(libro);
            System.out.println("Libro registrado con exito");
        } catch (Exception e) {
            System.out.println("ERROR. " + e.getMessage());
        }
    }
}
