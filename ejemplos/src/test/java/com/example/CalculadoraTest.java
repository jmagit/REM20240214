package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas de la clase Calculadora")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CalculadoraTest {
	Calculadora calculadora;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calculadora = new Calculadora();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test_Add() {
		Calculadora calculadora = new Calculadora();

		var resultado = calculadora.add(2, 1);

		assertEquals(3, resultado);
	}
	
	@Test
	void test_AddIEEE() {
		Calculadora calculadora = new Calculadora();

		var resultado = calculadora.add(0.1, 0.2);

		assertEquals(0.3, resultado);
	}
	@RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	void test_Privado() {
		assertEquals(0.3, calculadora.toDouble(0.1+0.2));
		assertEquals(0.1, calculadora.toDouble(1-0.9));
	}

	@Nested
	class Divide {
		@Nested
		class Enteros {
			@Nested
			class OK {
				@Test
				void test_Divide_Integer() {
					assertEquals(1, calculadora.divide(3, 2));
				}
			}

			@Nested
			class KO {

				@Test
				void test_Divide_Integer_KO() {
					assertThrows(ArithmeticException.class, () -> calculadora.divide(3, 0));
//		try {
//			assertEquals(1, calculadora.divide(3, 0));
//		} catch (Exception e) {
//			fail(e.getMessage());
//		}
				}
			}
			@Test
			void lento() {
				assertTimeout(Duration.ofMillis(100), () -> calculadora.divide(3, 2));
			}
		}

		@Nested
		class Reales {

			@Test
			void testDivideDoubleDouble() {
				assertThrows(ArithmeticException.class, () -> calculadora.divide(3.0, 0), "Divide por 0");
			}

		}
	}
}
