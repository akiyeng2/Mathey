import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * @author Amalan Iyengar <amalan.iyengar@gmail.com>
 * @version 1.0
 * @since 2014-01-23
 */
public class Primes {
	/**
	 * Performs a primality test on a long integer
	 * @param number    number you want to perform a primality check on
	 * @return 			Boolean, true if it is prime, false if it isn't 
	 */
	boolean isPrime(long number){
		for(long i=0;i<Math.sqrt(number);i++){
			if(number%i==0){
				return false;
			}
		}
		return true;
	}
	/**
	 * Performs a primality test on an integer
	 * @param number    number you want to perform a primality check on
	 * @return 			Boolean, true if it is prime, false if it isn't 
	 */
	boolean isPrime(int number){
		for(int i=0;i<Math.sqrt(number);i++){
			if(number%i==0){
				return false;
			}
		}
		return true;
	}
	/**
	 * Returns an arrayList with all the primes up until a certain number
	 * <p>
	 * This implements the <a href="http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes">Sieve of Eratosthenes</a>. The general form of the algorithm is as such
	 * </p>
	 * <ol>
	 * 		<li>Create an array of integers from 2 to a specified max</li>
	 * 		<li>Assume the first number in the array to be prime</li>
	 *      <li>Set all the multiples of the first number to be false</li>
	 *      <li>Once you reach the end of the list, go back to step 2 until the initial number is greater than the square root of the maximum</li>
	 * </ol>
	 * @param max	The numbers you want to find primes up to
	 * @return		An ArrayList finding all the primes up to the number specified
	 */
	ArrayList<Integer> sieve(int max){
		Boolean[] primes=new Boolean[max];
		Arrays.fill(primes, true);
		for(int x=2;x<Math.sqrt(max);x++){
			for(int y=2*x;y<max;y+=x){
				primes[y]=false;
			}
		}
		ArrayList<Integer> primeslist=new ArrayList<Integer>();
		for(int i=2;i<max;i++){
			if(primes[i]==true){
				primeslist.add(i);
			}
		}

		return primeslist;
	}
		
}
