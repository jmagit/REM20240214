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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
		calculadora = new CalculadoraImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@ParameterizedTest(name = "{displayName}: {0} + {1} = {2} ")
	@CsvSource({"1,2,3", "2,-1,1", "-5,7,2", "-1,-1,-2", "0,0,0","0.1,0.2,0.3"})
	void test_Add(double op1, double op2, double result) {
		Calculadora calculadora = new CalculadoraImpl();

		var resultado = calculadora.add(op1, op2);

		assertEquals(result, resultado);
	}
	
	@Test
	@Smoke
	void test_AddIEEE() {
		Calculadora calculadora = new CalculadoraImpl();

		var resultado = calculadora.add(0.1, 0.2);

		assertEquals(0.3, resultado);
	}
	
	@RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	void test_Privado() {
		assertEquals(0.3, ((CalculadoraImpl)calculadora).toDouble(0.1+0.2));
		assertEquals(0.1, ((CalculadoraImpl)calculadora).toDouble(1-0.9));
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
