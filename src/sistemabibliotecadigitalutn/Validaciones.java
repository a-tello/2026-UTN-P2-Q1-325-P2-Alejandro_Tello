package sistemabibliotecadigitalutn;

import static sistemabibliotecadigitalutn.SistemaBibliotecaDigitalUTN.scanner;

public class Validaciones {
    
    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            if (scanner.hasNextInt()) {
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } else {
                System.out.println("Error Debe ingresar un numero entero.");
                scanner.nextLine();
            }
        }
    }
    
    public static int leerEnteroRango(String mensaje, int min, int max) {
        while (true) {
            int numero = leerEntero(mensaje);

            if (numero >= min && numero <= max) {
                return numero;
            }

            System.out.println("Error. El numero debe estar entre " + min + " y " + max + ".");
        }
    }
    
    public static String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);

            String texto = scanner.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println("Error. No puede dejar el campo vacío.");
        }
    }
}
