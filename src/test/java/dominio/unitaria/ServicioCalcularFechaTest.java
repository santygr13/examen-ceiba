package dominio.unitaria;

import java.util.Date;

import org.junit.Test;

import dominio.sevicio.ServicioCalcularFecha;
import junit.framework.Assert;

public class ServicioCalcularFechaTest {
	
	public static final String ISBN_DIGITOS_MENOR_TREINTA="iaf45as";
	
	@Test
	public void calcularFechaEntregaMaximaConDigitosIsbnMenorTreintaTest() {
		Date fechaEsperada = ServicioCalcularFecha.calcuarFechaEntregaMaxima(ISBN_DIGITOS_MENOR_TREINTA);
		
		Assert.assertNull(fechaEsperada);
	}
	
}
