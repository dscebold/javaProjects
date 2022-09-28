
public class PosterRunner {

	public static void main(String[] args) {
		
		
		String wait = "Loading";
		
		
		for(int i = 0; i < 5; i++) {
		System.out.println(wait);
		wait += "."; 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
		
		Poster slogan = new Poster();
		System.out.println(slogan.toString());
		
		while(slogan.isCool() == false) {
			System.out.println("That was just terrible...\n try again..");
			slogan = new Poster();
			System.out.println(slogan.toString());
		}

	}

}
