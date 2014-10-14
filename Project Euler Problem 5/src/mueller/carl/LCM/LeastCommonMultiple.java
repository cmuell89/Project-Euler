package mueller.carl.LCM;

public class LeastCommonMultiple {
	long[] range;

	LeastCommonMultiple(long x, long y){
		range = new long[(int) ((1+y)-x)];
		for(long i=x; i<=y; i++){
			range[(int) (i-1)]=i;
		}
		long result = range[0];
		for(int i = 1; i < range.length; i++){
			result = lcm(result, range[i]);

		}
		System.out.println(result);
	}
		
		private long lcm(long a, long b){
			long max;
			long min;
			long x;
			long lcm = 0;
			if(a>b){
				max = a;
				min = b;
			}
			else{
				max = b;
				min = a;
			}
			for(long i=1; i<=min;i++){
				
				x = max*i;
				if(x%min==0){
					lcm=x;
					break;
				}
			}
			return lcm;
		}
		
	}

