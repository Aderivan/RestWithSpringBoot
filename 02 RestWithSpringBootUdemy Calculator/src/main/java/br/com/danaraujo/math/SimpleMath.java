package br.com.danaraujo.math;

public class SimpleMath {
	
	public Double sum(Double numberOne, Double numberTwo) {
		return numberOne + numberTwo;
	}
	
	public Double subtraction(Double numberOne, Double numberTwo) {
		return numberOne - numberTwo;
	}
	
	public Double multiplication(Double numberOne, Double numberTwo) {
		return numberOne * numberTwo;
	}
	
	public Double division(Double numberOne, double numberTwo) {
		return numberOne / numberTwo;
	}
	
	public Double mean(Double numberOne, double numberTwo) {
		return (numberOne + numberTwo) / 2;
	}
	
	public Double square(Double number) {
		return (Double) Math.sqrt(number);
	}
}
