/**
 * @author Ryan Gliszinski
 * separate class which extends to our calculator class
 */
public class Division extends Calculator {
	
	/**
	 * two fields are initialized which are then passed into our division method
	 */
	private double numerator;
	private double denominator;
	
		/**
		 * constructor method 
		 * @param numerator - is set to our corresponding field variable
		 * @param denominator - is set to our corresponding field variable
		 */
		public Division(double numerator, double denominator) {
			
			super(numerator, denominator);
			setNumerator(numerator);
			setDenominator(denominator);
						
		}

		/**
		 * @return - numerator when called
		 */
		public double getNumerator() {
			return numerator;
		}

		/**
		 * @param numerator - double type variable which is set with setter
		 */
		public void setNumerator(double numerator) {
			this.numerator = numerator;
		}

		/**
		 * @return - denominator when called
		 */
		public double getDenominator() {
			return denominator;
		}

		/**
		 * @param numerator - double type variable which is set with setter
		 */
		public void setDenominator(double denominator) {
			this.denominator = denominator;
		}
		
		/**
		 * @return - value of numerator divided by denominator
		 */
		@Override
		public double divideNumbers() {
			
			double output = numerator / denominator;
			return output;
							
		}	
}
