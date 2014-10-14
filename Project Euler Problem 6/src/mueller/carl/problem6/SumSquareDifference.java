package mueller.carl.problem6;

public class SumSquareDifference {

	private long max;

	SumSquareDifference(long range) {
		max = range;
	}
	
	public void getResult(){
		System.out.println(sumSquareDifference(max));
	}

	private long sumSquareDifference(long n){
		long i;
		long j;
		long sumOfSquares = 0;
		long squareOfSum = 0;
		long difference;
		for(i=1; i<=n;i++){
			sumOfSquares = i*i + sumOfSquares;
		}
		for(j=1; j<=n; j++){
			squareOfSum = j + squareOfSum;
		}
		squareOfSum=(squareOfSum*squareOfSum);
		
		difference=squareOfSum-sumOfSquares;
		return difference;
	}
	
	

}
