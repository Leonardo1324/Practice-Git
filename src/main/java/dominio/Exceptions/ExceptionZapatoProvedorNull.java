package dominio.Exceptions;

@SuppressWarnings("serial")
public class ExceptionZapatoProvedorNull extends ExceptionZapato {

	public ExceptionZapatoProvedorNull() {
		super("El provedor no puede ser null");
	}

}
