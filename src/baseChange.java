import java.lang.Math;
/**
 * This is a class used for converting strings and numbers from one base to another
 * 
 * @author Amalan Iyengar
 * @version 1.1
 * @since 2014-01-24
 */
public class baseChange {
	private final int PAD_LEFT=0;
	private final int PAD_RIGHT=1;
	private String reverse(String string){
		char[] digits=string.toCharArray();
		for(int i=0;i<digits.length/2;i++){
			char temp=digits[i];
			digits[i]=digits[digits.length-i-1];
			digits[digits.length-i-1]=temp;
		}
		return new String(digits);
	}
	//Yes, I know this can be accomplished by a simple 2-line function, but the point is to learn, no?
	/**
	 * This method converts a number from one base to another
	 * <p>
	 * This does it by splitting the original number into an array of digits, and then finding the decimal representation of the number by raising each digit to a power. 
	 * It then will convert it to the new base by taking repeated divisions and their remainders, until the number is less than one.
	 * I know that there already exists a way to do this, with <code>toString(int i, int radix)</code>, and <code>parseInt(String s, int radix)</code>, but I wanted to do it using as few built-in functions as possible.
	 * After it is done, it reverses the string, since the characters are appended back-to-front. 
	 * </p>
	 * 
	 * @param num	The number, represented as a String, that you want to convert from one base to another
	 * @param from	The base that the number is currently represented in. Must be between 2 and 36
	 * @param to	The desired destination base. Must be between 2 and 36
	 * @return		A string with the number in the desired destination base
	 * @throws		IllegalArgumentException If the bases are not between 2 and 36, or if there is a number that is not represented in the base specified
	 */
	public String convert(String num, int from, int to){
		if(from>36 || from<2){
			throw new IllegalArgumentException("Starting base must be between 2 and 36");
		}
		if(to>36 || to<2){
			throw new IllegalArgumentException("Ending base must be between 2 and 36");
		}
		char[] digits=num.toCharArray();
		int length=digits.length-1;
		int sum=0;
		
		for(char c:digits){
			int i=Character.getNumericValue(c);
			if(i>=from){
				throw new IllegalArgumentException("That number is invalid for the specified starting base");
			}
			sum+=(i*Math.pow(from, length));
			length--;
		}
		String result="";
		while(sum>=1){
			int remainder=sum%to;		
			sum/=to;
			if(remainder>9){
				result+=(char)(65+remainder-10);
				
			}else{
				result+=remainder;
			}
		}
		return reverse(result);
		
		
		
	}
	/**
	 * This program converts a string encoded in a specified base to a base 10 integer
	 * <p>
	 * This works in the exact same way that <code>conversion</code> works, except it converts it into an integer instead of a String.
	 * </p>
	 * 
	 * @param num	The number, represented as a string, that you want to convert to base 10
	 * @param from	The starting base
	 * @return		The base 10 representation of the given number
	 */
	public int toBase10(String num, int from){
		if(from>36 || from<2){
			throw new IllegalArgumentException("Starting base must be between 2 and 36");
		}
		char[] digits=num.toCharArray();
		int length=digits.length-1;
		int sum=0;
		
		for(char c:digits){
			int i=Character.getNumericValue(c);
			if(i>=from){
				throw new IllegalArgumentException("That number is invalid for the specified starting base");
			}
			sum+=(i*Math.pow(from, length));
			length--;
		}
		return sum;
	}
	private String pad(String str,int length,char paddingChar, int type){
		if(type==PAD_RIGHT){
			while(str.length()<length){
				str+=paddingChar;
			}

		}else if(type==PAD_LEFT){
			String newStr="";
			for(int i=0;i<length-str.length();i++){
				newStr+=paddingChar;
			}
			str=newStr+str;
		}
		return str;
	}
	/**
	 * This method encodes an ASCII string in a specified base
	 * <p>
	 * This works by splitting the string into its characters, then converting the characters into its ASCII integer, and then encoding that into a base.
	 * It is then padded into the correct number of characters so it can be decoded. For example, each base 2 number will be exactly 8 characters long, with leading zeros
	 * </p>
	 * 
	 * @param ASCII	The string in ASCII you want to convert
	 * @param to	The destination base
	 * @return		A string with a series of numbers that will decode to the ASCII string
	 */
	public String encodeASCII(String ASCII,int to){
		char[] characters=ASCII.toCharArray();
		String str="";
		for(char c:characters){
			str+=(pad(convert(Integer.toString((int)c),10,to),(int)Math.floor(Math.log(128)/Math.log(to)+1),'0',PAD_LEFT));
		}
		return str;

		
	}
	/**
	 * This method decodes an ASCII string given a specified base that it was encoded in
	 * <p>
	 * Since we know the base, we will just split the string into strings of whatever length it was calculated with. We get this by performing the operation
	 * <code>floor(log(128)/log(base)+1)</code><br>
	 * Since all the ASCII characters used here are under 128, which is 2^7, each base 2 string will be 8 characters long at max, so we make all of the base 2 strings 8 characters long
	 * so that we can split them. 
	 * 
	 * </p>
	 * @param numbers
	 * @param from
	 * @return An ASCII string with the encoded message
	 */
	public String decodeASCII(String numbers, int from){
		int length=(int)Math.floor(Math.log(128)/Math.log(from)+1);
		String result="";
		for(int i=0;i<numbers.length();i+=length){
			String character=numbers.substring(i,i+length);
			result+=(char)toBase10(convert(character,from,10),10);
		}
		return result;
	}
}
