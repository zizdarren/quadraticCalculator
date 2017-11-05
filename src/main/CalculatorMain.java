package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calculatorUI.XYTableModel;

public class CalculatorMain implements ActionListener{
    
    CalculatorUI CUI;
    ExpressionPC EPC;
    
    public void init(){
        CUI = new CalculatorUI(this);
        EPC = new ExpressionPC();
    }
    
    public static void main(String [] args){
        
        CalculatorMain C = new CalculatorMain();
        C.init();
        
    }
    
    public void calculateAll(){
        String expressionS = CUI.getCtrlPanel().getYTF();
        String minS = CUI.getCtrlPanel().getMinTF();
        String maxS = CUI.getCtrlPanel().getMaxTF();
        String stepS = CUI.getCtrlPanel().getStepTF();
        
        int min = Integer.parseInt(minS);
        int max = Integer.parseInt(maxS);
        int step = Integer.parseInt(stepS);
        
        if(step<=0){
            step = 1;
            CUI.getCtrlPanel().setStepTF(Integer.toString(step));
        }
        
        Object [][] tableXY= new Object[ (max-min/step)+1][2];
        
        int temp = 0;
        for(int x= min; x<max; x += step){
            tableXY[temp][0] = x;
            tableXY[temp][1] = EPC.parseCalculate(expressionS, x);
            temp++;
        }
        tableXY[temp][0] = max;
        tableXY[temp][1] = EPC.parseCalculate(expressionS, max);
        
        CUI.getCtrlPanel().setTable(tableXY);
        
        CUI.getDrawPanel().repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        calculateAll();
    }
    
    
    
}
