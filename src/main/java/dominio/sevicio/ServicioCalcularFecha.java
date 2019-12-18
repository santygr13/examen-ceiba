package dominio.sevicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dominio.Libro;

public final class ServicioCalcularFecha {

	
	public static Date calcularFechaSolicitud() {		
		return new Date();
	}
	
	public static Date calcuarFechaEntregaMaxima(String isbn) {		
		int digitosIsbn = Libro.sumarDigitosIsbn(isbn);
		Date fechaEntrega = null;
		if (digitosIsbn > 30 ) {
			fechaEntrega = sumarDiasHabilesEntrega(calcularFechaSolicitud());
		}
		return fechaEntrega;
	}
	
	public static Date sumarDiasHabilesEntrega(Date obtenerFechaActual) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(calcularFechaSolicitud());
		

		if (calendar.get(Calendar.DAY_OF_MONTH) == Calendar.SUNDAY) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, 15);
		}else {
			calendar.add(Calendar.DAY_OF_MONTH, 15);
		}

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/mm/dd");
		String nuevaFecha = formatoFecha.format(calendar.getTime());
		Date fecha = null;

		try {
			fecha = formatoFecha.parse(nuevaFecha);
		} catch (ParseException e) {
			System.out.println(e);
		}

		return fecha;
	}
}
	
	

