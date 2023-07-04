
package myfinance.gu.table;

import javax.swing.ImageIcon;
import myfinance.gu.table.model.AccountTableModel;
import myfinance.gu.handler.FunctionsHandler;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public class AccountTableData extends TableData{
    
    private static final String[] columns = new String[]{"TITLE", "AMOUNT"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE, Style.ICON_AMOUNT};
    
    public AccountTableData(FunctionsHandler handler) {
        super(new AccountTableModel(columns), handler, columns, icons);
    }
    
    
}
