package sistemabibliotecadigitalutn;

import java.io.Serializable;
import java.time.LocalDate;

public class Prestamo implements Serializable{
    private int codigo;
    private Libro libro;
    private Socio socio;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean estado;

    public Prestamo(int codigo, Libro libro, Socio socio) {
        this.codigo = codigo;
        this.libro = libro;
        this.socio = socio;
        this.fechaPrestamo = LocalDate.now();
        this.estado = true;
    }

    public int getCodigo() {
        return codigo;
    }

    public Libro getLibro() {
        return libro;
    }

    public boolean getEstado() {
        return estado;
    }
    
    
    
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Prestamo:   " + codigo + "\nLibro:  " + libro.getTitulo() + "\nSocio:   " + socio.getApellido() + " " + socio.getNombre() + 
                "\nFecha del prestamo:  " + fechaPrestamo + "\nEstado: " + estado;
    }
    
    
}
