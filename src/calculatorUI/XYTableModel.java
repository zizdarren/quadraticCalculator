package calculatorUI;

import javax.swing.table.AbstractTableModel;


public class XYTableModel extends AbstractTableModel{
    private String [] xyName = {"x", "y"};
    private Object [][] xyData;

    public XYTableModel(int x, int y){
        this.xyData = new Object[x][y];
    }
    
    public XYTableModel(Object [][] xy){
        this.xyData = xy;
    }
    
    public void setTableContent(Object [][] xy){
        this.xyData = xy;
    }
    
    @Override
    public int getColumnCount() {           
        return xyName.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return xyName[column];
    }

    @Override
    public int getRowCount() {
        return xyData.length;
    }

    @Override
    public Object getValueAt(int x, int y) {
        return xyData[x][y];
    }
    
    public void setValueAt(int x, int y, Object o){
        xyData[x][y] = o;
    }
    
}

