
package myfinance.gu.dialog;

import javax.swing.JOptionPane;
import myfinance.gu.MainFrame;
import myfinance.settings.Text;

/**
 *
 * @author Stepan Babaev
 */
public class ErrorDialog {
    
    public static void show(MainFrame frame, String text) {
        JOptionPane.showMessageDialog(frame, text, Text.get("ERROR"), JOptionPane.ERROR_MESSAGE);
    }
    
}
