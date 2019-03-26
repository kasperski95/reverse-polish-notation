import java.util.Stack;
import java.util.Vector;



public class Converter {
	public static String[] infixToPostfix( String[] exp ) {
		Vector<String> result = new Vector<>();
		Stack<String> stack = new Stack<>();
		
		for ( int i = 0; i < exp.length; ++i ) {
			if ( Operator.getPropertiesOf( exp[i] ) != null ) { // exp[i] is operator
				if ( exp[i].equals( ")" ) ) {
					// pop operators till left bracket
					while ( !stack.lastElement().equals( "(" ) ) {
						result.add( stack.pop() );
					}
					stack.pop(); // get rid of "("
				} else {
					// pop operators with higher or equal precedence and push the new operator on stack
					while ( !stack.empty() && Operator.getPropertiesOf( exp[i] ).precedence() <= Operator.getPropertiesOf( stack.lastElement() ).precedence() ) {
						result.add( stack.pop() );
					}
					stack.push( exp[i] );
				}
			} else { // exp[i] is operand
				result.add( exp[i] );
			}
		}
		
		// empty the stack
		while ( !stack.empty() ) {
			result.add( stack.pop() );
		}
		
		// convert to Vector<String> to String[]
		return result.toArray(new String[0]);
	}
}
