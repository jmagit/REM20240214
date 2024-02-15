package com.example;

import java.util.Optional;

public class Calculadora {
	
	double add(double a, double b) {
		return a + b;
	}

	int divide(int a, int b) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a / b;
	}

	double divide(double a, double b) {
		if(b == 0)
			throw new ArithmeticException("/ by zero");
		return a / b;
	}

//	String algo() { return null; }
//	Optional<String> algo2() { return Optional.empty(); }
}
