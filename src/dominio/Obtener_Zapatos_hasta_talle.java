package dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Obtener_Zapatos_hasta_talle {

    private GestorZapatos miGestorZapatos;

    private Obtener_Zapatos_hasta_talle(GestorZapatos gz){
        this.miGestorZapatos = gz;
    }

    public ArrayList<Zapato> getZapatos(int hasta) {
			ArrayList<Zapato> aux = miGestorZapatos.getZapatos();
			ArrayList<Zapato> aux2=aux.stream()
						.filter(p -> p.getTalle() >= hasta-1 &&  p.getTalle() <= hasta+1)
						.sorted(new Comparator<Zapato>() {
							@Override
							public int compare(Zapato z1, Zapato z2) {
								return z2.getTalle()-z1.getTalle();
							}	
						})
						.collect(Collectors.toCollection(ArrayList<Zapato>::new));
			return aux2;
		}

}
