package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
        
        int min =0, max =0, step = 1;
        
        //the try and catch blcok, try to see if min, max, and step are entered correctly
        try{
            min = Integer.parseInt(minS);
        }catch(NumberFormatException e){
            e.printStackTrace();
            CUI.getCtrlPanel().setMinTF(Integer.toString(0));
        }
        try{
            max = Integer.parseInt(maxS);
        }catch(NumberFormatException e){
            e.printStackTrace();
            CUI.getCtrlPanel().setMaxTF(Integer.toString(0));
        }
        try{
            step = Integer.parseInt(stepS);
        }catch(NumberFormatException e){
            e.printStackTrace();
            CUI.getCtrlPanel().setStepTF(Integer.toString(1));
        }
        
        if(step<=0){
            step = 1;
            CUI.getCtrlPanel().setStepTF(Integer.toString(step));
        }
        
        
        //create table data
        Object [][] tableXY= new Object[((max-min)/step)+1][2];
        
        //fill in table data
        int temp = 0;
        for(int x= min; x<max; x += step){
            tableXY[temp][0] = (double)x;
            tableXY[temp][1] = EPC.parseCalculate(expressionS, x);
            temp++;
        }
        
        tableXY[temp][0] = (double)max;
        tableXY[temp][1] = EPC.parseCalculate(expressionS, max);
        
        //put table data in to table
        CUI.getCtrlPanel().setTable(tableXY);
        
        CUI.getDrawPanel().repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton)e.getSource()).getName().equals("calculate")){
            calculateAll();
        }else if(((JButton)e.getSource()).getName().equals("zoomin")){
            this.CUI.getDrawPanel().doubleScale();
            this.CUI.getDrawPanel().repaint();
        }else if(((JButton)e.getSource()).getName().equals("zoomout")){
            this.CUI.getDrawPanel().halfScale();
            this.CUI.getDrawPanel().repaint();
        }
    }
    
}
