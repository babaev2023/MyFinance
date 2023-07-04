
package myfinance.gu.handler;

import java.awt.event.ActionEvent;
import myfinance.gu.MainFrame;
import myfinance.gu.dialog.AboutDialog;
import myfinance.settings.HandlerCode;

/**
 *
 * @author Stepan Babaev
 */
public class MenuHelpHandler extends Handler{
    
    public MenuHelpHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case HandlerCode.MENU_HELP_ABOUT -> {
                new AboutDialog().setVisible(true);
            }
        }
        super.actionPerformed(ae);
    }
}
