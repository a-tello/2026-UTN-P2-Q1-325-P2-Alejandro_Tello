package sistemabibliotecadigitalutn;

import java.io.File;
import java.security.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
    private Repositorio<String, Libro> repoLibros;
    private Repositorio<Integer, Socio> repoSocios;
    private Repositorio<Integer, Prestamo> repoPrestamos;
    private int codigoPrestamo;

    public Biblioteca() {
        this.repoLibros = new Repositorio<>();
        this.repoSocios = new Repositorio<>();
        this.repoPrestamos = new Repositorio<>();
        this.codigoPrestamo = 1;
        inicializar();
    }

    public Biblioteca(Repositorio<String, Libro> repoLibros, Repositorio<Integer, Socio> repoSocios, Repositorio<Integer, Prestamo> repoPrestamos) {
        this.repoLibros = repoLibros;
        this.repoSocios = repoSocios;
        this.repoPrestamos = repoPrestamos;
        this.codigoPrestamo = repoSocios.length() + 1;
    }
    
    
    
    public void registrarSocio(Socio socio) {
        repoSocios.registrar(socio.getLegajo(), socio);
    }
    
    public void registrarLibro(Libro libro) { 
        repoLibros.registrar(libro.getCodigo(), libro);
    }
    
    public ArrayList listarSocios() {
        return repoSocios.listar();
    }
    
    public ArrayList<Libro> listarLibrosdisponibles() {
        ArrayList<Libro> librosDisponibles = new ArrayList<>();
        ArrayList<Libro> libros = repoLibros.listar();
        
        for (Libro l : libros) {
            if (l.estaDisponible()) {
                librosDisponibles.add(l);
            }
        }
        
        return librosDisponibles;
    }
    
    public ArrayList<Prestamo> listarPrestamosActivos() {
        ArrayList<Prestamo> prestamosActivos = new ArrayList<>();
        ArrayList<Prestamo> prestamos = repoPrestamos.listar();
        
        for (Prestamo p : prestamos) {
            if (p.getEstado()) {
                prestamosActivos.add(p);
            }
        }
        
        return prestamosActivos;
    }
    
    public boolean existeSocio(int legajo) {
        return repoSocios.existe(legajo);
    }
    
    public boolean existeLibro(String codigo) {
        return repoLibros.existe(codigo);
    }
    
    public boolean existePrestamo(int codigo) {
        return repoPrestamos.existe(codigo);
    }
    
    public boolean libroDisponible(String codigo) {
        Libro libro = repoLibros.buscar(codigo);
        
        return libro.estaDisponible();
        
    }
    
    public Libro bucarLibro(String codigo) {
        return repoLibros.buscar(codigo);
    }
    
    public void registrarPrestamo(Libro libro, Socio socio) {
        Prestamo prestamo = new Prestamo(codigoPrestamo++, libro, socio);
        repoPrestamos.registrar(prestamo.getCodigo(), prestamo);
    }
    
    public int realizarPrestamo(String codigo, int legajo) {
        Libro libro = repoLibros.buscar(codigo);
        Socio socio = repoSocios.buscar(legajo);
        
        libro.setDisponible(false);
        registrarPrestamo(libro, socio);
        return codigoPrestamo - 1;
    }
    
    public void realizarDevolucion(int codigoPrestamo) {
        Prestamo prestamo = repoPrestamos.buscar(codigoPrestamo);
        prestamo.setEstado(false);
        prestamo.setFechaDevolucion(LocalDate.now());
        Libro libro = prestamo.getLibro();
        libro.setDisponible(true);
    }
    
    public void generarInforme() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== REPORTE INSTITUCIONAL =====\n\n");
        
        LocalDate fecha = LocalDate.now();
        int socios = repoSocios.length();
        int libros = repoLibros.length();
        int prestamos = listarPrestamosActivos().size();
        int librosDisponibles = listarLibrosdisponibles().size();
                
      
        sb.append("FECHA DE GENERACION: ").append(fecha).append("\n");
        sb.append("CANTIDAD DE SOCIOS:  ").append(socios).append("\n");
        sb.append("CANTIDAD DE LIBROS:  ").append(libros).append("\n");
        sb.append("PRESTAMOS ACTIVOS:   ").append(prestamos).append("\n");
        sb.append("LIBROS DISPONIBLES:  ").append(librosDisponibles).append("\n");
        sb.append("----------------------------------------\n");

        Utils.escribirTexto("informe.txt", sb.toString());
    }
    
    public void guardarInformacion() {
        Utils.serializar(repoLibros, "libros.dat");
        Utils.serializar(repoSocios, "socios.dat");
        Utils.serializar(repoPrestamos, "prestamos.dat");
    }
    
    public void inicializar() {
        File propiedadesArchivo = new File("libros.dat");
        
        
        if (propiedadesArchivo.exists()) {
            System.out.println("inicializo");
            repoLibros = Utils.deserializar("libros.dat");
            repoSocios = Utils.deserializar("socios.dat");
            repoPrestamos = Utils.deserializar("prestamos.dat");
            codigoPrestamo = repoPrestamos.length() + 1;
        }
    }

}
