package dominio.Core;

import java.util.ArrayList;
import java.util.stream.Collectors;

import dominio.GestorZapatos;

public class Obtener_Zapato {

    private GestorZapatos miGestorZapatos;

    public Obtener_Zapato(GestorZapatos gz) {
        this.miGestorZapatos = gz ;
    }

    public Zapato getZapato(String codigo) {
		ArrayList<Zapato> aux = miGestorZapatos.getZapatos();
		ArrayList<Zapato> aux2=aux
							.stream()
							.filter(p->p.getCodigo().compareTo(codigo)== 0)
							.collect(Collectors.toCollection(ArrayList<Zapato>::new));
		for (Zapato zapato : aux2) {
			System.out.println(zapato.toString());
		}
		return aux2.get(aux2.size()-1);
	}

}
