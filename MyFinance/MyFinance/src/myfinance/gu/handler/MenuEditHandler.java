
package myfinance.gu.handler;

import java.awt.event.ActionEvent;
import myfinance.gu.MainFrame;
import myfinance.settings.HandlerCode;

/**
 *
 * @author Stepan Babaev
 */
public class MenuEditHandler extends Handler{
    
    public MenuEditHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        FunctionsHandler handler = frame.getRightPanel().getTableData().getFunctionHandler();
        switch (ae.getActionCommand()) {
            case HandlerCode.MENU_EDIT_ADD ->  {
                handler.add();
            }
            case HandlerCode.MENU_EDIT_EDIT ->  {
                handler.edit();
            }
            case HandlerCode.MENU_EDIT_DELETE -> {
                handler.delete();
            }
            
        }
        super.actionPerformed(ae);
    }
    
}
