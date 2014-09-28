/*
 * PROBLEM STATEMENT
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
package mueller.carl.problem1;

public class ThreeOrFive {
	
	private int min, max; // The test interval defined by min and max.
	private int sum = 0; // A running sum of values that meet problem criteria.
	
/*
 * ThreeOrFive class object constructor that takes in the min and max interval.
 */	
	ThreeOrFive(int min, int max){
		this.min = min;
		this.max = max;
	}

	/*
	 * Count function that iterators from min value up to but not including max value and test if the modulus value for 3 and 5 is zero.
	 * This will determine if the value is indeed a multiple of three and five.
	 * If the current i iteration meets either of these criteria, it as added to the sum value. 
	 */
	public void count(){
		int i;
		for(i=min;i<max;i++){
			if(i%3==0){
				sum = sum + i;
			}
			else if(i%5==0) {
				sum = sum + i;
			}
		}
	}
	public void printResult(){
		System.out.println("The sum of all natural numbers divisible by either 3 or 5 in the range: \n" + min + " to " + max + " is " + sum);
	}
}
