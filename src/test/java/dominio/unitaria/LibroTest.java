package dominio.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import dominio.Libro;
import testdatabuilder.LibroTestDataBuilder;

public class LibroTest {

	private static final int ANIO = 2010;
	private static final String ISBN = "1234";
	private static final String NOMBRE_LIBRO = "Cien años de soledad";
	private static final String ISBN_PALINDROMO= "ab11ba";
	private static final String DIGITOS_ESPERADOS="11";
	private static final String PALABRA_CON_DIGITOS_IGUAL_A_DIEZ="ase5asd22ad1";
	private static final int SUMA_DIGITOS_ESPERADOS = 10;
	
	@Test
	public void crearLibroTest() {
		
		// arrange
		LibroTestDataBuilder libroTestDataBuilder = new LibroTestDataBuilder().
				conTitulo(NOMBRE_LIBRO).
				conIsbn(ISBN).
				conAnio(ANIO);

		// act
		Libro libro = libroTestDataBuilder.build();

		// assert
		assertEquals(NOMBRE_LIBRO, libro.getTitulo());
		assertEquals(ISBN, libro.getIsbn());
		assertEquals(ANIO, libro.getAnio());
	}
	
	@Test
	public void validarpalabraPalindromaTrueTest() {
	boolean resultado = Libro.validarPalabraPalindroma(ISBN_PALINDROMO);
	
	Assert.assertTrue(resultado);
		
	}
	
	@Test
	public void validarPalabraPalindromaFalseTest() {
		boolean resultado = Libro.validarPalabraPalindroma(ISBN);
		
		Assert.assertFalse(resultado);
	}
	
	@Test
	public void obtenerDigitosIsbnTest() {
		String digitosEsperados=DIGITOS_ESPERADOS;
		String digitosObtenidos=Libro.obtenerDigitosIsbn(ISBN_PALINDROMO);
		
		Assert.assertEquals(digitosEsperados, digitosObtenidos);
	}

	@Test
	public void sumarDigitosIsbnTest () {
		
	int sumaDigitosEsperados= SUMA_DIGITOS_ESPERADOS;
	int sumaDigitosObtenidos = Libro.sumarDigitosIsbn(PALABRA_CON_DIGITOS_IGUAL_A_DIEZ);
	
	Assert.assertEquals(sumaDigitosEsperados, sumaDigitosObtenidos);
		
	}
}
