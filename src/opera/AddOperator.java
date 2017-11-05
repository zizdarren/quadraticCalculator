package opera;

public class AddOperator extends Operator{


    public int priority() {
        return 1;
    }

    public Operand operate(double x1, double x2) {
        return new Operand(x1 + x2);
    }
    
    public String toString(){
        return "+";
    }

}
