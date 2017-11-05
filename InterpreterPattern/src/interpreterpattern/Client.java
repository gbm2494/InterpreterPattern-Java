package interpreterpattern;

import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author gaudyblanco
 */ 
public class Client {
    
    ArrayList<Expression> storage = new ArrayList<>();
    
    public int translate(String input, JTextArea txtLog){
        //Se evalua cada uno de los elementos de la expresión recibida
        for (String element : input.split(" ")) {
            //si el elemento no es un operador debe ser un número
            if (ParserUtil.isOperator(element) == false) {
                //se debe guardar el nuevo numero en el storage
                Expression numberExpression = new NumberExpression(element);
                storage.add(numberExpression);
                //se escribe en el log el paso intermedio
                txtLog.setText(txtLog.getText() + "\n" + "Numero añadido: " + numberExpression.interpret());
            //el elemento es un operador (+, -, / o *)
            } else  if (ParserUtil.isOperator(element)) {
                //ya se pueden tomar ambos valores a calcular con el operador 
                Expression secondExpression = storage.remove(storage.size() - 1);
                Expression firstExpression = storage.remove(storage.size() - 1);
                //se imprime la operación intermedia
                txtLog.setText(txtLog.getText() + "\n" + "Números a calcular: " + firstExpression.interpret() + " y " + secondExpression.interpret());
               
                //se obtiene el operador para realizar el calculo y el resultado
                Expression operator = ParserUtil.getExpressionObject(firstExpression, secondExpression, element);
                txtLog.setText(txtLog.getText() + "\n" + "Se va a aplicar el operador: " + operator);
                
                int result = operator.interpret();
                NumberExpression resultExpression = new NumberExpression(result);
                storage.add(resultExpression);
                txtLog.setText(txtLog.getText() + "\n" + "Resultado parcial: " + resultExpression.interpret());
            }
        }
      //al final de todos los calculos se retorna el resultado final
      int result = storage.remove(storage.size() - 1).interpret();
      return result;
    }
}