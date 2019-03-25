import java.util.Stack;

public class RpnCalculator {
	
	/**
	 * @param args: RPN expression to evaluate
	 */
	public static void main( String[] _exp ) {
		String[] exp = {"4", "2", "/", "2", "+", "2", "^"};
		
		Stack<Double> stack = new Stack<>();
		for ( int i = 0; i < exp.length; ++i ) {
			if ( Operator.isOperator( exp[i] ) ) {
				stack.push( Operator.execute( exp[i], stack ) );
			} else {
				stack.push( Double.valueOf( exp[i] ) );
			}
		}
		System.out.println( stack.pop() );
		
		
	}

}
