package dominio.Core;

import dominio.GestorZapatos;

public class Modificar_Stock {

    private GestorZapatos miGestorZapatos;

    public Modificar_Stock(GestorZapatos gz) {
        this.miGestorZapatos = gz;
    }

    public boolean modificarStock(String codigo, int nuevoStock) {
		for (Zapato zapato : miGestorZapatos.getZapatos()) {
			if (zapato.getCodigo().compareTo(codigo)==0) {
				zapato.setStock(nuevoStock);
				return true;
			}
		}
		return false;
	}

}
