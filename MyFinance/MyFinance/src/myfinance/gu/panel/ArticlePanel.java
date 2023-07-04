
package myfinance.gu.panel;

import myfinance.gu.MainFrame;
import myfinance.gu.table.ArticleTableData;
import myfinance.gu.toolbar.FunctionsToolBar;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public class ArticlePanel extends RightPanel {
    
    public ArticlePanel(MainFrame frame) {
        super(frame, new ArticleTableData(),
                "ARTICLES", Style.ICON_PANEL_ARTICLES,
                new FunctionsToolBar());
    }
    
}
