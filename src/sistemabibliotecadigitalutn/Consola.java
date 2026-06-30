
package sistemabibliotecadigitalutn;

import java.util.ArrayList;
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
            case 3 -> {listarSocios();pausar();}
            case 4 -> {listarLibrosDisponibles();pausar();}
            case 5 -> {buscarLibroPorCodigo();pausar();}
            case 6 -> {registrarPrestamo();pausar();}
            case 7 -> {devolverLibro();pausar();}
            case 8 -> {mostrarPrestamosActivos();pausar();}
            case 9 -> {pausar();}
            case 10 -> {}
            default -> {System.out.println("\nDebe ingresar una opcion valida");} 
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
    
    public static void listarSocios() {
        ArrayList<Socio> socios = biblioteca.listarSocios();
        
        System.out.println("\n\nSOCIOS REGISTRADOS\n");
        
        for (Socio s : socios) {
            System.out.println(s);
            System.out.println("-----------------------------------");
        }
    }
    
    public static void listarLibrosDisponibles() {
        ArrayList<Libro> librosDisponibles = biblioteca.listarLibrosdisponibles();
        
        System.out.println("\n\nLIBROS DISPONIBLES\n");
        
        for (Libro l : librosDisponibles) {
            System.out.println(l);
            System.out.println("-----------------------------------");
        }
    }
    
    public static void buscarLibroPorCodigo() {
        String codigo = Validaciones.leerTexto("Ingrese codigo del libro: ");
        
        if (!biblioteca.existeLibro(codigo)) {
            System.out.println("\nERROR. El libro de codigo " + codigo + " NO se encuentra registrado.");
            return;
        }
        
        Libro libro = biblioteca.bucarLibro(codigo);
        
        System.out.println("\n\nLIBRO ENCONTRADO\n");
        System.out.println(libro);    
    }
    
    public static void registrarPrestamo() {
        String codigo = Validaciones.leerTexto("Ingrese codigo del libro: ");
        
        if (!biblioteca.existeLibro(codigo)) {
            System.out.println("\nERROR. El libro de codigo " + codigo + " NO se encuentra registrado.");
            return;
        } else if(!biblioteca.libroDisponible(codigo)) {
            System.out.println("\nERROR. El libro de codigo " + codigo + " no se encuentra disponible.");
            return;
        }
        
        int legajo = Validaciones.leerEntero("Ingrese su numero de legajo: ");
        
        if (!biblioteca.existeSocio(legajo)) {
            System.out.println("El socio de legajo " + legajo + " no se encuentra registrado.");
            return;
        }
        
        try {
            int numPrestamo = biblioteca.realizarPrestamo(codigo, legajo);
            System.out.println("Prestamo registrado bajo el numero: " + numPrestamo);
            System.out.println("El número de prestamo deberá ser ingresado para la devolucion");
        } catch (Exception e) {
            System.out.println("ERROR. " + e.getMessage());
        }
    }
    
    public static void devolverLibro() {
        int numPrestamo = Validaciones.leerEntero("Ingrese su numero de prestamo: ");
        
        if (!biblioteca.existePrestamo(numPrestamo)) {
            System.out.println("El prestamo " + numPrestamo + " no existe.");
            return;
        }
        
        try {
           biblioteca.realizarDevolucion(numPrestamo);
        } catch (Exception e) {
            System.out.println("ERROR. " + e.getMessage());
        }
    }
    
    public static void mostrarPrestamosActivos() {
        ArrayList<Prestamo> prestamosActivos = biblioteca.listarPrestamosActivos();
        
        System.out.println("\n\nPRESTAMOS ACTIVOS\n");
        
        for (Prestamo p : prestamosActivos) {
            System.out.println(p);
            System.out.println("-----------------------------------");
        }
    }
    
    public static <T> void imprimirArray(ArrayList<T> arreglo) {
        for (T elemento : arreglo) {
            System.out.println(elemento);
        }
    }

}
