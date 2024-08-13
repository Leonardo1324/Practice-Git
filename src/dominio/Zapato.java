package dominio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Zapato {
	
	private String modelo;
	private String codigo;
	private int talle; 
	
	private List<Precio> precio;
	private Color miColor;
	private Proveedor proveedor;
	
	private int reservado;
	
	private int stock;
	private int stockMinimo;
	
	/**
	 * Agregar campo int stock y campo int stokminimo
	 * 
	 * @param modelo
	 * @param talle
	 * @param precio este atributo cambi de tipo double a tipo List<Precio>
	 * Agregar void setPrecio(double)
	 * @param miColor
	 * @param reservado
	 * Agregar cantidad reservada (int)
	 * @param proveedor
	 * @param numero
	 * agregar atribut stock y stock minimo
	 */
	
	
	public Zapato(String modelo, int talle, double precioCompra, Color miColor, Proveedor proveedor,
			int reservado, int stock) {
		
		this.modelo = modelo;
		this.talle = talle;
		this.miColor = miColor;
		this.proveedor = proveedor;
		this.reservado = reservado;
		this.stock = stock;
		this.precio = new ArrayList<Precio>();
		
		if (stock > 500) {
			this.stockMinimo = (int)(stock*0.05);
		}
		else {
			this.stockMinimo = (int)(stock*0.25);
		}
		
		Precio p1 = new Precio(precioCompra,null);
		precio.add(p1);
		
		this.codigo =  generadorDeCodigo(proveedor,modelo,talle);

		/**
		 * Agregar al codigo las dos primeras letras del modelo y el talle
		 */
	}
	
	private String generadorDeCodigo(Proveedor proveedor,String modelo,int talle) {
		
		String salida;
		salida= getIniciales(proveedor.getNombreEmpresa()).toUpperCase()
				+"-"+proveedor.getPaisDeLaEmpresa().toString().substring(0, 1).toUpperCase()
				+"-"+modelo.substring(0,2).toUpperCase() + "-"+talle;
		return salida;
	}
	
	
	private String getIniciales( String Marca) {
		String salida="";
		String iniciales;
		StringTokenizer palabras = new StringTokenizer(Marca); // <- dada una cadena, obtiene las subcadenas separadas 
																//por un separador pasado por parámetro. si no se especifica es un espacio
		while (palabras.hasMoreElements()) {
			iniciales = palabras.nextToken();
			salida += iniciales.substring(0, 1);
		}
		return salida;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.codigo = generadorDeCodigo(this.proveedor,modelo,this.talle);
		this.modelo = modelo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getTalle() {
		return talle;
	}
	public void setTalle(int talle) {
		this.codigo = generadorDeCodigo(this.proveedor,this.modelo,talle);
		this.talle = talle;
	}
	
	
	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	/**
	 * la firma sigue quedando
	 * Ahora debe buscar "adecuadamente" en el arraylist cual es el precio actual
	 * @return
	 */
	public double getPrecio() {
		
		Precio aux = new Precio(0, null);
		aux = precio.stream().filter(p -> p.getFechaHasta()==null).collect(Collectors.toList()).get(0);
		return aux.getValor();
	}
	
	public double getPrecio(GregorianCalendar f) {
		// obtener fech correctamente
		return 0;
	}
	
	
	public double getPrecio(int dia,int mes,int anio) {
		
		GregorianCalendar fechaAux = new GregorianCalendar(dia,mes,anio);
		
		for (int i = precio.size()-2; i >= 0; i--) {
			if (precio.get(i).getFechaHasta().before(fechaAux) || precio.get(i).getFechaHasta().equals(fechaAux)) {
				return precio.get(i).getValor();
			}
		}
		
		return 0;
	}
	
	public void setPrecio(double valor,int dia,int mes,int anio) {
		//codigo para crear un nuevo objeto agregarlo al arraylist y setear la fechaHasta adecuadamente
		
		GregorianCalendar fechaAux = new GregorianCalendar(dia, mes, anio);
		for (Precio precio2 : precio) {
			if (precio2.getFechaHasta()==null) {
				precio2.setFechaHasta(fechaAux);
			}
		}
		
		Precio p1 = new Precio(valor,null);
		precio.add(p1);
	}
	
	public Color getMiColor() {
		return miColor;
	}
	public void setMiColor(Color miColor) {
		this.miColor = miColor;
	}
	public int cantidadDeReservas() {
		return reservado;
	}
	public void modificarReserva(int num) {
		// tener en cuenta validar los zapatos restantes
		reservado += num;
	}

	public Proveedor getProveedor() {
		this.codigo = generadorDeCodigo(proveedor,this.modelo,this.talle);
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Modelo: " + modelo + ", codigo: " + codigo + ", talle: " + talle + ", precio: " + precio
				+ ", Color: " + miColor + ", reservado: " + reservado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + talle;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zapato other = (Zapato) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (talle != other.talle)
			return false;
		return true;
	}
	
}


