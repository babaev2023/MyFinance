
package myfinance.gu.panel;

import myfinance.gu.CurrencyAddEditDialog;
import myfinance.gu.MainFrame;
import myfinance.gu.handler.FunctionsHandler;
import myfinance.gu.table.CurrencyTableData;
import myfinance.gu.toolbar.FunctionsToolBar;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public class CurrencyPanel extends RightPanel{
    
    public CurrencyPanel(MainFrame frame) {
        super(frame, new CurrencyTableData(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))),
                "CURRENCIES", Style.ICON_PANEL_CURRENCIES,
                new FunctionsToolBar(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))));
    }
    
}
