package newCalculator;

import java.nio.file.FileVisitResult;
import java.util.Scanner;

public class Calculator {

	
	
	static Scanner sc=new Scanner(System.in);
	static String operatorS="";
	static double num1=0,num2=0,result=0;
	static String oprtS="";
	static double numb1=0,numb2=0,rslt=0;
	
	
	
	public static void main(String arg[]) {

			
			for(int i=1;i<2;i++) {
				if(numb1==0) {
					numb1=fNum1();
				}else {System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK10");
					//somthing
				}
				String oprtS=fOperator();
				if(oprtS.equals("=")) {System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK11");
					//somthimg
				}else {
					numb2=fNum2();
					rslt=fResult(numb1, oprtS, numb2);
					fDesplay(rslt);
				}
				numb1=rslt;
				i=i-1;
			}
		
		
	}
	
	



	static double fNum1() {
		if(num1==0) {
		System.out.println("Enter a first number");
		String num1S=sc.next().toString();
		num1=Double.parseDouble(num1S);
		}else {
			num1=result;System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK9");
		}
		return num1;
	}
	
	static String fOperator() {
		for(int i=1;i<2;i++) {
		System.out.println("Enter a Operator@");
		operatorS=sc.next().toString();
		if(operatorS.equals("=")||operatorS.equals("+")||operatorS.equals("-")||operatorS.equals("*")||operatorS.equals("/")||operatorS.equals("%")) {
				if(operatorS.equals("=")) {System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK8");
					rslt=numb1;  //  (numb1 value+numb2 0)
					fDesplay(rslt);
				}else if(operatorS.equals("%")){
					rslt=numb1/100;
					fDesplay(rslt);
				}else {System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK7");
					
				}
		}else {
			System.out.println("invalid operator@");
			i=i-1;
		}
		}
		return operatorS;
	}
	
	static double fNum2() {
		System.out.println("Enter a second number");
		String num2S=sc.next().toString();
		num2=Double.parseDouble(num2S);
		return num2;
	}
	
	static double fResult(double numbr1, String oprtrS, double numbr2) {
		double rsltOprton=0;
		System.out.println("Enter a Operator#");System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK5");
		operatorS=sc.next().toString();
		if(operatorS.equals("=")) {
			rsltOprton=fOperation(numbr1,oprtrS,numbr2);System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK4");
		}else if(operatorS.equals("+")||operatorS.equals("-")||operatorS.equals("*")||operatorS.equals("/")){
			rsltOprton=fOperation(numbr1,oprtrS,numbr2);System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK3");
		}else if(operatorS.equals("%")){
			rsltOprton=fPercentage(numbr1,oprtrS,numbr2);//rsltOprton*100;
		}else {
			System.out.println("invalid operator#");
		}
	return rsltOprton; 
}

	static double fOperation(double numbr1, String oprtrS, double numbr2) {System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK2");
			if(oprtrS.equals("+")) {
			 result=numbr1+numbr2;
			}else if(oprtrS.equals("-")) {
				result=numbr1-numbr2;
			}else if(oprtrS.equals("*")) {
				result=numbr1*numbr2;
			}else if(oprtrS.equals("/")) {
				result=numbr1/numbr2;
			}else {System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK6");
				//System.out.println("invalid operator");
			}
		return result;  
	}
	
	static double fPercentage(double numbr1, String oprtrS, double numbr2){double preResult=0;
		if(oprtrS.equals("+")) {
			 	result=numbr1+(numbr2/100);
			}else if(oprtrS.equals("-")) {
				result=numbr1-(numbr2/100);
			}else if(oprtrS.equals("*")) {
				result=numbr1*(numbr2/100);
			}else if(oprtrS.equals("/")) {
				result=numbr1/(numbr2/100);
			}else {
				//System.out.println("invalid operator");
			}
		return result;  
	}

	static void fDesplay(double rsult) {
		System.out.println(rsult);System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK1");
	}

	
	
}
