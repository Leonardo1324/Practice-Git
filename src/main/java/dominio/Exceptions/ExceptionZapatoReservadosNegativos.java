package dominio.Exceptions;

@SuppressWarnings("serial")
public class ExceptionZapatoReservadosNegativos extends ExceptionZapato{

	public ExceptionZapatoReservadosNegativos() {
		super("Los Zapatos reservdos no puede ser negativo");
	}

}
