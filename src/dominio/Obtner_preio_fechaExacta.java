package dominio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Obtner_preio_fechaExacta {

    private GestorZapatos miGestorZapatos;

    private Obtner_preio_fechaExacta(GestorZapatos gz){
        this.miGestorZapatos = gz;
    }


	public String fechaFormateada(GregorianCalendar fechaHasta2) {
			
		Calendar c1 = GregorianCalendar.getInstance();
		c1=fechaHasta2;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(c1.getTime());		
		
	}

		

    public double getPrecioViejo(String modelo, GregorianCalendar fechaExacta) {
		//obtener el zapato
		Zapato z1 = null;
		String fecha = fechaFormateada(fechaExacta);
			
		for (Zapato zapato : miGestorZapatos.getZapatos()) {
			if (zapato.getCodigo().compareTo(modelo)==0) {
				z1=zapato;
			}
		}
			
		System.out.println(fecha);
		int dia=Integer.parseInt(fecha.substring(0, 1));
		int mes=Integer.parseInt(fecha.substring(3, 4));
		int anio=Integer.parseInt(fecha.substring(6, 9));
			
		System.out.println(dia);
		System.out.println(mes);
		System.out.println(anio);
			
		//retornar precio en fecha
		return z1.getPrecio(dia,mes,anio);
	}

}
