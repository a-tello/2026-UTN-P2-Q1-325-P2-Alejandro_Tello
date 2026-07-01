package sistemabibliotecadigitalutn;

import java.util.Scanner;

public class SistemaBibliotecaDigitalUTN {
    
    public static Scanner scanner = new Scanner(System.in);
    public static Biblioteca biblioteca = new Biblioteca();
    
    public static void main(String[] args) {
        biblioteca.inicializar();
        
        // DATOS DE PRUEBA. DESCOMENTAR PARA CARGAR
//        biblioteca.registrarLibro(new Libro("001", "Titulo1", "Autor1", "Materia1"));
//        biblioteca.registrarLibro(new Libro("002", "Titulo2", "Autor2", "Materia2"));
//        biblioteca.registrarLibro(new Libro("003", "Titulo3", "Autor3", "Materia3"));
//        biblioteca.registrarLibro(new Libro("004", "Titulo4", "Autor4", "Materia4"));
//        biblioteca.registrarLibro(new Libro("005", "Titulo5", "Autor5", "Materia5"));
//       
//        biblioteca.registrarSocio(new Socio(104418, "Ale", "Tello", 12345678));
//        biblioteca.registrarSocio(new Socio(104417, "Daniel", "Benitez", 22345678));
//        biblioteca.registrarSocio(new Socio(104416, "Iara", "Gallardo", 32345678));
//        biblioteca.registrarSocio(new Socio(104415, "Jose", "Hernandez", 42345678));
//        biblioteca.registrarSocio(new Socio(104414, "Ignacio", "Alvarado", 52345678));
//        
        int opcion;
        
        do {
            Consola.mostrarMenu();
            opcion = Validaciones.leerEntero("\nSeleccione una opcion: ");
            Consola.procesarOpcion(opcion);
        } while (opcion != 10);
        
        System.out.println("Saliendo del sistema...");
        
    }
    
}
