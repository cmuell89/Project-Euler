package mueller.carl.problem7;

public class Main {
	public static void main(String[] args){
		final long startTime = System.nanoTime();
		Primer test = new Primer(10001);
		test.printResult();
		final long duration = System.nanoTime() - startTime;
		System.out.println(duration);
	}

}
