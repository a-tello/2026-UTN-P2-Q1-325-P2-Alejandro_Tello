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

    
    @Override
    public String toString() {
        return "Socio{" + "legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + '}';
    }
    
    
    
    
}
