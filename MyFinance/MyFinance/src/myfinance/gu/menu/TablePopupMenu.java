
package myfinance.gu.menu;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import myfinance.gu.Refresh;
import myfinance.settings.HandlerCode;
import myfinance.settings.Style;
import myfinance.settings.Text;

/**
 *
 * @author Stepan Babaev
 */
public class TablePopupMenu extends JPopupMenu implements Refresh {
    
   
    
    public TablePopupMenu() {
        super();
        
        init();
    }
    
    @Override
    public void refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void init() {
        JMenuItem editItem = new JMenuItem(Text.get("EDIT"));
        JMenuItem deleteItem = new JMenuItem(Text.get("DELETE"));
        
        editItem.setActionCommand(HandlerCode.EDIT);
        deleteItem.setActionCommand(HandlerCode.DELETE);
        
        //
        
        editItem.setIcon(Style.ICON_MENU_POPUP_EDIT);
        deleteItem.setIcon(Style.ICON_MENU_POPUP_DELETE);
        
        add(editItem);
        add(deleteItem);
    }
    
}
