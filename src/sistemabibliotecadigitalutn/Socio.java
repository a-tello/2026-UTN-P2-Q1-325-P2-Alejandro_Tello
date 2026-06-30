package sistemabibliotecadigitalutn;

public class Socio {
    private int legajo;
    private String nombre;
    private String apellido;
    private int dni;

    public Socio(int legajo, String nombre, String apellido, int dni) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    
    
    
    @Override
    public String toString() {
        return "Legajo: " + legajo + "\nNombre completo: " + nombre + " " + apellido + "\nDNI: " + dni;
    }
    
    
    
    
}
