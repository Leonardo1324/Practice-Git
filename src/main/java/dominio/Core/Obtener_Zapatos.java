package main.java.dominio.Core;

import java.util.ArrayList;

import main.java.dominio.GestorZapatos;

public class Obtener_Zapatos {
    
    private GestorZapatos miGestorZapatos;

    private Obtener_Zapatos(GestorZapatos gz){
        this.miGestorZapatos = gz;
    }

    public ArrayList<Zapato> getZapatos(){
        return miGestorZapatos.getZapatos();
    }
}
