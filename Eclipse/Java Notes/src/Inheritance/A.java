package Inheritance;

public class A {
	
	//Attributes
	protected char letter;
	protected boolean switchy;
	/*
	 * public - can be gotten to anywhere in the package
	 * private - can only be accessed from this class
	 * protected - can only be accessed from this class and inherited to children
	 */
	
	//Constructor\
	
	public A() {
		letter = 'A';
		switchy = true;
	}
	
	//Methods
	
	public char getLetter() {
		return this.letter;
	}
	
	public boolean getSwitchy() {
		return this.switchy;
	}
}
