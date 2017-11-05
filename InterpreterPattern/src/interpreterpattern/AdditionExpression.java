package interpreterpattern;

/**
 *
 * @author gaudyblanco
 */
public class AdditionExpression extends Expression {
    private Expression firstExpression;
    private Expression secondExpression;
    private String symbol;

    
    public AdditionExpression(Expression firstExpression, Expression secondExpression){
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
        symbol = "+";
    }
    
    @Override
    public int interpret(){
        return this.firstExpression.interpret() + this.secondExpression.interpret();
    }
    
    @Override
    public String toString(){
        return symbol;
    }
}
