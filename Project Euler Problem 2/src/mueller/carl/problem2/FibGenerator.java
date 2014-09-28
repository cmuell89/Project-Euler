package mueller.carl.problem2;

public class FibGenerator {
	private long n = 1;
	private long m = 2;
	private long j = n + m;
	private long sum = m;
	
	public FibGenerator() {
	}
	
/* Fibonacci logic. An iterator that breaks loop if the i'th term value is greater that 4000000.
 * Modulo is used in an if statement to check if current Fibonacci value is even and adds to a sum if so.
 * 	
 */
	public void runFib(int range){
		long i;
		for(i=1;i<=(range-2);i++){
			
			if(j > 4000000){
				System.out.println("Max Range = " + i);
				break;
			}
			else{
			j = n + m;
		//	System.out.println(j);
			if(j % 2 == 0){
				sum = sum + j;
				System.out.println(sum);
			}
			n = m;
			m = j;
			}
		}
	}
	

}

