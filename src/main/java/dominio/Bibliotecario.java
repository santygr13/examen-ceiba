package dominio;

import dominio.excepcion.PrestamoException;
import dominio.repositorio.RepositorioLibro;
import dominio.repositorio.RepositorioPrestamo;
import dominio.sevicio.ServicioCalcularFecha;

public class Bibliotecario {

	public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";
	public static final String PALABRA_PALINDDROMA = "Los libros palindromos solo se pueden utilizar en la biblioteca";

	private RepositorioLibro repositorioLibro;
	private RepositorioPrestamo repositorioPrestamo;

	public Bibliotecario(RepositorioLibro repositorioLibro, RepositorioPrestamo repositorioPrestamo) {
		this.repositorioLibro = repositorioLibro;
		this.repositorioPrestamo = repositorioPrestamo;

	}

	public void prestar(String isbn, String nombreUsuario) {
		if (!esPrestado(isbn)) {

			if (Libro.validarPalabraPalindroma(isbn)) {
				throw new PrestamoException(PALABRA_PALINDDROMA);
			} else {
				Libro libro = repositorioLibro.obtenerPorIsbn(isbn);
				Prestamo prestamo = new Prestamo(ServicioCalcularFecha.calcularFechaSolicitud(), libro, ServicioCalcularFecha.calcuarFechaEntregaMaxima(isbn), nombreUsuario);
				repositorioPrestamo.agregar(prestamo);
			}
		} else {
			throw new PrestamoException(EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE);
		}

	}

	public boolean esPrestado(String isbn) {
		return repositorioPrestamo.obtenerLibroPrestadoPorIsbn(isbn) != null ? true : false;

	}

}
