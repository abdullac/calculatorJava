package newCalculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.file.FileVisitResult;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener, MouseListener{

	static JFrame jf;
	static JButton oneButton,twoButton,threeButton,fourButton,fiveButton,sixButton,sevenButton,eightButton,nineButton,zeroButton,dotButton,percentageButton,divideButton,multyButton,substractButton,additionButton,equalButton,eraseButton,functionButton,prevButton,nextButton,correctButton,historyButton,ceButton,acButton;
	static JLabel functionLabel,desplayLabel,operatorLabel;
	static String labelText="0";
	static Boolean isOperatorClicked=false;
	static Boolean isNumberClicked=false;
	static Boolean isDotClicked=false;
	static String num1S="";
	static double num1=0;
	static String tempClickedOperator="";
	static String[] arrHistory=new String[100]; 
	static int arrLastPos=0;
	static int arrCurrentPos=0;
	static String resultSS="";
	

	
	
	public static void main(String arg[]) {
		
		///	mainFunction();
		
		new Calculator();
		
			
	
	}
	
	
	

	
	
	
	
	  ///  calculator class, this is not function
	public Calculator() {
		
		
		preSetArrHistory();
	
		
		
		jf=new JFrame("CALCULATOR");
		jf.setLayout(null);
		jf.setSize(400,600);
		jf.setLocation(280, 100);;
		jf.getContentPane().setBackground(Color.GRAY);
		
		
	/*	functionLabel=new JLabel("function label");
		functionLabel.setBounds(100,20,30,40);
		functionLabel.setBackground(Color.lightGray);
		functionLabel.setOpaque(true);
		functionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		functionLabel.setForeground(Color.darkGray);
		jf.add(functionLabel); */
		
		desplayLabel=new JLabel("");
		desplayLabel.setText("0");
		desplayLabel.setBounds(40,20,290,40);
		desplayLabel.setBackground(Color.lightGray);
		desplayLabel.setOpaque(true);
		desplayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		desplayLabel.setForeground(Color.darkGray);
		desplayLabel.setFont(new Font("Arial", Font.BOLD, 38));
		jf.add(desplayLabel);
		
		operatorLabel=new JLabel("");
		operatorLabel.setBounds(331,20,19,40);
		operatorLabel.setBackground(Color.lightGray);
		operatorLabel.setOpaque(true);
		operatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		operatorLabel.setForeground(Color.darkGray);
		jf.add(operatorLabel);  
		
	/*	
		functionButton=new JButton("Func");
		functionButton.setBounds(100,80,70,50);
		functionButton.addActionListener(this);
		jf.add(functionButton);  */
		
		prevButton=new JButton("<Prv");
		prevButton.setBounds(40,80,70,50);
		prevButton.addActionListener(this);
		jf.add(prevButton);
		
		
		nextButton=new JButton("Nxt>");
		nextButton.setBounds(120,80,70,50);
		nextButton.addActionListener(this);
		jf.add(nextButton);
		
/*		correctButton=new JButton("Crct");
		correctButton.setBounds(340,80,70,50);
		correctButton.addActionListener(this);
		jf.add(correctButton); */
		
		historyButton=new JButton("Hsry");
		historyButton.setBounds(200,80,70,50);
		historyButton.addActionListener(this);
		historyButton.addMouseListener(this);
		jf.add(historyButton);
		
/*		ceButton=new JButton("CE");
		ceButton.setBounds(420,150,70,50);
		ceButton.addActionListener(this);
		jf.add(ceButton); */
		
		acButton=new JButton("AC");
		acButton.setBounds(280,80,70,50);
		acButton.addActionListener(this);
		jf.add(acButton);
		
		
		
		
		sevenButton=new JButton("7");
		sevenButton.setBounds(40,150,60,60);
		sevenButton.setFont(new Font("Arial", Font.BOLD, 32));
		sevenButton.addActionListener(this);
		jf.add(sevenButton);
		
		eightButton=new JButton("8");
		eightButton.setBounds(120,150,60,60);
		eightButton.setFont(new Font("Arial", Font.BOLD, 32));
		eightButton.addActionListener(this);
		jf.add(eightButton);
		
		nineButton=new JButton("9");
		nineButton.setBounds(200,150,60,60);
		nineButton.setFont(new Font("Arial", Font.BOLD, 32));
		nineButton.addActionListener(this);
		jf.add(nineButton);
		
		percentageButton=new JButton("%");
		percentageButton.setBounds(290,150,60,60);
		percentageButton.setFont(new Font("Arial", Font.BOLD, 25));
		percentageButton.addActionListener(this);
		jf.add(percentageButton);
		
		fourButton=new JButton("4");
		fourButton.setBounds(40,230,60,60);
		fourButton.setFont(new Font("Arial", Font.BOLD, 32));
		fourButton.addActionListener(this);
		jf.add(fourButton);
		
		fiveButton=new JButton("5");
		fiveButton.setBounds(120,230,60,60);
		fiveButton.setFont(new Font("Arial", Font.BOLD, 32));
		fiveButton.addActionListener(this);
		jf.add(fiveButton);
		
		sixButton=new JButton("6");
		sixButton.setBounds(200,230,60,60);
		sixButton.setFont(new Font("Arial", Font.BOLD, 32));
		sixButton.addActionListener(this);
		jf.add(sixButton);
		
		divideButton=new JButton("/");
		divideButton.setBounds(290,230,60,60);
		divideButton.setFont(new Font("Arial", Font.BOLD, 32));
		divideButton.addActionListener(this);
		jf.add(divideButton);
		
		oneButton=new JButton("1");
		oneButton.setBounds(40,310,60,60);
		oneButton.setFont(new Font("Arial", Font.BOLD, 32));
		oneButton.addActionListener(this);
		jf.add(oneButton);
		
		twoButton=new JButton("2");
		twoButton.setBounds(120,310,60,60);
		twoButton.setFont(new Font("Arial", Font.BOLD, 32));
		twoButton.addActionListener(this);
		jf.add(twoButton);
		
		threeButton=new JButton("3");
		threeButton.setBounds(200,310,60,60);
		threeButton.setFont(new Font("Arial", Font.BOLD, 32));
		threeButton.addActionListener(this);
		jf.add(threeButton);
		
		multyButton=new JButton("X");
		multyButton.setBounds(290,310,60,60);
		multyButton.setFont(new Font("Arial", Font.BOLD, 25));
		multyButton.addActionListener(this);
		jf.add(multyButton);
		
		zeroButton=new JButton("0");
		zeroButton.setBounds(40,390,60,60);
		zeroButton.setFont(new Font("Arial", Font.BOLD, 32));
		zeroButton.addActionListener(this);
		jf.add(zeroButton);
		
		additionButton=new JButton("+");
		additionButton.setBounds(120,390,140,60);
		additionButton.setFont(new Font("Arial", Font.BOLD, 32));
		additionButton.addActionListener(this);
		jf.add(additionButton);
		
		substractButton=new JButton("-");
		substractButton.setBounds(290,390,60,60);
		substractButton.setFont(new Font("Arial", Font.BOLD, 32));
		substractButton.addActionListener(this);
		jf.add(substractButton);
		
		dotButton=new JButton(".");
		dotButton.setBounds(40,470,60,60);
		dotButton.setFont(new Font("Arial", Font.BOLD, 32));
		dotButton.addActionListener(this);
		jf.add(dotButton);
		
		equalButton=new JButton("=");
		equalButton.setBounds(120,470,140,60);
		equalButton.setFont(new Font("Arial", Font.BOLD, 32));
		equalButton.addActionListener(this);
		jf.add(equalButton);
		
		eraseButton=new JButton("<x");
		eraseButton.setBounds(290,470,60,60);
		eraseButton.setFont(new Font("Arial", Font.PLAIN, 18));
		eraseButton.addActionListener(this);
		jf.add(eraseButton);
			
		
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		//jf.getContentPane().setBackground(Color.blue);
		
		if(e.getSource()== oneButton) {
			fSetLabelText("1","num");
		}else if(e.getSource()== twoButton) {
			fSetLabelText("2","num");
		}else if(e.getSource()== threeButton) {
			fSetLabelText("3","num");
		}else if(e.getSource()== fourButton) {
			fSetLabelText("4","num");
		}else if(e.getSource()== fiveButton) {
			fSetLabelText("5","num");
		}else if(e.getSource()== sixButton) {
			fSetLabelText("6","num");
		}else if(e.getSource()== sevenButton) {
			fSetLabelText("7","num");
		}else if(e.getSource()== eightButton) {
			fSetLabelText("8","num");
		}else if(e.getSource()== nineButton) {
			fSetLabelText("9","num");
		}else if(e.getSource()== zeroButton) {
			fSetLabelText("0","num");
		}else if(e.getSource()== dotButton) {
			fSetLabelText(".0","num");
			fDotAdditional();
		}else if(e.getSource()== ceButton) {
			fSetLabelText("ce","opr");
		}else if(e.getSource()== acButton) {
			fSetLabelText("ac","opr");
		}else if(e.getSource()== percentageButton) {
			fSetLabelText("%","opr");
		}else if(e.getSource()== divideButton) {
			fSetLabelText("/","opr");
		}else if(e.getSource()== multyButton) {
			fSetLabelText("x","opr");
		}else if(e.getSource()== substractButton) {
			fSetLabelText("-","opr");
		}else if(e.getSource()== additionButton) {
			fSetLabelText("+","opr");
		}else if(e.getSource()== equalButton) {
			fSetLabelText("=","opr");
		}else if(e.getSource()== eraseButton) {
			fSetLabelText("<x","opr");
		}else if(e.getSource()== historyButton) {
			fSetLabelText("hsry","fun");
		}else if(e.getSource()== correctButton) {
			fSetLabelText("crct","fun");
		}else if(e.getSource()== nextButton) {
			fSetLabelText("nxt","fun");
		}else if(e.getSource()== prevButton) {
			fSetLabelText("prv","fun");
		}else if(e.getSource()== functionButton) {
			fSetLabelText("func","fun");
		}else {
			
		}
		
	}
	








			static void fSetLabelText(String buttonValue, String buttonType) {
				if(buttonType=="opr"/*buttonValue.equals("ce")||buttonValue.equals("ac")||buttonValue.equals("%")||buttonValue.equals("/")||buttonValue.equals("x")||buttonValue.equals("-")||buttonValue.equals("+")*/) {
					if(buttonValue.equals("ce")||buttonValue.equals("ac")||buttonValue.equals("<x")) {
						if(buttonValue.equals("<x")) {
							eraseResult();
						}else {
							desplayLabel.setText("0");
							if(buttonValue.equals("ac")) {
								preSetArrHistory();
							}else {
							}
						}
					}else {
						if(desplayLabel.getText()=="0"||isOperatorClicked==true) {
							if(buttonValue=="%" && desplayLabel.getText()!="0") {
								percentageResult();
							}else {
							}
						}else {
						isOperatorClicked=true;
						System.out.println("true");
						if(buttonValue=="=") {
							equalResult();
						}else if(buttonValue=="%") {
							percentageResult();
						}else {
							operatersResult(buttonValue);
						}
					}
					}
				}else if(buttonType=="num"){
					operatorLabel.setText("");
					String desplayValueS=desplayLabel.getText();
					if(desplayValueS.length()==11) {
						//somthing
					}else {
						isNumberClicked=true;
					if(isOperatorClicked==true) {
						desplayLabel.setText("");
						isOperatorClicked=false;
						System.out.println("false");
					}else {
					}
					if(desplayValueS.equals("0")) {
					desplayLabel.setText(buttonValue);
					}else if(buttonValue.equals(".0")) {	
		//				isDotClicked=true;
						if(desplayValueS.contains(".")) {
							//somthing
						}else {
							desplayLabel.setText(desplayValueS+buttonValue);
						}
					}else {
						desplayLabel.setText(desplayLabel.getText()+buttonValue);
						if(desplayValueS.endsWith(".0")) {
							int desplayValueLength=desplayValueS.length()-1;
							
								char[] valueCharArray=new char[desplayValueLength];
								for(int i=0;i<desplayValueLength;i++) {
									valueCharArray[i]=desplayValueS.charAt(i);
								}
								String newValueS=String.valueOf(valueCharArray);
								desplayLabel.setText(newValueS+buttonValue);
		
						}else {
						}
					}
				}
				}else if(buttonType.equals("fun")){
					if(buttonValue.equals("hsry")) {
						//readArrHistory();
					}else if(buttonValue.equals("prv")) {
						prvArrHistory();
					}else if(buttonValue.equals("nxt")) {
						nxtArrHistory();
					}else {
						
					}
				}else {
					
				}
			}
		
			
			






	static void eraseResult() {
			String desplayLabelS=desplayLabel.getText();
			int desplayLabelLength=desplayLabelS.length()-1;
			if(desplayLabelLength<=0) {
				desplayLabel.setText("0");
			}else {
				char[] labelCharArray=new char[desplayLabelLength];
				for(int i=0;i<desplayLabelLength;i++) {
					labelCharArray[i]=desplayLabelS.charAt(i);
				}
				String newLabelS=String.valueOf(labelCharArray);
				desplayLabel.setText(newLabelS);
			}
	}

	static void equalResult() {
		if(tempClickedOperator=="") {
			num1S=desplayLabel.getText();
			addArrHistory(num1S);                                            System.out.println("History "+num1S);
			num1=Double.parseDouble(num1S);
			desplayResult(String.valueOf(num1));
		}else if(tempClickedOperator=="+"){
			desplayResult(String.valueOf(num1+currentValue()));
		}else if(tempClickedOperator=="-"){
			desplayResult(String.valueOf(num1-currentValue()));
		}else if(tempClickedOperator=="x"){
			desplayResult(String.valueOf(num1*currentValue()));
		}else if(tempClickedOperator=="/"){
			desplayResult(String.valueOf(num1/currentValue()));
		}else {
		}
		tempClickedOperator="";
//		addArrHistory("=");                                              System.out.println("History "+"=");
	}

	static void percentageResult() {
		if(tempClickedOperator=="") {
			num1S=desplayLabel.getText();
			addArrHistory(num1S);                                            System.out.println("History "+num1S);
			num1=Double.parseDouble(num1S);
			desplayResult(String.valueOf(num1/100));
		}else if(tempClickedOperator=="+"){
			desplayResult(String.valueOf(num1+(currentValue())/100));
		}else if(tempClickedOperator=="-"){
			desplayResult(String.valueOf(num1-(currentValue())/100));
		}else if(tempClickedOperator=="x"){
			desplayResult(String.valueOf(num1*(currentValue())/100));
		}else if(tempClickedOperator=="/"){
			desplayResult(String.valueOf((num1/currentValue())*100));
		}else {
		}
		tempClickedOperator="";
	}
	


	static void operatersResult(String buttonValueS) {
		operatorLabel.setText(buttonValueS);
		if(tempClickedOperator=="") {
			num1S=desplayLabel.getText();
			addArrHistory(num1S);                                            System.out.println("History "+num1S);
			num1=Double.parseDouble(num1S);
			desplayResult(String.valueOf(num1));
		}else if(tempClickedOperator=="+"){
			desplayResult(String.valueOf(num1+currentValue()));
		}else if(tempClickedOperator=="-"){
			desplayResult(String.valueOf(num1-currentValue()));
		}else if(tempClickedOperator=="x"){
			desplayResult(String.valueOf(num1*currentValue()));
		}else if(tempClickedOperator=="/"){
			desplayResult(String.valueOf(num1/currentValue()));
		}else {
		}
		num1=Double.parseDouble(desplayLabel.getText());
		addArrHistory(buttonValueS);                                            System.out.println("History "+buttonValueS);
		tempClickedOperator=buttonValueS;
		isNumberClicked=false;
	}



	static double currentValue() {
		double cValue=0;
		if(isNumberClicked==false) {
			cValue=0;
		}else {
			String cValueS=desplayLabel.getText();
			addArrHistory(cValueS);                                            System.out.println("History "+cValueS);
			cValue=Double.parseDouble(cValueS);
		}
		return cValue;
	}

	static void desplayResult(String resultS) {       /// int  or  double   and desplay
		double resultD=Double.parseDouble(resultS);  /// 9.8
		int resultI=(int)resultD;                     /// 9
		double d=(double)resultI;                     /// 9.0
		double rd=resultD-d;                         /// 0.8
		if(rd==0) {                                /// 0.8==0.0 ?$
			resultS=String.valueOf(resultI);
			desplayLabel.setText(resultS);    ///9.0   /// 9
		}else {                                       /// 0.8==0.0 ?x
			desplayLabel.setText(resultS);              /// 9.8
		}
		num1=resultD;
		resultSS=resultS;
		addArrHistory("=");                                            System.out.println("History "+"=");
		addArrHistory(resultS);                                            System.out.println("History "+resultS);
	}

	static void preSetArrHistory() {
		for(int i=0;i<30;i++) {
			 arrHistory[i]="dummy";
		}
	}
	
	static void addArrHistory(String addValeuS){
		if(arrLastPos==28) {
			for(int i=0;i<26;i++) {
				 arrHistory[i]=arrHistory[i+1];
				 arrLastPos=arrLastPos-1;
			}
		}else {
		}
		arrHistory[arrLastPos]=addValeuS; 
		arrLastPos=arrLastPos+1; 
	}

	static void readArrHistory() {
		String arrValueS="";
		for(int i=0;i<24;i++) {
			 String tempArrValueS=arrHistory[i];
			 if(tempArrValueS.equals("dummy")) {
				 //somthing
			 }else {
				 arrValueS=arrValueS+tempArrValueS;
			 }
		}
		desplayLabel.setText(arrValueS);
	}

	private static void prvArrHistory() {
		System.out.println(arrLastPos+" prv "+arrCurrentPos);
		if(arrCurrentPos<=arrLastPos) {
			System.out.println(arrLastPos+" prv "+arrCurrentPos);
				 String tempArrValueS=arrHistory[arrCurrentPos];
				 arrCurrentPos--;
				 if(tempArrValueS.equals("dummy")) {
					 //somthing
				 }else {
					 desplayLabel.setText(tempArrValueS);
				 }
		}else {
		
		}
	}

	private static void nxtArrHistory() {
		System.out.println(arrLastPos+" nxt "+arrCurrentPos);
		if(arrCurrentPos>=0) {
			 String tempArrValueS=arrHistory[arrCurrentPos];
			arrCurrentPos++;
			 if(tempArrValueS.equals("dummy")) {
				 //somthing
			 }else {
				 desplayLabel.setText(tempArrValueS);
			 }
		}else {
	
		}
	}

	static void fDotAdditional() {
		if(desplayLabel.getText().equals(".0")) {
			desplayLabel.setText("0.0");
		}else {
			for(int i=0;i<=1;i++) {
				if(desplayLabel.getText().equals("")) {
					desplayLabel.setText("0.0");
				}else {
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	///////////////////////////////////////////

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource()== historyButton) {
			desplayLabel.setFont(new Font("Arial", Font.PLAIN, 16));
			readArrHistory();
		}else {
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource()== historyButton) {
			desplayLabel.setText(resultSS);
			desplayLabel.setFont(new Font("Arial", Font.BOLD, 38));
		}else {
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	
	
	
	
	
	
	
	
}
