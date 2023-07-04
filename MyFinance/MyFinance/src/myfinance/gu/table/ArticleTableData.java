
package myfinance.gu.table;

import javax.swing.ImageIcon;
import myfinance.gu.handler.FunctionsHandler;
import myfinance.gu.table.model.ArticleTableModel;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public class ArticleTableData extends TableData {
    
    private static final String[] columns = new String[]{"TITLE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE};
    
     public ArticleTableData(FunctionsHandler handler) {
        super(new ArticleTableModel(columns), handler, columns, icons);
    }
    
}
