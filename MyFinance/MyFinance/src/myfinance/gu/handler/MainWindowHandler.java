
package myfinance.gu.handler;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import myfinance.gu.MainFrame;
import myfinance.gu.dialog.ConfirmDialog;
import myfinance.saveload.SaveData;

/**
 *
 * @author Stepan Babaev
 */
public class MainWindowHandler extends WindowAdapter{
    //Чтобы по крестику сохранять данные ) 
    @Override
    public void windowClosing(WindowEvent we) {
        if (SaveData.getInstance().isSaved()) System.exit(0);
        else {
            int result = ConfirmDialog.show((MainFrame) we.getWindow(), "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");
            if (result == JOptionPane.YES_OPTION) System.exit(0);
        }
    }
    
}
