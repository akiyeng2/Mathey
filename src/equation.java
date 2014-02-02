import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Queue;
class Token{
	final int NUMBER=0;
	final int FUNCTION=1;
	final int SEPARATOR=2;
	final int OPERATOR=3;
	final int RIGHT_PAREN=4;
	final int LEFT_PAREN=5;
	final int LEFT_ASSOCIATIVE=-1;
	final int RIGHT_ASSOCIATIVE=1;
	String name;
	public int type;
	public int precedence;
	public int associativity;
	private String[] functions={"abs","acos","asin","atan","cos","log10","ln","log","sin","sqrt","tan","root"};
	private String[] operators={"+","-","*","/","^"};
	private boolean isNumeric(String s){
		//Thanks to @CraigTP at Stack Overflow for this regex
		return s.matches("?\\d+(\\.\\d+)");
	}
	public Token(){};
	public Token(String t,Token previous) throws IllegalArgumentException{
		name=t;	
		if(isNumeric(t)){
			type=NUMBER;
		}
		if(Arrays.asList(functions).contains(t)){
			type=FUNCTION;
		}
		if(t==","){
			type=SEPARATOR;
		}
		if(Arrays.asList(operators).contains(t)){
			type=OPERATOR;
			if(t=="^"){
				precedence=10;
				associativity=RIGHT_ASSOCIATIVE;
			}else if(t=="*"|| t=="/"){
				precedence=5;
				associativity=LEFT_ASSOCIATIVE;
			}else if(t=="+"){
				precedence=1;
				associativity=LEFT_ASSOCIATIVE;
			}else if(t=="-"){
				if(previous.type==NUMBER || previous.type==RIGHT_PAREN){
					precedence=1;
					associativity=LEFT_ASSOCIATIVE;
				}else{
					precedence=15;
					associativity=RIGHT_ASSOCIATIVE;
				}
			}
		}else if(t=="("){
			type=RIGHT_PAREN;
		}else if(t==")"){
			type=LEFT_PAREN;
		}else{
			throw new IllegalArgumentException("The token "+t+" is not recognized");
		}
		
	}
	public String toString(){
		return name+","+type+","+precedence;
	}
	public ArrayList<Token> tokenize(ArrayList<String> t){
		ArrayList<Token> tokens=new ArrayList<Token>();
		for(String s:t){
			tokens.add(new Token(s,new Token()));
		}
		return tokens;
		
	}
}
public class equation{
	ArrayList<String> tokens;
	ArrayList<Token> equation;
	String function;
	public equation(String fn){
		function=fn;
		String[] parts = function.split("(?<=[^\\.a-zA-Z\\d])|(?=[^\\.a-zA-Z\\d])");
		tokens=new ArrayList<String>(Arrays.asList(parts));
		System.out.println(tokens);

	}
	public static void main(String[] args){
		new equation("sin(-443)^2");
		

	}
}
