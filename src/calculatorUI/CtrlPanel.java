package calculatorUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import main.CalculatorUI;

public class CtrlPanel extends JPanel{
    JLabel yLabel, minLabel, maxLabel, stepLabel;
    JButton Cbutton, Lbutton, Sbutton;
    TextFieldC yTF, minTF, maxTF, stepTF;
    JTable xyTable;
    JScrollPane tableSP;
    
    CalculatorUI CUI;
    
    public CtrlPanel(){
        init();
    }
    
    public CtrlPanel(CalculatorUI cui){
        CUI = cui;
        init();
    }
    
    public void init(){
        this.setLayout(new GridBagLayout());
        
        yLabel = new JLabel("y = ");
        yLabel.setFont(new Font("SANS_SERIF", Font.PLAIN, 24 ));
        GridBagConstraints yLabelC = new GridBagConstraints();
        yLabelC.gridx = 0;
        yLabelC.gridy = 0;
        yLabelC.gridwidth = 1;
        yLabelC.gridheight = 1;
        yLabelC.insets = new Insets(10,0,10,10);
        yLabelC.anchor = GridBagConstraints.LINE_START;
        this.add(yLabel, yLabelC);
        
        yTF = new TextFieldC("x^2 + x + 1");
        yTF.setPreferredSize(new Dimension(300, 40));
        yTF.setFont(new Font("SANS_SERIF", Font.PLAIN, 24 ));
        GridBagConstraints yTFC = new GridBagConstraints();
        yTFC.gridx = 1;
        yTFC.gridy = 0;
        yTFC.gridwidth = 2;
        yTFC.gridheight = 1;
        yTFC.insets = new Insets(10,10,10,10);
        this.add(yTF, yTFC);
        
        Cbutton = new JButton("calculate");
        GridBagConstraints CbuttonC = new GridBagConstraints();
        CbuttonC.gridx = 4;
        CbuttonC.gridy = 0;
        CbuttonC.gridwidth = 1;
        CbuttonC.gridheight = 1;
        CbuttonC.insets = new Insets(10,10,10,0);
        this.add(Cbutton, CbuttonC);
        
        minLabel = new JLabel("min = ");
        GridBagConstraints minLabelC = new GridBagConstraints();
        minLabelC.gridx = 0;
        minLabelC.gridy = 1;
        minLabelC.insets = new Insets(10,0,10,0);
        this.add(minLabel, minLabelC);
        
        minTF = new TextFieldC("-10");
        minTF.setPreferredSize(new Dimension(100, 40));
        minTF.setFont(new Font("SANS_SERIF", Font.PLAIN, 24 ));
        GridBagConstraints minTFC = new GridBagConstraints();
        minTFC.gridx = 1;
        minTFC.gridy = 1;
        minTFC.insets = new Insets(10,0,10,0);
        minTFC.anchor = GridBagConstraints.LINE_START;
        this.add(minTF, minTFC);
        
        maxLabel = new JLabel("max = ");
        GridBagConstraints maxLabelC = new GridBagConstraints();
        maxLabelC.gridx = 0;
        maxLabelC.gridy = 2;
        maxLabelC.insets = new Insets(10,0,10,0);
        this.add(maxLabel, maxLabelC);
        
        maxTF = new TextFieldC("10");
        maxTF.setPreferredSize(new Dimension(100, 40));
        maxTF.setFont(new Font("SANS_SERIF", Font.PLAIN, 24 ));
        GridBagConstraints maxTFC = new GridBagConstraints();
        maxTFC.gridx = 1;
        maxTFC.gridy = 2;
        maxTFC.insets = new Insets(10,0,10,0);
        maxTFC.anchor = GridBagConstraints.LINE_START;
        this.add(maxTF, maxTFC);
        
        stepLabel = new JLabel("step = ");
        GridBagConstraints stepLabelC = new GridBagConstraints();
        stepLabelC.gridx = 0;
        stepLabelC.gridy = 3;
        stepLabelC.insets = new Insets(10,0,10,0);
        this.add(stepLabel, stepLabelC);
        
        stepTF = new TextFieldC("1");
        stepTF.setPreferredSize(new Dimension(100, 40));
        stepTF.setFont(new Font("SANS_SERIF", Font.PLAIN, 24 ));
        GridBagConstraints stepTFC = new GridBagConstraints();
        stepTFC.gridx = 1;
        stepTFC.gridy = 3;
        stepTFC.insets = new Insets(10,0,10,0);
        stepTFC.anchor = GridBagConstraints.LINE_START;
        this.add(stepTF, stepTFC);
        
        xyTable = new JTable(new XYTableModel(0 ,0));
        xyTable.setFillsViewportHeight(true);
        xyTable.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        xyTable.getTableHeader().setReorderingAllowed(false);
        xyTable.getTableHeader().setResizingAllowed(false);
        
        tableSP = new JScrollPane(xyTable);
        tableSP.setPreferredSize(new Dimension(200, 200));
        GridBagConstraints tableSPC = new GridBagConstraints();
        tableSPC.gridx = 3;
        tableSPC.gridy = 1;
        tableSPC.gridwidth = 2;
        tableSPC.gridheight = 3;
        tableSPC.insets = new Insets(0, 0, 0, 0);
        this.add(tableSP, tableSPC);
        
        Lbutton = new JButton("zoom in");
        GridBagConstraints LbuttonC = new GridBagConstraints();
        LbuttonC.gridx = 1;
        LbuttonC.gridy = 4;
        LbuttonC.gridwidth = 1;
        LbuttonC.gridheight = 1;
        LbuttonC.insets = new Insets(0,0,0,0);
        this.add(Lbutton, LbuttonC);
        
        Sbutton = new JButton("zoom out");
        GridBagConstraints SbuttonC = new GridBagConstraints();
        SbuttonC.gridx = 2;
        SbuttonC.gridy = 4;
        SbuttonC.gridwidth = 1;
        SbuttonC.gridheight = 1;
        SbuttonC.insets = new Insets(0,0,0,0);
        this.add(Sbutton, SbuttonC);
        
        
        Cbutton.setName("calculate");
        Cbutton.addActionListener(CUI.getCM());
        
        Lbutton.setName("zoomin");
        Lbutton.addActionListener(CUI.getCM());
        
        Sbutton.setName("zoomout");
        Sbutton.addActionListener(CUI.getCM()); 
    }
    
    public String getYTF(){
        return yTF.getText();
    }
    
    public String getMinTF(){
        return minTF.getText();
    }
    
    public String getMaxTF(){
        return maxTF.getText();
    }
    
    public String getStepTF(){
        return stepTF.getText();
    }
    
    public void setMinTF(String s){
        minTF.setText(s);
    }
    
    public void setMaxTF(String s){
        maxTF.setText(s);
    }
    
    public void setStepTF(String t){
        stepTF.setText(t);
    }
    
    public void setTable(Object [][] t){
        xyTable.setModel(new XYTableModel(t));;
    }
    
    public TableModel getTableModel(){
        return xyTable.getModel();
    }
}
