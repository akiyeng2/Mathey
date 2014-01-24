import java.lang.Math;
public class baseChange {
	private static String reverse(String string){
		char[] digits=string.toCharArray();
		for(int i=0;i<digits.length/2;i++){
			char temp=digits[i];
			digits[i]=digits[digits.length-i-1];
			digits[digits.length-i-1]=temp;
		}
		return new String(digits);
	}
	//Yes, I know this can be accomplished by a simple 2-line function, but the point is to learn, no?
	public static String convert(String num, int from, int to){
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
	
}
