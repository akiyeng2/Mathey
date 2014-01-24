import java.lang.Math;
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
	public String encodeASCII(String ASCII,int to){
		char[] characters=ASCII.toCharArray();
		String str="";
		for(char c:characters){
			str+=(pad(convert(Integer.toString((int)c),10,to),(int)Math.floor(Math.log(128)/Math.log(to)+1),'0',PAD_LEFT));
		}
		return str;

		
	}
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
