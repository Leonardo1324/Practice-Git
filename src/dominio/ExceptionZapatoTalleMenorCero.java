package dominio;

@SuppressWarnings("serial")
public class ExceptionZapatoTalleMenorCero extends ExceptionZapato {

	public ExceptionZapatoTalleMenorCero() {
		super("El talle de un zapato no pude ser menor que cero");
	}

}
