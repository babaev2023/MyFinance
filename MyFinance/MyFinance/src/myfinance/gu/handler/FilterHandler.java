
package myfinance.gu.handler;

import java.awt.event.ActionEvent;
import myfinance.gu.MainFrame;
import myfinance.saveload.SaveData;
import myfinance.settings.HandlerCode;

/**
 *
 * @author Stepan Babaev
 */
public class FilterHandler extends Handler{
    
    public FilterHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case HandlerCode.LEFT ->  {
                SaveData.getInstance().getFilter().prev();
            }
            case HandlerCode.RIGHT ->  {
                SaveData.getInstance().getFilter().next();
            }
            case HandlerCode.STEP -> {
                SaveData.getInstance().getFilter().nextPeriod();
            }
        }
        super.actionPerformed(ae);
    }
    
}
