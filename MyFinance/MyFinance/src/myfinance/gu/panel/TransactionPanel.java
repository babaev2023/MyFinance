
package myfinance.gu.panel;

import javax.swing.JPanel;
import myfinance.gu.MainFrame;
import myfinance.gu.table.TransactionTableData;
import myfinance.gu.toolbar.FunctionsToolBar;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public class TransactionPanel extends RightPanel {
    
     public TransactionPanel(MainFrame frame) {
        super(frame, new TransactionTableData(),
                "TRANSACTIONS", Style.ICON_PANEL_TRANSACTIONS,
                new JPanel[] {new FunctionsToolBar(),new FilterPanel(frame)});
    }
    
}
