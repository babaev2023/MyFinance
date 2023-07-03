
package myfinance.gu.dialog;

import javax.swing.JOptionPane;
import myfinance.gu.MainFrame;
import myfinance.settings.Text;

/**
 *
 * @author Stepan Babaev
 */
public class ConfirmDialog {
    
     public static int show(MainFrame frame, String text, String title) {
        String[] options = {Text.get("YES"), Text.get("NO")};
        int result = JOptionPane.showOptionDialog(frame, Text.get(text), Text.get(title), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        return result;
    }
    
}
