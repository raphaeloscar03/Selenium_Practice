package SeleniumProject;

//import java.util.Scanner;

public class Calculator {
	
	float c;

	public float add(float a, float b) {
		
		c = a + b;
		return c;
	}
	
	public float sub(float a, float b) {
		
		c = a - b;
		return c;
	}
	
	public float mul(float a, float b) {
		
		c = a * b;
		return c;
	}
	
	public float div(float a, float b) {
		
		c = a/b;
		return c;
	}

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		//Scanner Scan;
		//Scan = new Scanner(System.in);
		//System.out.println("Please enter the addition variables");
		//float Val1 = Scan.nextFloat();
		//float Val2 = Scan.nextFloat();
		//System.out.println("Please enter the action......\n"
		//	+ "For Add Press '1'\n"
		//	+ "For Sub Press '2'\n"
		//	+ "For Mul Press '3'\n"
		//	+ "For Div Press '4'\n");
		//int calc = Scan.nextInt(); 
		//Scan.close();
		float Val1 = 25;
		float Val2 = 32;
		int calc = 3;
		
		switch(calc)
		{
		
		case 1:
			cal.add(Val1, Val2);
			break;
			
		case 2:
			cal.sub(Val1, Val2);
			break;
			
		case 3:
			cal.mul(Val1, Val2);
			break;
			
		case 4:
			cal.div(Val1, Val2);
			break;
		
		}
		
		System.out.println("The value is : " + cal.c);
	}
}
