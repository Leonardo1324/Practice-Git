package dominio.test;

import dominio.*;
import dominio.Core.Proveedor;
import dominio.Core.Zapato;
import dominio.Enums.Color;
import dominio.Enums.Pais;
import dominio.Exceptions.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestGestorDeZapatos {

	@Test
	@Order(1)
	@DisplayName("01 Constructor singleton")
	void test01() {
	GestorZapatos gz= GestorZapatos.getInstancia();
	GestorZapatos gz2= GestorZapatos.getInstancia();
	
		assertNotNull(gz);
		assertNotNull(gz2);
		assertTrue(gz==gz2);
	}
	
	@Test
	@Order(2)
	@DisplayName("02 Add zapato + getCodigo + getZapatos(simple)")
	void test02() {
	GestorZapatos gz= GestorZapatos.getInstancia();
	Proveedor p1 =  new Proveedor(12,"Marca",Pais.ARGENTINA,"+389 578915");
	gz.limpiar();
	
	gz.addZapato("casual", 43, 170.50, Color.BLANCO, p1,10,40);
	gz.addZapato("rangler", 28, 180, Color.NEGRO, p1,2,100);
	gz.addZapato("pandero", 28, 180, Color.NEGRO, p1,2,100);
	
	ArrayList<Zapato> aux = gz.getZapatos();
	
	assertEquals("M-A-CA-43",aux.get(0).getCodigo());
	assertEquals("M-A-RA-28",aux.get(1).getCodigo());
	assertEquals("M-A-PA-28",aux.get(2).getCodigo());
	
	}


	@Test
	@Order(3)
	@DisplayName("03 getZapatos(parametros)")
	void test03() {
	GestorZapatos gz= GestorZapatos.getInstancia();
	Proveedor p1 =  new Proveedor(12,"Marca",Pais.ARGENTINA,"+389 578915");
	gz.limpiar();
	
	gz.addZapato("casual", 43, 170.50, Color.BLANCO, p1,10,40);
	gz.addZapato("rangler", 40, 170.50, Color.BLANCO, p1,10,40);
	gz.addZapato("pico", 38, 170.50, Color.BLANCO, p1,10,40);
	gz.addZapato("pandero", 41, 170.50, Color.BLANCO, p1,10,40);
	gz.addZapato("prada", 43, 170.50, Color.BLANCO, p1,10,40);
	gz.addZapato("belico", 43, 170.50, Color.BLANCO, p1,10,40);
	
	System.out.println("**************talle E -> modelo EE -> codigo******************");
	ArrayList<Zapato> aux = gz.getZapatos(Color.BLANCO);
	
//	for (Zapato zapato : aux) {
	
	assertEquals(6,aux.size());
	
	}
	@Test
	@Order(3)
	@DisplayName("03 getPrecio fecha en particular ")
	void test04() {
		GestorZapatos gz= GestorZapatos.getInstancia();
		Proveedor p1 =  new Proveedor(12,"Marca",Pais.ARGENTINA,"+389 578915");
		GregorianCalendar f1=new GregorianCalendar();
		f1.set(10, 8, 2010);
		gz.limpiar();
		
		System.out.println(f1);
		
		gz.addZapato("casual", 43, 170.50, Color.BLANCO, p1,10,40);
		
		gz.cambiarPrecio("M-A-CA-43", 200.50, 15, 8, 2010);
		gz.cambiarPrecio("M-A-CA-43", 250.50, 15, 9, 2010);
		
		ArrayList<Zapato> aux = gz.getZapatos(Color.BLANCO);
		for (Zapato zapato : aux) {
			System.out.println(zapato.toString());
		}
		
		gz.getPrecioViejo("casual", f1);
		
		
		
		
	}
	
}
