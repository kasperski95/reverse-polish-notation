import java.util.Arrays;



public class Test {
	private static Boolean test(String name, Boolean cond) {
		if (cond) {
			System.out.println( "[PASS] " + name );
		} else {
			System.out.println( "[FAIL] " + name );
			System.out.print  ( "       " );
		}
		return cond;
	}
	
	
	public static void main(String[] args) {
		{
			String[] infix = { "(", "2", "+", "3", ")", "*", "2", "^", "2", "-", "14", "/", "7" };
			String[] postfix = { "2", "3", "+", "2", "2", "^", "*", "14", "7", "/", "-" };
			if (! test( "Converter.infixToPostfix", Converter.infixToPostfix( infix ).equals( postfix ) ) ) {
				System.out.println( Arrays.toString( Converter.infixToPostfix( infix ) ) );
			}
		}{
			String[] postfix = { "2", "3", "+", "2", "2", "^", "*", "14", "7", "/", "-" };
			Double result = 18.0;
			if (! test( "Evaluator.evalPostfix", Evaluator.evalPostfix( postfix ).equals( result ) )) {
				System.out.println( Evaluator.evalPostfix( postfix ) );
			}
		}
		
		System.out.println( "Reached end of the test." );
	}

}
