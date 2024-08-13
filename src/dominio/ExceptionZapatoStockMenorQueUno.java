package dominio;

@SuppressWarnings("serial")
public class ExceptionZapatoStockMenorQueUno extends ExceptionZapato{

	public ExceptionZapatoStockMenorQueUno() {
		super("el Stock deber ser mayor que uno por lo menos");
	}

}
