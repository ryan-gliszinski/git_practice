import java.lang.Math;
import java.util.InputMismatchException;

/**
 * @author Ryan Gliszinski
 * this class contains all methods performed in the main class
 * it also includes the division class methods which are extended to this class
 */
public class Calculator extends Object implements Calculable {

	/**
	 * two fields are initialized which are then passed into our numerous methods 
	 */
	private double initialInput;
	private double secondaryInput;
	
		/**
		 * @param initialInput - double type variable; is set via a setter to the corresponding field
		 * @param secondaryInput - double type variable; is set via a setter to the corresponding field
		 */
		public Calculator(double initialInput, double secondaryInput) {
			
			setInitialInput(initialInput);
			setSecondaryInput(secondaryInput);
						
		}

		/**
		 * @return - initialInput when called
		 */
		public double getInitialInput() {
			return initialInput;
		}

		/**
		 * @param initialInput - double type variable which is set with setter
		 *
		 */
		public void setInitialInput(double initialInput) {
			this.initialInput = initialInput;
		}

		/**
		 * @return - secondaryInput when called
		 */
		public double getSecondaryInput() {
			return secondaryInput;
		}

		/**
		 * @param secondaryInput - double type variable which is set with setter
		 */
		public void setSecondaryInput(double secondaryInput) {
			this.secondaryInput = secondaryInput;
		}
		
		/**
		 * @return value of initialInput added to our secondaryInput 
		 */
		@Override
		public double addNumbers() {
			
			double output = initialInput + secondaryInput;
			return output;
							
		}		
		
		/**
		 *@return value of initialInput subtracting secondaryInput
		 */
		@Override
		public double subtractNumbers() {
			
			double output = initialInput - secondaryInput;
			return output;
							
		}		
		
		/**
		 *@return value of initialInput divided by secondaryInput 
		 */
		@Override
		public double divideNumbers() {	
			double output = initialInput / secondaryInput;
			return output;
							
		}
		
		/**
		 *@return value of initialInput multiplied by secondaryInput
		 */
		@Override
		public double multiplyNumbers() {
			
			double output = initialInput * secondaryInput;
			return output;
							
		}		
		
		
		/**
		 *@return value of initialInput multiplied by secondaryInput as integer type
		 * conversion is made within the method
		 */
		@Override
		public int getModulo() {
			
			double output = (initialInput % secondaryInput);
			return  (int) output ; 
		}
		
		/**
		 *@return value of initialInput raised to secondaryInput
		 * method utilizes the Math class inherent to Java
		 */
		@Override
		public double raiseToPower() {
			
			double output = Math.pow(initialInput, secondaryInput);
			return output; 
		}
		
		/**
		 *@return value of initialInput 'nth rooted' to secondaryInput
		 * the following method contains an algorithm known as Newton's method
		 * Newton's method is used due to issues with double, BigDecimal and other data types inherent to Java
		 */
		@Override
		public double findNthRoot() {
			//an initial value between 1 and 9 is determined randomly
			double initialRandValue = Math.random() % 10; 
			//a variable is set which contains our degree of accuracy
			double accuracySetter = 0.000000001; 
			//a maximum value of data type 'double' is set to test against our degree of accuracy
			double maximumValueSet = Double.MAX_VALUE;
			//output value is initialized at 0 and will contain output determination of said method
			double output = 0.0; 
			
			//this while loop performs the algorithim as many times as needed to reach peak accuracy
			//the loop continues until our max value is no longer greater than our accuracy setter
			while (maximumValueSet > accuracySetter) 
	        { 	            
	            output = ((secondaryInput - 1.0) * initialRandValue + 
	            		initialInput / Math.pow(initialRandValue, secondaryInput - 1)) / secondaryInput; 	            
	            maximumValueSet = Math.abs(output - initialRandValue); 	            
	            initialRandValue = output; 
	        } 	      
			return output; 					
		}
}
