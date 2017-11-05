package calculatorUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.table.TableModel;

public class DrawPanel extends JPanel{

    TableModel T;
    int scale = 2;
    int distanceOffset = 10 * scale;
    
    public DrawPanel(){
        super();
    }
    
    public DrawPanel(TableModel t){
        super();
        this.T = t;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);;
        g.drawLine(this.getWidth()/2, 0, this.getWidth()/2, this.getHeight());
        
        for(int i = -20; i<20; i++){       
            drawPoint(g, distanceOffset*i, 0);
            drawPoint(g, 0, distanceOffset*i);
        }
        
        
    }
    
    public void drawPoint(Graphics g, int x, int y){
        g.fillOval(this.getWidth()/2 - 3 + x, this.getHeight()/2 - 3 + y, 6, 6);
    }

}
