package sistemabibliotecadigitalutn;

import java.time.LocalDate;

public class Prestamo {
    private String codigo;
    private Libro libro;
    private Socio socio;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean estado;

    public Prestamo(String codigo, Libro libro, Socio socio, LocalDate fechaPrestamo, boolean estado) {
        this.codigo = codigo;
        this.libro = libro;
        this.socio = socio;
        this.fechaPrestamo = LocalDate.now();
        this.estado = true;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "codigo=" + codigo + ", libro=" + libro + ", socio=" + socio + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + ", estado=" + estado + '}';
    }
    
    
}
