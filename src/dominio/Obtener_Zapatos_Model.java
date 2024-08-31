package dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Obtener_Zapatos_Model {

    private GestorZapatos miGestorZapatos;

    private Obtener_Zapatos_Model(GestorZapatos gz){
        this.miGestorZapatos = gz;
    }

    //por modelo y ante empate por color 
		public ArrayList<Zapato> getZapatos(String modelo) {
			
			ArrayList<Zapato> aux = miGestorZapatos.getZapatos();
			ArrayList<Zapato> aux2=aux.stream()
						.filter(p -> p.getModelo().compareToIgnoreCase(modelo)==0)
						.sorted(new Comparator<Zapato>() {
							@Override
							public int compare(Zapato z1, Zapato z2) {
								if (z1.getTalle()-z2.getTalle() == 0) {
									if (z1.getMiColor().compareTo(z2.getMiColor())==0) {
										return z1.getCodigo().compareTo(z2.getCodigo());
									}
									return z1.getMiColor().compareTo(z2.getMiColor())*-1;
								}
								return z1.getTalle()-z2.getTalle();
							}
						})
						.collect(Collectors.toCollection(ArrayList<Zapato>::new));
			
			return aux2;
		}

}
