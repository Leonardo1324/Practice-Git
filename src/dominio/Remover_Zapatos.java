package dominio;

import java.util.ArrayList;

public class Remover_Zapatos {
    
    private ArrayList<Zapato> misZapatos;

    private Remover_Zapatos(ArrayList<Zapato> misZapatos) {
        this.misZapatos = misZapatos;
    }

    public boolean removeZapato(String codigo) {
        return misZapatos.removeIf(z -> z.getCodigo().compareTo(codigo)==0);
    }

    public boolean removeZapatosProvedor(String marca) {
        return misZapatos.removeIf(z -> z.getProveedor().getNombreEmpresa().compareToIgnoreCase(marca) == 0);
    }
}
