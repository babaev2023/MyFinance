
package myfinance.gu.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import myfinance.gu.MainFrame;

/**
 *
 * @author Stepan Babaev
 */
abstract public class Handler implements ActionListener{
    
    protected final MainFrame frame;
    
    public Handler(MainFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.refresh();
    }
    
}
