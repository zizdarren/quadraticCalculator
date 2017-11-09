package calculatorUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.table.TableModel;

import main.CalculatorUI;

public class DrawPanel extends JPanel{

    CalculatorUI CUI;
    final int distanceOffset = 20;
    double scale = 1;
    
    public DrawPanel(){
        super();
    }
    
    public DrawPanel(CalculatorUI cui){
        super();
        this.CUI = cui;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);;
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
        
        for(int i = -20; i<20; i++){       
            drawIndex(g, distanceOffset*i, 0);
            drawIndex(g, 0, distanceOffset*i);
            if(i%5==0 && i!=0){
                g.drawString(scale*i+"", this.getWidth()/2 -3 +distanceOffset*i, this.getHeight()/2 +15);
                g.drawString(-scale*i+"", this.getWidth()/2 +5 , this.getHeight()/2 +5 +distanceOffset*i);
            }
        }
        
        /////drawing area
        g.setColor(Color.RED);
        TableModel t = CUI.getCtrlPanel().getTableModel();
        Double Tx = 0.0, Ty = 0.0;
        for(int i=0; i<t.getRowCount(); i++){
            Double x = (Double) t.getValueAt(i, 0);
            Double y = (Double) t.getValueAt(i, 1);
            drawPoint(g, x, y);
            if(i>0){
                drawLine(g, Tx, Ty, x, y);
            }
            Tx = x;
            Ty = y;
        }
        
        
        /////
        
        
    }
    
    public void drawIndex(Graphics g, int x, int y){
        g.fillOval(this.getWidth()/2 -3 +x, this.getHeight()/2 -3 -y, 6, 6);
    }
    
    public void drawPoint(Graphics g, double x, double y){
        g.fillOval(this.getWidth()/2 -3 + (int)(x*distanceOffset/scale), this.getHeight()/2 -3 - (int)(y*distanceOffset/scale), 6, 6);
    }

    public void drawLine(Graphics g, double x1, double y1, double x2, double y2){
        g.drawLine(this.getWidth()/2 +(int)(x1*distanceOffset/scale), this.getHeight()/2 -(int)(y1*distanceOffset/scale), 
                this.getWidth()/2 +(int)(x2*distanceOffset/scale), this.getHeight()/2 -(int)(y2*distanceOffset/scale));
    }
    
    public void doubleScale(){
        this.scale *= 2;
    }
    
    public void halfScale(){
        this.scale /= 2;
    }
    
}
