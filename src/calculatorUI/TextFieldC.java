package calculatorUI;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class TextFieldC extends JTextField implements FocusListener{

    public TextFieldC(){
        super();
        this.addFocusListener(this);
    }
    
    public TextFieldC(String s){
        super(s);
        this.addFocusListener(this);
    }
    
    
    
    @Override
    public void focusGained(FocusEvent arg0) {
        this.selectAll();
        
    }

    @Override
    public void focusLost(FocusEvent arg0) {
        
    }

}
