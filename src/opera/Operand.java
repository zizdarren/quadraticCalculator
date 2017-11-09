package opera;

public class Operand {
    
    Double number;
    String term;
    
    public Operand(String s){
        if(s.charAt(0)=='(' && s.charAt(s.length()-1)==')'){
            s = s.substring(1, s.length()-1);
        }
        try{
            this.number = Double.parseDouble(s);
        }catch(NumberFormatException e){
            this.term = s;
        }
    }
    
    public Operand(double d){
        this.number = d;
    }
    
    public boolean isNumber(){
        if(term == null || term.isEmpty()){
            return true;
        }
        return false;
    }
    
    public double getNumber() throws Exception{
        if(number == null){
            throw new Exception("Error: number is null! Expression has error and cannot be parsed!");
        }
        return number.doubleValue();
    }
    
    public String getTerm(){
        return term;
    }
    
}
