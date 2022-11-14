package newCalculator;

import java.nio.file.FileVisitResult;
import java.util.Scanner;

public class Calculator {

	
	
	static Scanner sc=new Scanner(System.in);
	static String operatorS="";
	static double num1=0,num2=0,result=0;
	static String oprtS="";
	static double numb1=0,numb2=0,rslt=0;
	static String[] arrMemory=new String[100];
	static int arrLastPos=0;

	
	
	public static void main(String arg[]) {
		
			preSetArrMemory();

			
			for(int i=1;i<2;i++) {
				if(numb1==0) {
					numb1=fNum1();  
					String sNumb1=String.valueOf(numb1);
					addArrMemory(sNumb1);
				}else {
					//somthing
				}
				String oprtS=fOperator();     
					String sOprt=String.valueOf(oprtS);  
					addArrMemory(sOprt);
				if(oprtS.equals("=")) {
					//somthimg
				}else {
					numb2=fNum2();      
						String sNumb2=String.valueOf(numb2);
						addArrMemory(sNumb2);
					rslt=fResult(numb1, oprtS, numb2);
					fDesplay(rslt);      
						String sRslt=String.valueOf(rslt);  
						addArrMemory(sRslt);
				}
				numb1=rslt;
				i=i-1;
				readArrMemory();
			}
		
	
	}
	
	



	private static void preSetArrMemory() {
		for(int i=0;i<20;i++) {
			 arrMemory[i]="dummy";
		}
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
		if(operatorS.equals("=")||operatorS.equals("+")||operatorS.equals("-")||operatorS.equals("*")||operatorS.equals("/")||operatorS.equals("%")) {
				if(operatorS.equals("=")) {
						String sOperator=String.valueOf(operatorS);  
						addArrMemory(sOperator);
					numb2=0;          
						String sNumb2=String.valueOf(numb2);
						addArrMemory(sNumb2);
					rslt=numb1+numb2;  //  (numb1 value+numb2 0)
					fDesplay(rslt);   
						String sRslt=String.valueOf(rslt);
						addArrMemory(sRslt);
				}else if(operatorS.equals("%")){
					rslt=numb1/100;
					fDesplay(rslt);
						String sRslt=String.valueOf(rslt);
						addArrMemory(sRslt);
				}else {
					
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
		System.out.println("Enter a Operator#");
		operatorS=sc.next().toString();
		if(operatorS.equals("=")) {
				String sOperator=String.valueOf(operatorS);  
				addArrMemory(sOperator);
			rsltOprton=fOperation(numbr1,oprtrS,numbr2);
		}else if(operatorS.equals("+")||operatorS.equals("-")||operatorS.equals("*")||operatorS.equals("/")){
			rsltOprton=fOperation(numbr1,oprtrS,numbr2);
		}else if(operatorS.equals("%")){
				String sOperator=String.valueOf(operatorS);  
				addArrMemory(sOperator);
			rsltOprton=fPercentage(numbr1,oprtrS,numbr2);//rsltOprton*100;
		}else {
			System.out.println("invalid operator#");
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
		System.out.println(rsult);
	}

	static void addArrMemory(String addValeuS){
		  arrMemory[arrLastPos]=addValeuS; arrLastPos=arrLastPos+1;     /////////////////
	}
	
	static void readArrMemory() {
		String mergeValueS="";
		for(int i=0;i<20;i++) {
		String readValueS=arrMemory[i];
		if(readValueS.equals("dummy")) {
			//somthing
		}else {
			
			mergeValueS=mergeValueS+readValueS;
		}
		}
		System.out.println(mergeValueS);
	}
	
	
}
