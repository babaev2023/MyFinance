
package myfinance.gu.panel;

import javax.swing.JPanel;
import myfinance.gu.MainFrame;
import myfinance.gu.table.TransferTableData;
import myfinance.gu.toolbar.FunctionsToolBar;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public class TransferPanel extends RightPanel{
    
    public TransferPanel(MainFrame frame) {
        super(frame, new TransferTableData(),
                "TRANSFERS", Style.ICON_PANEL_TRANSFERS,
                new JPanel[] {new FunctionsToolBar(),new FilterPanel(frame)});
    }
    
}
