
package myfinance.gu.panel;

import myfinance.gu.MainFrame;
import myfinance.gu.table.TransactionTableData;
import myfinance.settings.Settings;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public class OverviewPanel extends RightPanel {
    
    public OverviewPanel(MainFrame frame) {
        super(frame, new TransactionTableData(Settings.COUNT_OVERVIEW_ROWS),"LAST_TRANSACTIONS", Style.ICON_PANEL_OVERVIEW);
          
    }
    
}
