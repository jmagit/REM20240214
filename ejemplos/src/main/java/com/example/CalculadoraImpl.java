package com.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraImpl implements Calculadora {
	double toDouble(double o) {
		return (new BigDecimal(o))
				.setScale(16, RoundingMode.HALF_UP)
				.doubleValue();
	}
	
	@Override
	public double add(double a, double b) {
		return toDouble(a + b);
	}

	@Override
	public int divide(int a, int b) {
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return a / b;
	}

	@Override
	public double divide(double a, double b) {
		if(b == 0)
			throw new ArithmeticException("/ by zero");
		return a / b;
	}

//	String algo() { return null; }
//	Optional<String> algo2() { return Optional.empty(); }
}
