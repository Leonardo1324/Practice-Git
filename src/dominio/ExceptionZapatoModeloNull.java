package dominio;

@SuppressWarnings("serial")
public class ExceptionZapatoModeloNull extends ExceptionZapato {

	public ExceptionZapatoModeloNull() {
		super("no se puede cargar un zapato con modelo nulo");
	}

}
