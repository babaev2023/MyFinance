
package myfinance.gu.table;

import javax.swing.ImageIcon;
import myfinance.gu.table.model.AccountTableModel;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public class AccountTableData extends TableData{
    
    private static final String[] columns = new String[]{"TITLE", "AMOUNT"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE, Style.ICON_AMOUNT};
    
    public AccountTableData(int COUNT_OVERVIEW_ROWS) {
        super(new AccountTableModel(columns), columns, icons);
    }
    
    
}
