package dominio.unitaria;

import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import dominio.Libro;
import dominio.Prestamo;
import testdatabuilder.LibroTestDataBuilder;
import testdatabuilder.PrestamoTestDataBuilder;

public class PrestamoTest {

	private static final Date FECHA_SOLICITUD=new Date(2019,5,15);
	private static final Libro LIBRO=new LibroTestDataBuilder().build();
	private static final Date FECHA_ENTREGA_MAXIMA= new Date(2019,5,30);
	private static final String NOMBRE_USUARIO="Juan Esteban";
	
	@Test
	public void crearPrestamo() {
		PrestamoTestDataBuilder prestamoTestDataBuilder= new PrestamoTestDataBuilder().conFechaSolicitud(FECHA_SOLICITUD)
				.conLibro(LIBRO).conFechaEntregaMaxima(FECHA_ENTREGA_MAXIMA).conNombreUsuario(NOMBRE_USUARIO);
		
		Prestamo prestamo = prestamoTestDataBuilder.build();
		
		assertEquals(FECHA_SOLICITUD, prestamo.getFechaSolicitud());
		assertEquals(LIBRO, prestamo.getLibro());
		assertEquals(FECHA_ENTREGA_MAXIMA, prestamo.getFechaEntregaMaxima());
		assertEquals(NOMBRE_USUARIO, prestamo.getNombreUsuario());
	}
}
