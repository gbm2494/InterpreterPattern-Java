package interpreterpattern;

/**
 *
 * @author gaudyblanco
 */
 
public class ParserUtil {
    public static boolean isOperator(String symbol) {
        return (symbol.equals("+") || symbol.equals("-") || symbol.equals("*") || symbol.equals("/"));
 
    }
    
    /*Método que permite obtener una instancia de algún tipo de objeto 
    que herede de Expression, basado en su símbolo
    */
    public static Expression getExpressionObject(Expression firstExpression,Expression secondExpression,String symbol){
        Expression object = null;
        
        switch(symbol){
            case "+":
                object = new AdditionExpression(firstExpression,secondExpression);
            break;
            
            case "-":
                object = new SubtractionExpression(firstExpression,secondExpression);
            break;
            
            case "/":
                object = new DivisionExpression(firstExpression,secondExpression);
            break;
            
            case "*":
                object = new MultiplicationExpression(firstExpression,secondExpression);
            break;
        }
       
        return object;
    }
}