
public class DayThreeFunctions {
	
	
	//accessModifier       static       returnType/orVoid         variable name           parameters
	public                 static             void                   printHi                  () {
		System.out.println("Hi");
	}
	
	
	
	public static int randNumberBetweenOneAndTen() {
		return (int)(Math.random() * 10) + 1;   //return passes data out of the function
	}
	
	public static boolean lessThanFive(int num) {
		return num < 5;
	}
	
	public static int checkLessThanFiveXTimes(int x) {
		int count = 0;
		for(int i = 0; i < x; i++) 
			if(lessThanFive(randNumberBetweenOneAndTen()))
				count++;
			return count; 
		
	}
	
	public static double divideThem(double one, double two) {
		return one / two; 
	}
	
	public static int divideThem(int one, int two) {
		return one / two; 
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(randNumberBetweenOneAndTen());
		
		System.out.println(checkLessThanFiveXTimes(100000));
	}
	

}
