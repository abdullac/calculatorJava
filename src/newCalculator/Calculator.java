package newCalculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileVisitResult;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener{

	static JFrame jf;
	static JButton oneButton,twoButton,threeButton,fourButton,fiveButton,sixButton,sevenButton,eightButton,nineButton,zeroButton,dotButton,percentageButton,divideButton,multyButton,substractButton,additionButton,equalButton,eraseButton,functionButton,prevButton,nextButton,correctButton,historyButton,ceButton,acButton;
	static JLabel functionLabel,desplayLabel,operatorLabel;
	static String labelText="0";
	static Boolean isOperatorClicked=false;
	
	
	static Scanner sc=new Scanner(System.in);
	static String operatorS="";
	static double num1=0,num2=0,result=0;
	static String oprtS="";
	static double numb1=0,numb2=0,rslt=0;
	static String[] arrMemory=new String[100];
	static int arrLastPos=0;

	
	
	public static void main(String arg[]) {
		
		///	mainFunction();
		
		new Calculator();
			
	
	}
	
	
	

	
	
	
	
	  ///  calculator class, this is not function
	public Calculator() {
		
		
		
		/***********************************/
		
		
		
		
		/************************************/
		
		
		
		jf=new JFrame("CALCULATOR");
		jf.setLayout(null);
		jf.setSize(800,700);
		jf.setLocation(80, 100);;
		
		
		functionLabel=new JLabel("function label");
		functionLabel.setBounds(100,20,30,40);
		functionLabel.setBackground(Color.lightGray);
		functionLabel.setOpaque(true);
		functionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		functionLabel.setForeground(Color.darkGray);
		jf.add(functionLabel);
		
		desplayLabel=new JLabel("0");
		desplayLabel.setBounds(131,20,530,40);
		desplayLabel.setBackground(Color.lightGray);
		desplayLabel.setOpaque(true);
		desplayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		desplayLabel.setForeground(Color.darkGray);
		jf.add(desplayLabel);
		
		operatorLabel=new JLabel("desplay label");
		operatorLabel.setBounds(662,20,30,40);
		operatorLabel.setBackground(Color.lightGray);
		operatorLabel.setOpaque(true);
		operatorLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		operatorLabel.setForeground(Color.darkGray);
		jf.add(operatorLabel);
		
		
		functionButton=new JButton("Func");
		functionButton.setBounds(100,80,70,50);
		functionButton.addActionListener(this);
		jf.add(functionButton);
		
		prevButton=new JButton("<Prv");
		prevButton.setBounds(180,80,70,50);
		prevButton.addActionListener(this);
		jf.add(prevButton);
		
		nextButton=new JButton("Nxt>");
		nextButton.setBounds(260,80,70,50);
		nextButton.addActionListener(this);
		jf.add(nextButton);
		
		correctButton=new JButton("Crct");
		correctButton.setBounds(340,80,70,50);
		correctButton.addActionListener(this);
		jf.add(correctButton);
		
		historyButton=new JButton("Hsry");
		historyButton.setBounds(420,80,70,50);
		historyButton.addActionListener(this);
		jf.add(historyButton);
		
		ceButton=new JButton("CE");
		ceButton.setBounds(420,150,70,50);
		ceButton.addActionListener(this);
		jf.add(ceButton);
		
		acButton=new JButton("AC");
		acButton.setBounds(420,220,70,50);
		acButton.addActionListener(this);
		jf.add(acButton);
		
		
		
		
		sevenButton=new JButton("7");
		sevenButton.setBounds(100,150,60,60);
		sevenButton.setFont(new Font("Arial", Font.BOLD, 32));
		sevenButton.addActionListener(this);
		jf.add(sevenButton);
		
		eightButton=new JButton("8");
		eightButton.setBounds(180,150,60,60);
		eightButton.setFont(new Font("Arial", Font.BOLD, 32));
		eightButton.addActionListener(this);
		jf.add(eightButton);
		
		nineButton=new JButton("9");
		nineButton.setBounds(260,150,60,60);
		nineButton.setFont(new Font("Arial", Font.BOLD, 32));
		nineButton.addActionListener(this);
		jf.add(nineButton);
		
		percentageButton=new JButton("%");
		percentageButton.setBounds(350,150,60,60);
		percentageButton.setFont(new Font("Arial", Font.BOLD, 25));
		percentageButton.addActionListener(this);
		jf.add(percentageButton);
		
		fourButton=new JButton("4");
		fourButton.setBounds(100,230,60,60);
		fourButton.setFont(new Font("Arial", Font.BOLD, 32));
		fourButton.addActionListener(this);
		jf.add(fourButton);
		
		fiveButton=new JButton("5");
		fiveButton.setBounds(180,230,60,60);
		fiveButton.setFont(new Font("Arial", Font.BOLD, 32));
		fiveButton.addActionListener(this);
		jf.add(fiveButton);
		
		sixButton=new JButton("6");
		sixButton.setBounds(260,230,60,60);
		sixButton.setFont(new Font("Arial", Font.BOLD, 32));
		sixButton.addActionListener(this);
		jf.add(sixButton);
		
		divideButton=new JButton("/");
		divideButton.setBounds(350,230,60,60);
		divideButton.setFont(new Font("Arial", Font.BOLD, 32));
		divideButton.addActionListener(this);
		jf.add(divideButton);
		
		oneButton=new JButton("1");
		oneButton.setBounds(100,310,60,60);
		oneButton.setFont(new Font("Arial", Font.BOLD, 32));
		oneButton.addActionListener(this);
		jf.add(oneButton);
		
		twoButton=new JButton("2");
		twoButton.setBounds(180,310,60,60);
		twoButton.setFont(new Font("Arial", Font.BOLD, 32));
		twoButton.addActionListener(this);
		jf.add(twoButton);
		
		threeButton=new JButton("3");
		threeButton.setBounds(260,310,60,60);
		threeButton.setFont(new Font("Arial", Font.BOLD, 32));
		threeButton.addActionListener(this);
		jf.add(threeButton);
		
		multyButton=new JButton("X");
		multyButton.setBounds(350,310,60,60);
		multyButton.setFont(new Font("Arial", Font.BOLD, 25));
		multyButton.addActionListener(this);
		jf.add(multyButton);
		
		zeroButton=new JButton("0");
		zeroButton.setBounds(100,390,60,60);
		zeroButton.setFont(new Font("Arial", Font.BOLD, 32));
		zeroButton.addActionListener(this);
		jf.add(zeroButton);
		
		additionButton=new JButton("+");
		additionButton.setBounds(180,390,140,60);
		additionButton.setFont(new Font("Arial", Font.BOLD, 32));
		additionButton.addActionListener(this);
		jf.add(additionButton);
		
		substractButton=new JButton("-");
		substractButton.setBounds(350,390,60,60);
		substractButton.setFont(new Font("Arial", Font.BOLD, 32));
		substractButton.addActionListener(this);
		jf.add(substractButton);
		
		dotButton=new JButton(".");
		dotButton.setBounds(100,470,60,60);
		dotButton.setFont(new Font("Arial", Font.BOLD, 32));
		dotButton.addActionListener(this);
		jf.add(dotButton);
		
		equalButton=new JButton("=");
		equalButton.setBounds(180,470,140,60);
		equalButton.setFont(new Font("Arial", Font.BOLD, 32));
		equalButton.addActionListener(this);
		jf.add(equalButton);
		
		eraseButton=new JButton("<x");
		eraseButton.setBounds(350,470,60,60);
		eraseButton.setFont(new Font("Arial", Font.PLAIN, 18));
		eraseButton.addActionListener(this);
		jf.add(eraseButton);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	
	
	
	
	
















	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	static void mainFunction() {
		preSetArrMemory();

		
		for(int i=1;i<2;i++) {
//			if(numb1==0) {
//				numb1=fNum1();  
//				String sNumb1=String.valueOf(numb1);
//				addArrMemory(sNumb1);
//			}else {
//				//somthing
//			}
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

//	static double fNum1() {
//		if(num1==0) {
//		System.out.println("Enter a first number");
//		String num1S=sc.next().toString();
//		num1=Double.parseDouble(num1S);
//		}else {
//			num1=result;
//		}
//		return num1;
//	}
	
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
////////////////////////////////////////////////////////////////////////////////////////////////////







	@Override
	public void actionPerformed(ActionEvent e) {
		//jf.getContentPane().setBackground(Color.blue);
		
		if(e.getSource()== oneButton) {
			fSetLabelText("1");
		}else if(e.getSource()== twoButton) {
			fSetLabelText("2");
		}else if(e.getSource()== threeButton) {
			fSetLabelText("3");
		}else if(e.getSource()== fourButton) {
			fSetLabelText("4");
		}else if(e.getSource()== fiveButton) {
			fSetLabelText("5");
		}else if(e.getSource()== sixButton) {
			fSetLabelText("6");
		}else if(e.getSource()== sevenButton) {
			fSetLabelText("7");
		}else if(e.getSource()== eightButton) {
			fSetLabelText("8");
		}else if(e.getSource()== nineButton) {
			fSetLabelText("9");
		}else if(e.getSource()== zeroButton) {
			fSetLabelText("0");
		}else if(e.getSource()== dotButton) {
			fSetLabelText(".");
		}else if(e.getSource()== ceButton) {
			fSetLabelText("ce");
		}else if(e.getSource()== acButton) {
			fSetLabelText("ac");
		}else if(e.getSource()== percentageButton) {
			fSetLabelText("%");
		}else if(e.getSource()== divideButton) {
			fSetLabelText("/");
		}else if(e.getSource()== multyButton) {
			fSetLabelText("x");
		}else if(e.getSource()== substractButton) {
			fSetLabelText("-");
		}else if(e.getSource()== additionButton) {
			fSetLabelText("+");
		}else {
			
		}
		
	}
	
	
	void fSetLabelText(String buttonValue) {
		if(buttonValue.equals("ce")||buttonValue.equals("ac")||buttonValue.equals("%")||buttonValue.equals("/")||buttonValue.equals("x")||buttonValue.equals("-")||buttonValue.equals("+")) {
			if(buttonValue.equals("ce")||buttonValue.equals("ac")) {
			
			}else {
				/**/
				if(numb1==0) {
					numb1=fNum1();  
					String sNumb1=String.valueOf(numb1);
					addArrMemory(sNumb1);
					System.out.println(numb1);
				}else {
					//somthing
				}
				/**/
			}
			desplayLabel.setText("0");
		}else {
			String desplayValueS=desplayLabel.getText();
			if(desplayValueS.equals("0")) {
			desplayLabel.setText(buttonValue);
			}else {
			desplayLabel.setText(desplayValueS+buttonValue);
			}
		}
	}




	
	
	
	static double fNum1() {
		if(num1==0) {
		String num1S=desplayLabel.getText();
		num1=Double.parseDouble(num1S);
		}else {
			num1=result;
		}
		return num1;
	}
	
	
	
	
	
	
	
	
	
}
