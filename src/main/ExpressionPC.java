package main;

import java.util.Stack;

import opera.Operand;
import opera.Operator;

public class ExpressionPC{
    
    
    public ExpressionPC(){
        Operator.init();
    }
    
    
    public double parseCalculate(String expression, double x) {
        Stack<Operand> operandStack = new Stack<Operand>();
        Stack<Operator> operatorStack = new Stack<Operator>();
        
        try {
            parseExpression(expression, x, operandStack, operatorStack);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        double answer = 0;
        
        try {
            answer = calculateExpression(x, operandStack, operatorStack).getNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return answer;
       
    }
    
    
    public void parseExpression(String expression, double x, Stack<Operand> operandStack, Stack<Operator> operatorStack) throws Exception{
        
        int tempIndex = 0;
        int parenthesesFlag = 0;
        
        expression = expression.replaceAll("\\s+", "");
        
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i)=='('){  
                //if(i==0){ tempIndex = i + 1; }  //skip first char if first char is "("
                //else{ 
                    parenthesesFlag++; 
                //}
                //the comment here and the comment below end of this block is related (1)
                continue;
            }
            if(expression.charAt(i)==')'){   //  "&& i<expression.length()-1" is inside check statement
                parenthesesFlag--;
                continue;
            }
            
            //this block store the operator and the operand, which is in front the operator
            if(parenthesesFlag==0){
                if(expression.charAt(i)=='+'||expression.charAt(i)=='-'||
                expression.charAt(i)=='*'||expression.charAt(i)=='/'||
                expression.charAt(i)=='^'){
                    operatorStack.push(Operator.operators.get(expression.charAt(i)));
                    if(expression.substring(tempIndex, i).isEmpty()){
                        throw new Exception("Error1 : missing Operands or redundant operators!!!");
                    }else if(expression.substring(tempIndex, i).equalsIgnoreCase("x")){
                        operandStack.push(new Operand(x));
                    }else{
                        operandStack.push(new Operand(expression.substring(tempIndex, i)));
                    }
                    tempIndex = i + 1;
                }
            }
        }
        
        if(parenthesesFlag!=0){
            throw new Exception("Error2 : numbers of parentheses are not matched!!!");
        }
        
        //push last operand of the expression
        int offset = 0;
        
        /*   //the comment here and the comment top of block is related (2)
        if(expression.charAt(expression.length()-1)==')'){  //skip last char if last char is ')'
            offset = 1;
        }
        */
        
        if(expression.substring(tempIndex, expression.length()-offset).isEmpty()){
            throw new Exception("Error1 : missing an Operand!!!");
        }
        if(expression.substring(tempIndex, expression.length()-offset).equalsIgnoreCase("x")){ //check if last operand is X
            operandStack.push(new Operand(x));
        }else{
            operandStack.push(new Operand(expression.substring(tempIndex, expression.length()-offset)));
        }
        
    }
    
    
    public Operand calculateExpression(double x, Stack<Operand> operandStack, Stack<Operator> operatorStack){
        
        while(!operatorStack.isEmpty()){
            Operand opd2 = (Operand)operandStack.pop();
            Operator opr = (Operator)operatorStack.pop();
            Operand opd1 = (Operand)operandStack.pop();
            
            //if the term is expression, calculate the expression of opd2 and opd1
            if(!opd2.isNumber()){
                opd2 = new Operand(parseCalculate(opd2.getTerm(), x));
            }
            if(!opd1.isNumber()){
                opd1 = new Operand(parseCalculate(opd1.getTerm(), x));
            }
            
            if(operatorStack.isEmpty() || opr.priority()>operatorStack.peek().priority()){
                
                try {
                    operandStack.push(opr.operate(opd1.getNumber(), opd2.getNumber()));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }else{
                operandStack.push(opd1);
                
                try {
                    operandStack.push(opr.operate(calculateExpression(x, operandStack, operatorStack).getNumber(), opd2.getNumber()));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        }
        
        return operandStack.pop();
    }
    
}
