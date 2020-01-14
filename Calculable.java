
/**
 * @author Ryan Gliszinski
 *  this is my interface which contains my methods and is required via Dr.Kieffer's instructions
 */
public interface Calculable {

	
	//multiplication method
	double multiplyNumbers();
	
	//modulo method
	//notice that this returns an integer data type as opposed to double
	int getModulo();

	//raise to Power method
	//performs raising to a power of input type
	//utilizes math class
	double raiseToPower();
	
	//subtraction method
	double subtractNumbers();
	
	//addition method
	double addNumbers();
	
	//division method
	double divideNumbers();
	
	//nth root method
	//utilizes Newton's method for highest levels of accuracy
	double findNthRoot();

	
}
