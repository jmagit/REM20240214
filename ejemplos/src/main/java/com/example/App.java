package com.example;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Calculadora calculadora = new CalculadoraImpl();
		System.out.println(calculadora.add(2, 1));
		System.out.println(calculadora.add(0.1, 0.2));
		System.out.println(calculadora.add(1, -0.9));
		System.out.println(calculadora.add(1, -0.9) + calculadora.add(0.1, 0.2));
		System.out.println(calculadora.divide(1.0, 0.0) * 0);
		System.out.println(calculadora.divide(0, 0));
	}
}
