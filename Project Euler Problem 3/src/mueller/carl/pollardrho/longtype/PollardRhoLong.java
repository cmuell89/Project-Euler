package mueller.carl.pollardrho.longtype;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class PollardRhoLong.
 */
public class PollardRhoLong {

	long testNumber;
	long x = 2;
	long y = 2;
	long d = 1;
	long result;

	/** The factor list. */
	ArrayList<Long> factorList = new ArrayList<Long>();

	/**
	 * Instantiates a new pollard rho long object.
	 *
	 * @param n
	 *            the n
	 */
	PollardRhoLong(long n) {
		testNumber = n;
	}
	
	/**
	 * Public interface to call the algorithm.
	 */
	public void runAlg(){
		factor(testNumber);
	}

	/**
	 * g(x) function is the polynomial that provides the pseudorandom number
	 * generator based for the of the modulo comparative loop, rho(), method.
	 *
	 * @param x
	 *            the x
	 * @return the long
	 */
	private long g(long x) {

		return (((x * x) + 1) % this.testNumber);
	}

	/**
	 * gcd() method invokes the Euclidean algorithm to check to calculate the
	 * greatest common divisor. See:
	 * http://en.wikipedia.org/wiki/Euclidean_algorithm
	 *
	 * @param x
	 * @param y
	 * @return long, the GCD of x and y
	 */
	private long gcd(long x, long y) {
		long r;
		while (y != 0) {
			r = x % y;
			x = y;
			y = r;
		}
		return x;
	}

	/**
	 * Checks if the current number is prime prime. This does so by brute force,
	 * iterating i=2 up to n/2 to determine if any i value divides n evenly i.e,
	 * that n mod i equals 0
	 *
	 * @param n
	 *            the n
	 * @return true, if is prime, false if not prime
	 */
	private boolean isPrime(long n) {
		for (int i = 2; i < (n / 2); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Factor method that parses through the results of the rho() method. It
	 * checks if each input into the method is prime, tests this number against
	 * the testNumber. If it is prime, the number is added to the factor list,
	 * if it is not prime, it is passed through the rho() method whose return
	 * results is reassigned to divisor. This new divisor results is checked for
	 * primeness. If it is prime, then the original n value divided by the
	 * current divisor is looped through the factor method recursively. If is it
	 * is not prime, it is recursively looped through the factor method
	 * unaltered.
	 * 
	 * Any time a factor is determined to be prime, it is added to an ArrayList
	 * called factorList.
	 * 
	 * The final factor one all other factors are found will be 1. This value
	 * will be prime and therefore enter the first if statement. One of the
	 * checks is to see if n = 1, if it does, a System.exit(0); is executed and
	 * the program terminates.
	 * 
	 *
	 * @param n
	 *            the n
	 */
	private void factor(long n) {
		long divisor = 0;
		if (isPrime(n)) {
			if (n == testNumber) {
				System.out.println(testNumber + " is prime.");
			} else if (n == 1) {
				System.exit(0);
			} else {
				factorList.add(n);
				if (factorResult() == testNumber) {
					return;
				}
			}
		}
		divisor = rho(n);

		if (isPrime(divisor)) {
			System.out.println(divisor + " is a prime factor of " + testNumber);
			factorList.add(n);
			factor(n / divisor);
		} else {
			factor(divisor);
		}
	}

	/**
	 * The Pollard Rho algorithm. This method takes in a integer (or long)
	 * number called the divisor. Note that the divisor for the first pass is
	 * the testNumber. Using seed numbers x = 2, y = 2, and d = 1, the algorithm
	 * takes x and y, and passes them through the function g(x) and g^2(y). The
	 * results of these two function are assigned to to x and y respectively.
	 * Then using the gcd() function, the GCD of the difference between x and u
	 * and the divisor is calculated and assigned to d. If it is one, the
	 * function loops over, growing the size of both g(x) and g^2(y). This
	 * effectively creates two running sequences that will ultimately create a
	 * repeating patter. This is known as Floyd's cycle detection trick. The
	 * nodes of the repeating pattern will manifest themselves on a value x -y
	 * where the gcd with the divisor is greater than one, thus making this
	 * number is a factor of the divisor.
	 * 
	 * Each loop of the divisor modulo 2 is check to pull out an immediate
	 * factor of two.
	 * 
	 * The while loop is terminated if the factorResult() returns a result equal
	 * to the testNumber.
	 * 
	 * The absolute value of x-y is used because JAVA calculates negative
	 * remainders which will fail the algorithm.
	 * 
	 * When a d greater than 1 is found, d is returned to the factor() method
	 * for checking.
	 * 
	 * 
	 *
	 * @param divisor
	 *            the divisor
	 * @return the long
	 */
	private long rho(long divisor) {

		if ((divisor % 2) == 0) {
			System.out.println(2);
			return 2;
		}
		do {
			if (factorResult() == testNumber) {
				break;
			}
			x = g(x);
			y = g(g(y));
			d = gcd(Math.abs(x - y), divisor);
		} while (d == 1);
		return d;
	}

	/**
	 * Factor result that iterates through the factoList and uses the
	 * multiplicative assingment operator to give the result of all the factors
	 * on the list.
	 *
	 * @return the long
	 */
	private long factorResult() {
		long result = 1;
		for (long i = 0; i < factorList.size(); i++) {
			result *= i;
		}
		return result;
	}

}
