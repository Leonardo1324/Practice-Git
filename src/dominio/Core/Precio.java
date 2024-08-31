package dominio.Core;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("unused")
public class Precio {
	
	private double valor;
	private GregorianCalendar FechaHasta;
	/**
	 * dos atributos privados double valor y un Calendar FechaHasta
	 * y todo lo usual full.
	 */
	
	public Precio(double valor, GregorianCalendar fechaHasta) {
		this.valor = valor;
		FechaHasta = fechaHasta;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public GregorianCalendar getFechaHasta() {
		return FechaHasta;
	}
	public void setFechaHasta(GregorianCalendar fechaHasta) {
		FechaHasta = fechaHasta;
	}

	
//	private String fechaFormateada(GregorianCalendar fechaHasta2) {
//		
//		if (fechaHasta2==null) {
//			return "null";
//		}
//		else {
//			Calendar c1 = GregorianCalendar.getInstance();
//			c1=fechaHasta2;
//			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//			return sdf.format(c1.getTime());
//		}
//		
//	}
	
	@Override
	public String toString() {
		return "Precio: " + valor;
	}
	
	
	
	
}
