package com.example;

public class Calculadora {
	
	double add(double a, double b) {
		return a + b;
	}

	int divide(int a, int b) {
		return a / b;
	}

	double divide(double a, double b) {
		if(b == 0)
			throw new ArithmeticException("/ by zero");
		return a / b;
	}

}
