package dominio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;

import org.junit.experimental.theories.FromDataPoints;

@SuppressWarnings("unused")
public class GestorZapatos {

		private static GestorZapatos gz;
		private ArrayList<Zapato> misZapatos;
		
		private GestorZapatos() {
			misZapatos = new ArrayList<Zapato>();
		}
		
		public static GestorZapatos getInstancia() {
			if (gz==null) 
				gz=new GestorZapatos();
			return gz;
		}
		
		public void limpiar() {
			misZapatos = new ArrayList<Zapato>();
		}

		private boolean hayDuplicado(String codigo) {
			return misZapatos.stream().anyMatch(p -> p.getCodigo().compareToIgnoreCase(codigo)==0);
		}
		
		public boolean addZapato(String modelo, int talle, double precio, Color miColor,Proveedor proveedor,int reserva , int stock) {
			
			if (misZapatos.isEmpty()) {
				Zapato aux1 = new Zapato(modelo,talle, precio, miColor,proveedor, reserva, stock);
				return misZapatos.add(aux1);
			}
			else {
				Zapato aux = new Zapato(modelo,talle, precio, miColor,proveedor, reserva, stock);
				if (!hayDuplicado(aux.getCodigo()))
					return misZapatos.add(aux);
			}
			
			return false;
		}
		
		// Cambia el precio de un Zapato en particular y agrega la fecha del cambio
		public boolean cambiarPrecio(String codigo, double neuvo,int dia,int mes,int anio) {
			Zapato aux;
			aux = misZapatos.stream().filter(p -> p.getCodigo().compareTo(codigo)==0).collect(Collectors.toList()).get(0);
			aux.setPrecio(neuvo, dia, mes, anio);
			return true;
		}

		// *******************************************
		public boolean removeZapato(String codigo) {
			return misZapatos.removeIf(z -> z.getCodigo().compareTo(codigo)==0);
		}
		
		public boolean removeZapatosProvedor(String marca) {
			return misZapatos.removeIf(z -> z.getProveedor().getNombreEmpresa().compareToIgnoreCase(marca) == 0);
		}
		
		public ArrayList<Zapato> getZapatos(){
			return misZapatos;
		}
		
		
		
		
		// por talle y ordenado por modelo
//		public ArrayList<Zapato> getZapatos() {
//			ArrayList<Zapato> aux = misZapatos;
//			ArrayList<Zapato> aux2=aux.stream()
//						.sorted(new Comparator<Zapato>() {
//							@Override
//							public int compare(Zapato z1, Zapato z2) {
//								if (z1.getTalle()-z2.getTalle()==0) {
//									return z1.getCodigo().compareTo(z2.getCodigo());
//								}
//								return z1.getTalle()-z2.getTalle();
//							}
//						})
//						.collect(Collectors.toCollection(ArrayList<Zapato>::new));
//			
//			return aux2;
//		}
		// talle por empate modelo
		
		public ArrayList<Zapato> getZapatos(Color miColor) {
			
			ArrayList<Zapato> aux = misZapatos;
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
		
//		//ordena por color y empate por talle
//		public ArrayList<Zapato> getZapatosReservados() {
//			//
//			ArrayList<Zapato> aux = misZapatos;
//			ArrayList<Zapato> aux2=aux.stream()
//						.filter(p -> p.getReservado(>0))
//						.sorted(new Comparator<Zapato>() {
//							@Override
//							public int compare(Zapato z1, Zapato z2) {
//								if (z1.getTalle()-z2.getTalle() == 0) {
//									return z1.getMiColor().compareTo(z2.getMiColor())*-1;
//								}
//								return z1.getTalle()-z2.getTalle();
//							}
//						})
//						.collect(Collectors.toCollection(ArrayList<Zapato>::new));
//			
//			return aux2;
//		}
		//por talle y ante empate por color // analizar si realmente es necesario
		public ArrayList<Zapato> getZapatos(String modelo) {
			
			ArrayList<Zapato> aux = misZapatos;
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
		
		public ArrayList<Zapato> getZapatos(int hasta) {
			ArrayList<Zapato> aux = misZapatos;
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
		
		//ordena por precio descendente por empate modelo alfabetico
		public ArrayList<Zapato> getZapatos(double desde, double hasta) {
			ArrayList<Zapato> aux = misZapatos;
			ArrayList<Zapato> aux2=aux.stream()
						.filter(p -> p.getPrecio() >= desde && p.getPrecio() <= hasta)
						.sorted(new Comparator<Zapato>() {
							@Override
							public int compare(Zapato z1, Zapato z2) {
								if ((int) ((z1.getPrecio()-z2.getPrecio())*10)==0) {
									return z1.getModelo().compareTo(z2.getModelo());
								}
								return (int) ((z1.getPrecio()-z2.getPrecio())*10);
							}
						})
						.collect(Collectors.toCollection(ArrayList<Zapato>::new));
			
			return aux2;
		}
		
		
		public double getPrecioViejo(String modelo, GregorianCalendar fechaExacta) {
			//obtener el zapato
			Zapato z1 = null;
			String fecha = fechaFormateada(fechaExacta);
			
			for (Zapato zapato : misZapatos) {
				if (zapato.getCodigo().compareTo(modelo)==0) {
					z1=zapato;
				}
			}
			
			System.out.println(fecha);
			int dia=Integer.parseInt(fecha.substring(0, 1));
			int mes=Integer.parseInt(fecha.substring(3, 4));
			int anio=Integer.parseInt(fecha.substring(6, 9));
			
			System.out.println(dia);
			System.out.println(mes);
			System.out.println(anio);
			
			//retornar precio en fecha
			return z1.getPrecio(dia,mes,anio);
		}
		
		private String fechaFormateada(GregorianCalendar fechaHasta2) {
			
			Calendar c1 = GregorianCalendar.getInstance();
			c1=fechaHasta2;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(c1.getTime());
			
			
			
		}

		
		
//		public double geStockValorizadoXProveedor(algun dato del proveedor ){
//		
//		}

		
		public boolean modificarStock(String codigo, int nuevoStock) {
			
		for (Zapato zapato : misZapatos) {
			if (zapato.getCodigo().compareTo(codigo)==0) {
				zapato.setStock(nuevoStock);
				return true;
			}
		}
		return false;
			
		}
		
	}
			
//		public Zapato getZapato(String codigo) {
//			
//			ArrayList<Zapato> aux = misZapatos;
//			ArrayList<Zapato> aux2=aux
//							.stream()
//							.filter(p->p.getCodigo().compareTo(codigo)== 0)
//							.collect(Collectors.toCollection(ArrayList<Zapato>::new));
//					
//			for (Zapato zapato : aux2) {
//				System.out.println(zapato.toString());
//			}
//			return aux2.get(aux2.size()-1);
//		}
//
//
//		
//		
//		public List<Zapato> getPedido(algun dato del proveedo){
//			/**
//			 * buscar los zapatos del proveedor que corresponda y deesos buscar cuales son para hacer el pedido(stock minimo >= sttock)
//			 */
//		}
//		
	