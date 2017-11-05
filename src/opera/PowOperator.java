package opera;

public class PowOperator extends Operator{

    public int priority() {
        return 3;
    }

    public Operand operate(double x1, double x2) {
        return new Operand(Math.pow(x1, x2));
    }
    
    public String toString(){
        return "^";
    }
}
