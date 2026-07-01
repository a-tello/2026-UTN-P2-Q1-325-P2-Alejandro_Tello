package sistemabibliotecadigitalutn;

import java.io.Serializable;

public class Libro implements Serializable{
    private String codigo;
    private String titulo;
    private String autor;
    private String materia;
    private boolean disponible;
    private int prestado;

    public Libro(String codigo, String titulo, String autor, String materia) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.materia = materia;
        this.disponible = true;
        this.prestado = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }
    
    

    public boolean estaDisponible() {
        return disponible;
    }
    
    

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    
    
    

    @Override
    public String toString() {
        return "Codigo: " + codigo + "\nTitulo: " + titulo + "\nAutor:  " + autor + "\nMateria: " + materia + "\nDisponible:    " + (disponible ? "Si" : "No");
    }
    
    
}
