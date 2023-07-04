
package myfinance.gu.table;

import javax.swing.ImageIcon;
import myfinance.gu.table.model.ArticleTableModel;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public class ArticleTableData extends TableData {
    
    private static final String[] columns = new String[]{"TITLE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE};
    
    public ArticleTableData() {
        super(new ArticleTableModel(columns),  columns, icons);
    }
    
}
