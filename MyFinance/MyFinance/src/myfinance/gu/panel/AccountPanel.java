
package myfinance.gu.panel;

import myfinance.gu.MainFrame;
import myfinance.gu.dialog.AccountAddEditDialog;
import myfinance.gu.table.AccountTableData;
import myfinance.gu.toolbar.FunctionsToolBar;
import myfinance.settings.Settings;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public class AccountPanel extends RightPanel{
    
    public AccountPanel(MainFrame frame) {
        super(frame, new AccountTableData(Settings.COUNT_OVERVIEW_ROWS),"ACCOUNTS", Style.ICON_PANEL_ACCOUNTS, new FunctionsToolBar());
    }
}
