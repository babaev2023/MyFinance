
package myfinance.gu.panel;

import javax.swing.JPanel;
import myfinance.gu.MainFrame;
import myfinance.gu.Refresh;

/**
 *
 * @author Stepan Babaev
 */
abstract public class AbstractPanel extends JPanel implements Refresh{
    
    protected final MainFrame frame;
    
    public AbstractPanel(MainFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void refresh() {
        removeAll();
        init();
    }

    abstract protected void init();
    
    
}
