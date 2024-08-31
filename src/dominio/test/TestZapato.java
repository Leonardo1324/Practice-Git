package dominio.test;

import dominio.Exceptions.*;
import dominio.*;
import dominio.Core.Proveedor;
import dominio.Core.Zapato;
import dominio.Enums.Color;
import dominio.Enums.Pais;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestZapato {

	@Test
	@Order(1)
	@DisplayName("01 Constructor")
	void test01() {
		
		Proveedor p1= 	new Proveedor(12, "Marca", Pais.ARGENTINA, "+54 3825 324578");
		Zapato z1 = new Zapato("casual",43,150.50,Color.NEGRO,p1,5,20);
		
		assertNotNull(z1);
		assertNotNull(p1);
		
		assertEquals("M-A-CA-43",z1.getCodigo());
	}
	
	@Test
	@Order(2)
	@DisplayName("02 set y get precio ")
	void test02() {
		Proveedor p1= 	new Proveedor(12, "Marca", Pais.ARGENTINA, "+54 3825 324578");
		Zapato z1 = new Zapato("casual",43,150.50,Color.NEGRO,p1,5,20);
		
		assertEquals(150.50,z1.getPrecio());
		
		z1.setPrecio(200.50, 15, 8, 2010);
		
		assertEquals(200.50,z1.getPrecio());
		
		z1.setPrecio(250.50, 15, 9, 2010);
		
		assertEquals(250.50,z1.getPrecio());
		
	}
	
	@Test
	@Order(3)
	@DisplayName("get precio fechas")
	void test03() {
		Proveedor p1= 	new Proveedor(12, "Marca", Pais.ARGENTINA, "+54 3825 324578");
		Zapato z1 = new Zapato("casual",43,150.50,Color.NEGRO,p1,5,20);
		
		assertEquals(150.50,z1.getPrecio());
		z1.setPrecio(200.50, 15, 8, 2010);
		
		assertEquals(150.50,z1.getPrecio(18,8,2010));	
		
		z1.setPrecio(250.50, 15, 9, 2010);
		
		assertEquals(200.50,z1.getPrecio(19,9,2010));
	
		z1.setPrecio(300.50, 15, 10, 2010);
		
		assertEquals(250.50,z1.getPrecio(15,10,2010));
		
	}
}
