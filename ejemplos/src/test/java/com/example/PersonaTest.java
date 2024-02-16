package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonaTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPersona() {
		var p = new Persona(1, "Pepito", "Grillo");
//		Persona p = null;
		
		assertNotNull(p);
		assertAll("Datos de persona", 
				() -> assertEquals(1, p.getId(), "getId"), 
				() -> assertEquals("Pepito", p.getNombre(), "getNombre"),
				() -> assertEquals("Grillo", p.getApellidos(), "getApellidos")
			);
	}

	@Test
	void testToString() {
		var p = new Persona(1, "Pepito", "Grillo");
		assertEquals("Persona [id=1, nombre=Pepito, apellidos=Grillo]", p.toString());
	}

	@Test
	void testEqualsObject() {
		var p1 = new Persona(1, "Pepito", "Grillo");
		var p2 = new Persona(1, null, null);
		assertEquals(p1, p2);
		assertSame(p1, p2);
	}

}
