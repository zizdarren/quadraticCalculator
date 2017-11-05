package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

import calculatorUI.CtrlPanel;
import calculatorUI.DrawPanel;

public class CalculatorUI {

    JFrame frame;
    DrawPanel drawPanel;
    CtrlPanel ctrlPanel;
    CalculatorMain CM;

    public CalculatorUI(){
        init();
    }
    
    public CalculatorUI(CalculatorMain cm){
        this.CM = cm;
        init();
    }
    
    public void init(){
        frame = new JFrame();
        frame.setSize(800, 1000);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setLayout(new GridLayout(2, 1));
        
        drawPanel = new DrawPanel();
        drawPanel.setPreferredSize(new Dimension(800, 400));
        drawPanel.setBackground(Color.WHITE);
        
        ctrlPanel = new CtrlPanel(this);
        ctrlPanel.setPreferredSize(new Dimension(800, 400));
        ctrlPanel.setBackground(Color.GRAY);
        
        frame.add(drawPanel,0);
        frame.add(ctrlPanel,1);
        frame.pack();
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
    
    public DrawPanel getDrawPanel(){
        return this.drawPanel;
    }
    
    public CtrlPanel getCtrlPanel(){
        return this.ctrlPanel;
    }
    
    public CalculatorMain getCM(){
        return this.CM;
    }
    
}
