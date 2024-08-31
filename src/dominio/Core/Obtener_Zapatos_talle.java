package dominio.Core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

import dominio.GestorZapatos;
import dominio.Enums.Color;

public class Obtener_Zapatos_talle {

    private GestorZapatos miGestorZapatos;

    private Obtener_Zapatos_talle(GestorZapatos gz){
        this.miGestorZapatos = gz;
    }
    // talle por empate modelo
		public ArrayList<Zapato> getZapatos(Color miColor) {
			ArrayList<Zapato> aux = miGestorZapatos.getZapatos();
			ArrayList<Zapato> aux2=aux.stream()
						.filter(p -> p.getMiColor().compareTo(miColor)==0)
						.sorted(new Comparator<Zapato>() {
							@Override
							public int compare(Zapato z1, Zapato z2) {
								if (z1.getTalle()-z2.getTalle()==0) {
									if (z1.getModelo().compareTo(z2.getModelo())==0) {
										return z1.getCodigo().compareTo(z2.getCodigo());
									}
									return z1.getModelo().compareTo(z2.getModelo())*-1;
								}
								return z1.getTalle()-z2.getTalle();
							}
						})
						.collect(Collectors.toCollection(ArrayList<Zapato>::new));
			
			return aux2;
		}


}
