import java.util.Stack;

public class RpnCalculator {
	
	/**
	 * @param args: RPN expression to evaluate
	 */
	public static void main( String[] exp ) {
		Stack<Double> stack = new Stack<>();
		for ( int i = 0; i < exp.length; ++i ) {
			
			if ( Operators.isOperator( exp[i] ) ) {
				stack.push( Operators.execute( exp[i], stack.pop(), stack.pop() ) );
			} else {
				
				stack.push( Double.valueOf( exp[i] ) );
			}
			
		}
		
		
	}

}
