
public class ChromaRunner {

	public static void main(String[] args) {
		ChromaKey floop = new ChromaKey();
		// floop.green1test();
		// floop.green2test();
		// floop.green3test();
		//floop.easyStego("rickRoll.jpg");
		//floop.hardStego("rickRoll.jpg");
		//System.out.println(floop.decodeEasy("rickRoll.jpg"));
		floop.hardStego("rickRoll.jpg");
		System.out.println(floop.decodeHard());
	}

}
