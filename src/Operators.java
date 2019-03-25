public class Operators {	
	public static Boolean isOperator( String symbol ) {
		for ( int i = 0; i < operators.length; ++i ) {
			if ( operators[i].getSymbol().equals( symbol ) )
				return true;
		}
		return false;
	}
	
	//public static Operator getOperator()
	
	public static Double execute( Character symbol, Double op1, Double op2 ) {
		
		return 0.0;
	}
	
	private static Operator[] operators = {
		new Operator( '^', 4, false ),
		new Operator( '*', 3, false ),
		new Operator( '/', 3, false ),
		new Operator( '+', 2, false ),
		new Operator( '-', 2, false )
	};
}
