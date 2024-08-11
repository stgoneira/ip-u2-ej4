package cl.iplacex;

import java.util.List;
import java.util.Optional;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/libros")
public class LibroWS {
    
    private LibroService libroServicio;

    public LibroWS() {
        this.libroServicio = new LibroService();
    }

    @GET
    @Path("/titulo/{titulo}")
    public Response obtenerLibroPorTitulo(@PathParam("titulo") String titulo) {
        Optional<Libro> libro = libroServicio.buscarPorTitulo(titulo);
        if (libro.isPresent()) {
            return Response.ok(libro.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Libro no encontrado").build();
        }
    }

    @GET
    @Path("/autor/{autor}")
    public List<Libro> obtenerLibrosPorAutor(@PathParam("autor") String autor) {
        return libroServicio.buscarPorAutor(autor);
    }

    @GET    
    public List<Libro> obtenerLibros() {
        return libroServicio.getLibros();
    }

    @POST
    public Response agregarLibro(Libro libro) {
        libroServicio.agregarLibro(libro);
        return Response.status(Response.Status.CREATED).entity("El libro ha sido agregado exitosamente.").build();
    }

    @DELETE
    @Path("/titulo/{titulo}")
    public Response eliminarLibro(@PathParam("titulo") String titulo) {
        boolean eliminado = libroServicio.eliminarLibro(titulo);
        if (eliminado) {
            return Response.ok("El libro ha sido eliminado exitosamente.").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Libro no encontrado").build();
        }
    }

}
