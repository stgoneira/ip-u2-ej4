package cl.iplacex;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibroService {
    private List<Libro> libros = new ArrayList<>();

    public LibroService() {
        libros.add(new Libro("Spring REST", "Balaji Varanasi", 2021));
        libros.add(new Libro("RESTful Java with JAX-RS", "Bill Burke", 2010));
        libros.add(new Libro("RESTful Java Web Services", "Bogunuva Mohanram", 2017));
        libros.add(new Libro("Building RESTful Web Services with Spring 5", "Raja CSP Raman", 2018));
        libros.add(new Libro("RESTful Java Patterns and Best Practices", "Bhakti Mehta", 2014));
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<Libro> buscarPorAutor(String autor) {
        return libros.stream()
                     .filter(libro -> libro.getAutor().equalsIgnoreCase(autor))
                     .collect(Collectors.toList());
    }

    public Optional<Libro> buscarPorTitulo(String titulo) {
        return libros.stream()
                     .filter(libro -> libro.getTitulo().equalsIgnoreCase(titulo))
                     .findFirst();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public boolean eliminarLibro(String titulo) {
        return libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
    }

}
