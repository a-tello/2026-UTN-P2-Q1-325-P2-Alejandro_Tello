package sistemabibliotecadigitalutn;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Utils {
    public static void escribirTexto(String rutaArchivo, String contenido){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            bw.write(contenido);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void serializar(Repositorio datos, String rutaArchivo) {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
           
            salida.writeObject(datos);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static Repositorio deserializar(String rutaArchivo) {
        try (FileInputStream archivoLectura = new FileInputStream(rutaArchivo);
             ObjectInputStream entrada = new ObjectInputStream(archivoLectura)) {

            return (Repositorio) entrada.readObject();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        } 
    }
}
