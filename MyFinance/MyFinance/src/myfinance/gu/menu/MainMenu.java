
package myfinance.gu.menu;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import myfinance.gu.EnableEditDelete;
import myfinance.gu.MainFrame;
import myfinance.gu.Refresh;
import myfinance.gu.handler.Handler;
import myfinance.gu.handler.MenuEditHandler;
import myfinance.gu.handler.MenuFileHandler;
import myfinance.gu.handler.MenuHelpHandler;
import myfinance.gu.handler.MenuViewHandler;
import myfinance.settings.HandlerCode;
import myfinance.settings.Settings;
import myfinance.settings.Style;
import myfinance.settings.Text;
import static myfinance.settings.Text.init;

/**
 *
 * @author Stepan Babaev
 */
public class MainMenu extends JMenuBar implements Refresh, EnableEditDelete{

    private JMenuItem menuEdit;
    private JMenuItem menuDelete;
    private final MainFrame frame;
    
    public MainMenu(MainFrame frame) {
        super();
        this.frame = frame;
        init();
    }
    
    
    private void init() {
        JMenu file = new JMenu(Text.get("MENU_FILE"));
        JMenu edit = new JMenu(Text.get("MENU_EDIT"));
        JMenu view = new JMenu(Text.get("MENU_VIEW"));
        //JMenu settings = new JMenu(Text.get("MENU_SETTINGS"));
        JMenu help = new JMenu(Text.get("MENU_HELP"));
        
        file.setIcon(Style.ICON_MENU_FILE);
        edit.setIcon(Style.ICON_MENU_EDIT);
        view.setIcon(Style.ICON_MENU_VIEW);
        //settings.setIcon(Style.ICON_MENU_SETTINGS);
        help.setIcon(Style.ICON_MENU_HELP);
        
        add(file);
        add(edit);
        add(view);
        //add(settings);
        add(help);
        
        MenuFileHandler fileHandler = new MenuFileHandler(frame);
        MenuEditHandler editHandler = new MenuEditHandler(frame);
        MenuViewHandler viewHandler = new MenuViewHandler(frame);
        MenuHelpHandler helpHandler = new MenuHelpHandler(frame);
        
        
        
        addMenuItem(file,fileHandler, Text.get("MENU_FILE_NEW"), Style.ICON_MENU_FILE_NEW, HandlerCode.MENU_FILE_NEW, KeyEvent.VK_N);
        addMenuItem(file,fileHandler, Text.get("MENU_FILE_OPEN"), Style.ICON_MENU_FILE_OPEN, HandlerCode.MENU_FILE_OPEN, KeyEvent.VK_O);
        addMenuItem(file,fileHandler, Text.get("MENU_FILE_SAVE"), Style.ICON_MENU_FILE_SAVE, HandlerCode.MENU_FILE_SAVE, KeyEvent.VK_S);
        addMenuItem(file,fileHandler, Text.get("MENU_FILE_UPDATE_CURRENCIES"), Style.ICON_MENU_FILE_UPDATE_CURRENCIES, HandlerCode.MENU_FILE_UPDATE_CURRENCIES);
        addMenuItem(file,fileHandler, Text.get("MENU_FILE_EXIT"), Style.ICON_MENU_FILE_EXIT, HandlerCode.MENU_FILE_EXIT);
        
        addMenuItem(edit,editHandler, Text.get("MENU_EDIT_ADD"), Style.ICON_MENU_EDIT_ADD, HandlerCode.MENU_EDIT_ADD);
        menuEdit = addMenuItem(edit,editHandler,  Text.get("MENU_EDIT_EDIT"), Style.ICON_MENU_EDIT_EDIT, HandlerCode.MENU_EDIT_EDIT);
        menuDelete = addMenuItem(edit,editHandler, Text.get("MENU_EDIT_DELETE"), Style.ICON_MENU_EDIT_DELETE, HandlerCode.MENU_EDIT_DELETE);
        menuEdit.setEnabled(false);
        menuDelete.setEnabled(false);
        
        
        addMenuItem(view,viewHandler,  Text.get("MENU_VIEW_OVERVIEW"), Style.ICON_MENU_VIEW_OVERVIEW, HandlerCode.MENU_VIEW_OVERVIEW);
        addMenuItem(view,viewHandler,  Text.get("MENU_VIEW_ACCOUNTS"), Style.ICON_MENU_VIEW_ACCOUNTS, HandlerCode.MENU_VIEW_ACCOUNTS);
        addMenuItem(view,viewHandler,  Text.get("MENU_VIEW_ARTICLES"), Style.ICON_MENU_VIEW_ARTICLES, HandlerCode.MENU_VIEW_ARTICLES);
        addMenuItem(view,viewHandler,  Text.get("MENU_VIEW_TRANSACTIONS"), Style.ICON_MENU_VIEW_TRANSACTIONS, HandlerCode.MENU_VIEW_TRANSACTIONS);
        addMenuItem(view,viewHandler,  Text.get("MENU_VIEW_TRANSFERS"), Style.ICON_MENU_VIEW_TRANSFERS, HandlerCode.MENU_VIEW_TRANSFERS);
        addMenuItem(view,viewHandler,  Text.get("MENU_VIEW_CURRENCIES"), Style.ICON_MENU_VIEW_CURRENCIES, HandlerCode.MENU_VIEW_CURRENCIES);
        addMenuItem(view,viewHandler,  Text.get("MENU_VIEW_STATISTICS"), Style.ICON_MENU_VIEW_STATISTICS, HandlerCode.MENU_VIEW_STATISTICS);
        
        
        addMenuItem(help,helpHandler,  Text.get("MENU_HELP_ABOUT"), Style.ICON_MENU_HELP_ABOUT, HandlerCode.MENU_HELP_ABOUT);
    }
    
    private JMenuItem addMenuItem(JMenu menu,Handler listener, String title, ImageIcon icon, String action, int key) {
        JMenuItem item = new JMenuItem(title);
        item.setIcon(icon);
        item.setActionCommand(action);
        item.addActionListener(listener);
        if (key != 0) {
            KeyStroke shortKey = KeyStroke.getKeyStroke(key, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
            item.setAccelerator(shortKey);
        }
        menu.add(item);
        return item;
    }
    
    private JMenuItem addMenuItem(JMenu menu,Handler listener, String title, ImageIcon icon, String action) {
        return addMenuItem(menu,listener, title, icon, action, 0);
    }
    
    
    @Override
    public void refresh() {
        removeAll();
        init();
    }

    @Override
    public void setEnableEditDelete(boolean enable) {
       menuEdit.setEnabled(enable);
       menuDelete.setEnabled(enable);
    }
    
}
