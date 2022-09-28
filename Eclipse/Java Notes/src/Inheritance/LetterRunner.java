package Inheritance;

public class LetterRunner {

	public static void main(String[] args) {
		
		A a = new A();
		B b = new B();
		D d = new D();
		
		System.out.println(a.getLetter() + " " + a.getSwitchy());
		System.out.println(b.getLetter() + " " + b.getSwitchy());
		System.out.println(d.toString());
		
		A[] letters = {a, b , d};
		
		//B[] bLetters = {a, b, d); does not work because a is not an instance of b
		
		for(A letter : letters) {
			if(letter instanceof A) {
				System.out.println("is A");
			}
			if(letter instanceof B) {
				System.out.println("is B");
			}
			if(letter instanceof D) {
				System.out.println("is D");
			}
		}
		
	}

}
