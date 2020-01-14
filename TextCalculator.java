import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;


/**
 * @author Ryan Gliszinski
 *  the following class contains our main method and will call upon the Calculator class,
 *  to instantiate objects and perform different methods
 *
 */
public class TextCalculator {		
/**
 * @param string - will return a string value
 * @return - returns 'true' is string value contains a double, and 'false' if it does NOT contain a double
 */
public static boolean testForDouble(String string) {
	try {
		Double.parseDouble(string);
		return true;
	}
	catch (Exception exception){
		return false;
	}
}
	//main method begins here!
	public static void main(String[] args) {
					
		//these will be the input values taken in as strings 
		String secondaryInput, initialInput, commandInput;
		//an initialized variable that will be used to convert input matching 'PI' to a double value of actual PI
		double PI = Math.PI; 
		//exit point variables to contain any converted values (PI, etc.) from our first and second scanners
		double initialInputConversion = 0;
		double secondaryInputConversion = 0;
		//three boolean loop values initialized; used to our do (while) loops to perform try catch
		boolean initialInputLoop = true; 
		boolean secondaryInputLoop = true;
		boolean commandInputLoop = true;

		
		//==========================================================
		//============== first scanner block ======================
		//==========================================================
		
			
	//our first input block that will run try catch and convert string values taken in from the scanner	
	do {
		//scanner one is initialized here		
		Scanner initialInputScanner = new Scanner(System.in);	
		//line that prompts the user to enter input
		System.out.print("Please enter your 1st number, numerator, base, or type [PI] to use a PI value: ");	
		//taking in value from console and storing via our first scanner
		initialInput = initialInputScanner.nextLine();
		//the following try block executes a 4-way test
		try { 
			//if string contains a double value, string is converted to double via our testForDouble method 	
			if (testForDouble(initialInput)) {
				initialInputConversion = Double.parseDouble(initialInput);
			}
			//if string contains the letters 'PI' then our exit-point variable is converted to PI
			else if (initialInput.equalsIgnoreCase("PI")) {
				initialInputConversion = PI;
			}
			//if the user types 'HELP' then they are prompt with some help suggestions
			else if (initialInput.equalsIgnoreCase("HELP")) {
				throw new Exception("Hit enter and try again!");
			}
			//if the user does not type a double value, PI, or HELP, they are prompted to enter in appropriate input. 
			else if (!initialInput.contains("PIHELP")) {
				throw new InputMismatchException("Invalid input. Type 'HELP' for help, or hit enter and try again!");
			}
			//if appropriate input is entered then the loop variable is converted to false so that the program may proceed
			initialInputLoop = false; 
					
		}
		//catch block to catch any incorrectly entered input
		catch (InputMismatchException inputMismatchException) {
			System.err.printf("%nException: %s%n", inputMismatchException);
			initialInputScanner.nextLine();//discard input, so user can try again
		}
		//catch block to prompt user with additional helpful tips
		catch (Exception HELP) {
			System.err.printf("%nHelp: %s%n", HELP);
			System.out.printf("The 1st value you enter will be your numerator or base value "
					+ "(if you are trying to raise to a power)."
					+ "\nIf you are trying to calculate the 'nth value', the 2nd number you enter will be your 'nth root' value.  %n%n");
			//discards input, so user can try again
			initialInputScanner.nextLine();
		}
	}
	while(initialInputLoop);
			
					
	//==========================================================
	//============== second scanner block ======================
	//==========================================================
	
	
	
	do {
		//scanner two is initialized here	
		Scanner secondaryInputScanner = new Scanner(System.in);
		//line that prompts the user to enter input
		System.out.print("\nPlease enter your 2nd number, denominator, exponent, or type [PI] to use a PI value: ");	
		//taking in value from console and storing via our second scanner
		secondaryInput = secondaryInputScanner.nextLine();
		
		try {			
			//if string contains a double value, string is converted to double via our testForDouble method 
			if(testForDouble(secondaryInput)) {
				secondaryInputConversion = Double.parseDouble(secondaryInput);
			}
			//if string contains the letters 'PI' then our exit-point variable is converted to PI
			else if (secondaryInput.equalsIgnoreCase("PI")) {
				secondaryInputConversion = PI; 
			}
			//if the user types 'HELP' then they are prompt with some help suggestions
			else if (secondaryInput.equalsIgnoreCase("HELP")) {
				throw new Exception("Hit enter and try again!");
			}
			//if the user does not type a double value, PI, or HELP, they are prompted to enter in appropriate input. 
			else if (!secondaryInput.contains("PIHELP")) {
				throw new InputMismatchException("Invalid input. Type 'HELP' for help, or hit enter and try again!");
			}
			//if appropriate input is entered then the loop variable is converted to false so that the program may proceed.
			secondaryInputLoop = false; 
		}	
		//catch block to catch any incorrectly entered input
		catch (InputMismatchException inputMismatchException) {			
			System.err.printf("%nException: %s%n", inputMismatchException);
			secondaryInputScanner.nextLine();//discard input, so user can try again				
		}
		//catch block to prompt user with additional helpful tips.
		catch (Exception HELP) {
			System.err.printf("%nHelp: %s%n", HELP);
			System.out.printf("The 2nd value you enter will be your denominator or exponent value "
					+ "(if you are trying to raise to a power)."
					+ "\nIf you are trying to calculate the 'nth value', this nuber will be your 'nth root' value.  %n%n");
			//discard input, so user can try again
			secondaryInputScanner.nextLine();
		}		
	} while(secondaryInputLoop);
	
	
	
	//==========================================================
	//============== third scanner block ======================
	//==========================================================
	
	
	//creating a calculator object instantiated from the calculator class - will carry out our methods and inherited methods
	Calculator calculator = new Calculator(initialInputConversion, secondaryInputConversion);
	//creating a divisor object instantiated from the division class which extends the calculator class; 
	//this will perform the division operations 
	Division divisor = new Division(initialInputConversion, secondaryInputConversion);
	
	
	do {	
		//scanner three is initialized here	
		Scanner commandInputScanner = new Scanner(System.in);	
		//prompts the user to enter an appropriate command
		System.out.print("\nPlease enter in the command character you would like to perform: \n" +
		         "\n[+] adiition\n[-] subtraction\n[/] division\n[*] mulitplication\n[%] modulus\n[^] raise to a power\n"
		         + "[x] calculate nth root\n");
		//taking in value and storing via our third scanner
		commandInput = commandInputScanner.nextLine();
		
		try {
				//if string value is '+' then the addition method is performed via our calculator object
				if(commandInput.equals("+")) {
					System.out.print("\n                          " + initialInputConversion + " " + "+ " + 
				secondaryInputConversion + " " + "=" + " " + calculator.addNumbers());
				}
				//if string value is '-' then the subtraction method is performed via our calculator object
				else if(commandInput.equals("-")) {
					System.out.print("\n                          " + initialInputConversion + " " + "- " + 
				secondaryInputConversion + " " + "=" + " " + calculator.subtractNumbers());
				}
				//if string value is '/' then the division method is performed via our calculator object
				//additional test contained to throw exception if our denominator is 0
				else if(commandInput.equals("/")) {
					if ((commandInput.equals("/") & (secondaryInputConversion == 0))) {
						
						throw new ArithmeticException("You cannot divide by zero! Hit enter and "
								+ "choose a new operator or restart the program!");
					}
					else {
						System.out.print("\n                          " + initialInputConversion + " " + "/ " + 
					secondaryInputConversion + " " + "=" + " " + divisor.divideNumbers());
					}					
				}
				//if string value is '*' then the multiplication method is performed via our calculator object
				else if(commandInput.equals("*")) {
					System.out.print("\n                          " + initialInputConversion + " " + "* " + 
				secondaryInputConversion + " " + "=" + " " + calculator.multiplyNumbers());
				}
				//if string value is '%' then the modulo method is performed via our calculator object
				else if(commandInput.equals("%")) {
					System.out.print("\n                          " + initialInputConversion + " " + "% " + 
				secondaryInputConversion + " " + "=" + " " + calculator.getModulo());
				}
				//if string value is '^' then the 'raise to power' method is performed via our calculator object
				else if(commandInput.equals("^")) {
					System.out.print("\n                          " + initialInputConversion + " " + "^ " + 
				secondaryInputConversion + " " + "=" + " " + calculator.raiseToPower());
				}
				//if string value is 'x' then the 'find nth root' method is performed via our calculator object
				//test contained to throw exception if user attempts to find 0th root value
				else if(commandInput.equals("x")) {
					if ((commandInput.equals("x") & (secondaryInputConversion == 0))) {
						throw new ArithmeticException("The 0th root is undefined! Hit enter and "
								+ "choose a new operator or restart the program!");
					}
					else {
						System.out.print("\n                          " + initialInputConversion + " " + "nth root " + 
					secondaryInputConversion + " " + "=" + " " + calculator.findNthRoot());
					}					
				}
				//if string value is 'HELP' then the user is prompted with one very simple help tip.
				else if (commandInput.equalsIgnoreCase("HELP")) {
					throw new Exception ("Hit enter and try again!");
				}
				//if no appropriate input is entered, then an error is thrown which requires the user to try again
				else {					
					throw new InputMismatchException("You didn't enter a valid operator. Hit enter and try again!");	
				}
				//if appropriate input is entered the program can perform its function and terminate
			commandInputLoop = false;
		}		
			//catch block to catch any incorrectly entered input
			catch (InputMismatchException inputMismatchException) {			
				System.err.printf("%nException: %s%n", inputMismatchException);
				//System.out.printf("Press enter to continue! %n%n");
				commandInputScanner.nextLine();//discard input, so user can try again			
			}		
			//catch block to catch any incorrectly attempted math operations
			catch(ArithmeticException arithmeticException) {				
				System.err.printf("%nException: %s%n", arithmeticException);
				//System.out.printf("Zero is an invalid denominator. Please try again.%n%n");
				commandInputScanner.nextLine();//discard input, so user can try again
			}	
			//catch block to offer a simple, helpful tip
			catch (Exception HELP) {
				System.err.printf("%nHelp: %s%n", HELP);
				System.out.printf("\nBe sure to choose an appropriate value from the list of operations!\n\n");
				commandInputScanner.nextLine();//discard input, so user can try again
			}
		} while (commandInputLoop);
	} 
}
			
