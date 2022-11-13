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
		
//	
//		////num1
//		fNum1();
//		
//		////operator
//		fOperator();
//		
//		////num2
//		fNum2();
//		
//		////result
//			int i=0,j=1;
//			for(i=0;i<j;i++) {
//		fResult(num1,num2,operatorS);
//			j++;
//			num1=result;
//			fOperator();
//			fNum2();
//		}
//			
			
			for(int i=1;i<2;i++) {
				if(numb1==0) {
					numb1=fNum1();
				}else {
					//somthing
				}
				String oprtS=fOperator();
				if(oprtS.equals("=")) {
					//somthimg
				}else {
					numb2=fNum2();
					rslt=fResult(numb1, oprtS, numb2);
					fDesplay(rslt);
				}
				numb1=rslt;
				i=i-1;
			}
			
			
//			fResult(num1,num2,operatorS);
//			fNum1();
//			fOperator();
//			fNum2();
//			
			
		
	}
	
	






	static double fNum1() {
		if(num1==0) {
		System.out.println("Enter a first number");
		String num1S=sc.next().toString();
		num1=Double.parseDouble(num1S);
		}else {
			num1=result;
		}
		return num1;
	}
	
	static String fOperator() {
		for(int i=1;i<2;i++) {
		System.out.println("Enter a Operator@");
		operatorS=sc.next().toString();
		if(operatorS.equals("=")||operatorS.equals("+")||operatorS.equals("-")||operatorS.equals("*")||operatorS.equals("/")) {
				if(operatorS.equals("=")) {
					rslt=numb1;  //  (numb1 value+numb2 0)
					System.out.println("Result is "+rslt);
				}else{
					
				}
		}else {
			System.out.println("invalid operator#");
			i=i-1;
		}
		}
		return operatorS;
	}
	
	static double fNum2() {
		System.out.println("Enter a second number");
		String num2S=sc.next().toString();
		num2=Integer.parseInt(num2S);
		return num2;
	}
	
	static double fResult(double numbr1, String oprtrS, double numbr2) {
		double rsltOprton=0;
		System.out.println("Enter a Operator#");
		operatorS=sc.next().toString();
		if(operatorS.equals("=")) {
			rsltOprton=fOperation(numbr1,oprtrS,numbr2);
		}else if(operatorS.equals("+")||operatorS.equals("-")||operatorS.equals("*")||operatorS.equals("/")){
			rsltOprton=fOperation(numbr1,oprtrS,numbr2);
			
		}
	return rsltOprton;
}

	static double fOperation(double numbr1, String oprtrS, double numbr2) {
		if(oprtrS.equals("+")) {
			 result=numbr1+numbr2;
			}else if(oprtrS.equals("-")) {
				result=numbr1-numbr2;
			}else if(oprtrS.equals("*")) {
				result=numbr1*numbr2;
			}else if(oprtrS.equals("/")) {
				result=numbr1/numbr2;
			}else {
				//System.out.println("invalid operator");
			}
		return result;
	}

	static void fDesplay(double rsult) {
		System.out.println(rsult);
	}

	
	
	
	
//	
//	
//	static void fNum1() {
//		System.out.println("Enter a number");
//		num1S=sc.next().toString();
//		num1=Integer.parseInt(num1S);
//	}
//	
//	static void fOperator() {
//		if(oprtr==false) {
//			System.out.println("Enter a Operator");
//			operatorS=sc.next().toString();
//			oprtr=true;
//		}else {
////			if(operatorS.equals("+")||operatorS.equals("-")||operatorS.equals("*")||operatorS.equals("/")) {
////			int i=0,j=1;
////			for(i=0;i<j;i++) {
//		fResult(num1,num2,operatorS);
////			j++;
//			num1=result;
//			System.out.println("Entered operator "+operatorS);
//			fNum2();
////			}
////		  }
//		}
//	}
//	
//	static void fNum2() {
//		System.out.println("Enter a number");
//		num2S=sc.next().toString();
//		num2=Integer.parseInt(num2S);
//	}
//	
//	static void fResult(int numb1, int numb2, String operatorb) {
//		System.out.println(numb1+"  "+operatorb+"  "+numb2);
//		if(oprtr=false){ 
//	  System.out.println("enter a operator or =");
//	  resultS=sc.next().toString();
//		}else {
//			
//		}
//	  if(resultS.equals("=")) {
//		
//		if(operatorb.equals("+")) {
//		 result=numb1+numb2;
//			System.out.println(result);
//		}else if(operatorb.equals("-")) {
//			result=numb1-numb2;
//			System.out.println(result);
//		}else if(operatorb.equals("*")) {
//			result=numb1*numb2;
//			System.out.println(result);
//		}else if(operatorb.equals("/")) {
//			result=numb1/numb2;
//			System.out.println(result);
//		}else {
//			System.out.println("invalid operator");
//		}
//		resultS="x=x";
//	  }else if(operatorS.equals("+")||operatorS.equals("-")||operatorS.equals("*")||operatorS.equals("/")){
//		//  fOperator();
//	  }else {
//		  System.out.println("invalid operator");
//	  }
//	}
	
	
}
