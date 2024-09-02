package dominio.Core;

import java.util.stream.Collectors;

import dominio.GestorZapatos;

public class Cambiar_Precio_Zapato {

    private GestorZapatos miGestorZapatos;

    public Cambiar_Precio_Zapato(GestorZapatos gz){
        this.miGestorZapatos = gz;
    }

    public boolean cambiarPrecio(String codigo, double neuvo,int dia,int mes,int anio) {
		Zapato aux;
		aux = miGestorZapatos.getZapatos().stream().filter(p -> p.getCodigo().compareTo(codigo)==0).collect(Collectors.toList()).get(0);
		aux.setPrecio(neuvo, dia, mes, anio);
		return true;
	}
}
