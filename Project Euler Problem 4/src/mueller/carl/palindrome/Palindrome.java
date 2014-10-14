package mueller.carl.palindrome;
import java.util.Arrays;


public class Palindrome {
	
	private int[] answerList = new int[3];
	
	public Palindrome(){
	}
	private int reverseInt(int n){
		int forward = n; 
		int reverse = 0;
		
		while(forward != 0){
			reverse = reverse * 10;
			reverse = reverse + forward % 10;
			forward = forward/10;
		}
		return reverse;
	}
	
	
	public void palFinder(){
		int i;
		int j;
		for(i=999; i>99; i--){
			for (j=999; j>99; j--){
				int testNumber = i * j;
				if(testNumber == reverseInt(testNumber)){
					if(testNumber > answerList[2]){
					answerList[0] = i;
					answerList[1] = j;
					answerList[2] = testNumber;
					}
				}
				
			}
			
		}
		printAnswer();
	
	}
	
	private void printAnswer(){
		System.out.println(Arrays.toString(answerList));
	}

}
