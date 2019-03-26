import java.util.Stack;



public class Operator {	
	public static OperatorDefinition getPropertiesOf( String symbol ) {
		for ( int i = 0; i < operators.length; ++i ) {
			if ( operators[i].symbol().equals( symbol ) )
				return operators[i];
		}
		return null;
	}
	
	
	public static Double execute( String symbol, Stack<Double> stack ) {
		for ( int i = 0; i < operators.length; ++i ) {
			if ( operators[i].symbol().equals( symbol ) ) {
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
		}),
		new OperatorDefinition( "(", -1, -1, false, null),
		new OperatorDefinition( ")", -1, -1, false, null)
	};
	
	
	
}



interface OperatorExecutable {
	Double call(Stack<Double> stack);
}



class OperatorDefinition {
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
	
	public OperatorExecutable execute;
	public String symbol() {return symbol;}
	public Integer precedence() {return precedence;}
	public Integer nOfArgs() {return nOfArgs;}
	public Boolean leftAssociativity() {return leftAssociativity;}
	
	//--------------------------------------------------------------
	
	private String symbol;
	private Integer precedence;
	private Integer nOfArgs;
	private Boolean leftAssociativity;
}






