package sistemabibliotecadigitalutn;

import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
    private Repositorio<String, Libro> repoLibros;
    private Repositorio<Integer, Socio> repoSocios;
    private Repositorio<Integer, Prestamo> repoPrestamos;

    public Biblioteca() {
        this.repoLibros = new Repositorio<>();
        this.repoSocios = new Repositorio<>();
        this.repoPrestamos = new Repositorio<>();
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
    
    public boolean existeSocio(int legajo) {
        return repoSocios.existe(legajo);
    }
    
    public boolean existeLibro(String codigo) {
        return repoLibros.existe(codigo);
    }
}
