package dominio;

import org.mockito.internal.matchers.Equals;

public class Libro {

	private String isbn;
	private String titulo;
	private int anio;

	public Libro(String isbn, String titulo, int anio) {

		this.isbn = isbn;
		this.titulo = titulo;
		this.anio = anio;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAnio() {
		return anio;
	}

	public String getIsbn() {
		return isbn;
	}

	public static boolean validarPalabraPalindroma(String isbn) {
		String isbnInvertido = new StringBuilder(isbn).reverse().toString();
		
		return isbn.equals(isbnInvertido) ? true: false;
	}
	
	public static String obtenerDigitosIsbn(String isbn) {
		String cadena = isbn;
		char[] cadenaDividida = cadena.toCharArray();
		String obtenerDigitos = "";
		for (int i = 0; i < cadenaDividida.length; i++) {
			if (Character.isDigit(cadenaDividida[i])) {
				obtenerDigitos += cadenaDividida[i];
			}
		}
		return obtenerDigitos;
	}

	public static int sumarDigitosIsbn(String isbn) {
		String digitoObtenido = obtenerDigitosIsbn(isbn);
		int digitosNumero = Integer.parseInt(digitoObtenido);
		int resultado = 0;

		while (digitosNumero > 0) {

			resultado += digitosNumero % 10;

			digitosNumero = digitosNumero / 10;

		}
		return resultado;

	}
}
