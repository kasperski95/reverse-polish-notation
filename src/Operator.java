public class Operator {
	Operator (Character symbolToSet, Integer precedenceToSet, Boolean leftAssociativityToSet) {
		symbol = symbolToSet;
		precedence = precedenceToSet;
		leftAssociativity = leftAssociativityToSet;
	}
	
	public Character getSymbol() {return symbol;}
	public Integer getPrecedence() {return precedence;}
	public Boolean isLeftAssociativity() {return leftAssociativity;}
	
	private Character symbol;
	private Integer precedence;
	private Boolean leftAssociativity;
}