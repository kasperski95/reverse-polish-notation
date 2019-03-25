import java.util.Stack;

public class Evaluator {
	
	public static Double evalInfix( String[] exp ) {
		return evalPostfix( Converter.infixToPostfix( exp ) );
	}
	
	
	/**
	 * @param exp: postfix (RPN) expression to evaluate
	 */
	public static Double evalPostfix( String[] exp ) {		
		Stack<Double> stack = new Stack<>();
		for ( int i = 0; i < exp.length; ++i ) {
			if ( Operator.isOperator( exp[i] ) ) {
				stack.push( Operator.execute( exp[i], stack ) );
			} else {
				stack.push( Double.valueOf( exp[i] ) );
			}
		}
		return stack.pop();
	}
}
