package dominio;

import java.util.ArrayList;

public class Obtener_Zapatos {
    
    private GestorZapatos miGestorZapatos;

    private Obtener_Zapatos(GestorZapatos gz){
        this.miGestorZapatos = gz;
    }

    public ArrayList<Zapato> getZapatos(){
        return miGestorZapatos.getZapatos();
    }
}
