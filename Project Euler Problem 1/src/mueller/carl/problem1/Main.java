package mueller.carl.problem1;

public class Main {
	public static void main(String[] args){
		ThreeOrFive givenTest = new ThreeOrFive(1,10);
		givenTest.count();
		givenTest.printResult();
		
		ThreeOrFive finalTest = new ThreeOrFive(1,1000);
		finalTest.count();
		finalTest.printResult();
	}

}
