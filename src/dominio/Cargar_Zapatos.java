package dominio;

public class Cargar_Zapatos{

    private GestorZapatos miGestorZapatos;

    private Cargar_Zapatos(GestorZapatos gz){
        this.miGestorZapatos = gz;
    }

    public boolean hayDuplicado(String codigo) {
        return miGestorZapatos.getZapatos().stream().anyMatch(p -> p.getCodigo().compareToIgnoreCase(codigo)==0);
    }

    public boolean addZapato(String modelo, int talle, double precio, Color miColor,Proveedor proveedor,int reserva , int stock) {
        if (miGestorZapatos.getZapatos().isEmpty()) {
            Zapato aux1 = new Zapato(modelo,talle, precio, miColor,proveedor, reserva, stock);
            return miGestorZapatos.getZapatos().add(aux1);
        }
        else {
            Zapato aux = new Zapato(modelo,talle, precio, miColor,proveedor, reserva, stock);
            if (!hayDuplicado(aux.getCodigo()))
                return miGestorZapatos.getZapatos().add(aux);
            }
        return false;
    }

}
