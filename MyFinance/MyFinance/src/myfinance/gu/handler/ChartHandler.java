
package myfinance.gu.handler;

import java.awt.event.ActionEvent;
import myfinance.gu.MainFrame;
import myfinance.gu.panel.StatisticsPanel;
import myfinance.settings.HandlerCode;

/**
 *
 * @author Stepan Babaev
 */
public class ChartHandler extends Handler{
    
    public ChartHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case HandlerCode.TYPE -> {
                ((StatisticsPanel) frame.getRightPanel()).nextType();
            }
        }
        super.actionPerformed(ae);
    }
    
}
