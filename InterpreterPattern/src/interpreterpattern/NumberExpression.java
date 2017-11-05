package interpreterpattern;

/**
 *
 * @author gaudyblanco
 */
public class NumberExpression extends Expression{
    private int number;
    
    public NumberExpression(int number){
        this.number=number;
    }
    
    public NumberExpression(String number){
        this.number = Integer.parseInt(number);
    }
    
    @Override
    public int interpret(){
        return this.number;
    }
}