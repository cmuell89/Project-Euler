package mueller.carl.problem7;

public class Primer {
	private long nthPrime;
	private int n;

	public Primer(int n) {
		this.n = n;
		findNthPrime(n);
	}

	/*
	 * Exponentiation by using modular exponentiation via squaring.
	 */
	private long modPower(long base, long power, long modulus) {
		long result = 1;
		for (int i = 63; i >= 0; i--) {
			result = (result * result) % modulus;
			if ((power & (1 << i)) != 0) {
				result = (result * base) % modulus;
			}
		}
		return result;
	}

	private boolean millerRabin(long a, long n) {
		/*
		 * Convert n into the form 2^s*d where d is naturally an odd number.
		 */
		long d = n - 1;
		long s = 0;
		while (d % 2 == 0) {
			d = d / 2;
			s = s + 1;
		}
		long aPower = modPower(a, d, n);
		if (aPower == 1) {
			return true;
		}
		for (int i = 0; i < s - 1; i++) {
			if (aPower == n - 1) {
				return true;
			} else {
				aPower = modPower(aPower, 2, n);
			}
		}
		if (aPower == n - 1) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isPrime(long n) {

		/* Quick Checks */
		if (n == 1) {
			return false;
		}
		if (n == 2 || n == 3 || n == 5 || n == 7) {
			return true;
		} else if ((n % 2 == 0)) {
			return false;
		}

		/*
		 * To make Miller-Rabin a deterministic test according to the
		 * generalized Reimann hypothesis, it is sufficient to have "a" be: 2,5,7,11,13,17,19,23
		 * for all 64 bit long numbers.
		 */
		else if (((millerRabin(2, n)))
				&& ((n <= 3) || (millerRabin(3, n)))
				&& ((n <= 5) || (millerRabin(5, n)))
				&& ((n <= 7) || (millerRabin(7, n)))
				&& ((n <= 11) || (millerRabin(11, n)))
				&& ((n <= 13) || (millerRabin(13, n)))
				&& ((n <= 17) || (millerRabin(17, n)))
				&& ((n <= 19) || (millerRabin(19, n)))
				&& ((n <= 23) || (millerRabin(23, n)))){
			return true;
		} else {
			return false;
		}
	}

	private void findNthPrime(int n) {
		int max = n;
		long y = 1;
		int i = 0;
		while (i < max) {
			y++;
			if (isPrime(y)) {
				i++;
			}
		}
		nthPrime = y;
	}

	public void printResult() {
		System.out.println(nthPrime + " is the " + n + " prime.");
	}

}
