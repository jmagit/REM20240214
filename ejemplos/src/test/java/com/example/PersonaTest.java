package com.example;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
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
//	@Tag("smoke")
	@Smoke
	void testCrearPersona() {
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
		assumeFalse(true);
	}

	@Test
//	@Disabled
	void testEqualsObject() {
		var p1 = new Persona(1, "Pepito", "Grillo");
		var p2 = new Persona(1);
//		assertEquals(p1, p2);
//		assertSame(p1, p2);
	}

	@Test
	void calculaSalario() {
		var p = new Persona(1, "Pepito", "Grillo");
		assertEquals(900, p.salario());
	}
}
