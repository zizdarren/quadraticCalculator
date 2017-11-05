package opera;

import java.util.HashMap;

public abstract class Operator {
    
    public static HashMap<Character, Operator> operators = new HashMap<Character,Operator>();
    
    public static void init(){
        operators.put('+', new AddOperator());
        operators.put('-', new SubOperator());
        operators.put('*', new MulOperator());
        operators.put('/', new DivOperator());
        operators.put('^', new PowOperator());
    }

    public abstract int priority();
    
    public abstract Operand operate(double x1, double x2);
       
    public abstract String toString();
}
