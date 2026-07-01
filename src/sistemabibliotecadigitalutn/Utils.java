package sistemabibliotecadigitalutn;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

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
                       
            System.out.println("Objeto guardado");
            
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
        
//        public static <T> void serializar(List<T> datos, String rutaArchivo) {
//    try (FileOutputStream archivo = new FileOutputStream(rutaArchivo);
//         ObjectOutputStream salida = new ObjectOutputStream(archivo)) {
//
//        salida.writeObject(datos);
//
//        System.out.println("Objeto guardado");
//
//    } catch (Exception e) {
//        System.out.println("Error: " + e.getMessage());
//    }
}
