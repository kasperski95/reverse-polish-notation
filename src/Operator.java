import java.util.Stack;



public class Operator {	
	public static Boolean isOperator( String symbol ) {
		for ( int i = 0; i < operators.length; ++i ) {
			if ( operators[i].symbol.equals( symbol ) )
				return true;
		}
		return false;
	}
	
	
	public static Double execute( String symbol, Stack<Double> stack ) {
		for ( int i = 0; i < operators.length; ++i ) {
			if ( operators[i].symbol.equals( symbol ) ) {
				return operators[i].execute.call(stack);
			}
		}
		return 0.0; //TODO: excepetion
	}
	
	
	public static OperatorDefinition[] operators = {
		new OperatorDefinition( "^", 4, 2, false, (Stack<Double> stack) -> {
			Double tmp = stack.pop();
			return Math.pow(stack.pop(), tmp);
		}),
		new OperatorDefinition( "*", 3, 2, false, (Stack<Double> stack) -> {
			return stack.pop() * stack.pop();
		}),
		new OperatorDefinition( "/", 3, 2, false, (Stack<Double> stack) -> {
			Double tmp = stack.pop();
			return stack.pop() / tmp;
		}),
		new OperatorDefinition( "+", 2, 2, false, (Stack<Double> stack) -> {
			return stack.pop() + stack.pop();
		}),
		new OperatorDefinition( "-", 2, 2, false, (Stack<Double> stack) -> {
			Double tmp = stack.pop();
			return stack.pop() - tmp;
		}) 
	};
	
	
	
}



interface OperatorExecutable {
	Double call(Stack<Double> stack);
}



class OperatorDefinition {
	public String symbol;
	public Integer precedence;
	public Integer nOfArgs;
	public Boolean leftAssociativity;
	public OperatorExecutable execute;
	
	OperatorDefinition (
			String symbolToSet,
			Integer precedenceToSet,
			Integer nOfArgsToSet,
			Boolean leftAssociativityToSet,
			OperatorExecutable executeToSet
		) {
		symbol = symbolToSet;
		precedence = precedenceToSet;
		leftAssociativity = leftAssociativityToSet;
		nOfArgs = nOfArgsToSet;
		execute = executeToSet;
	}
}






