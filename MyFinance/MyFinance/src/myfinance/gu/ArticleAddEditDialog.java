
package myfinance.gu;

import javax.swing.JTextField;
import myfinance.exception.ModelException;
import myfinance.gu.dialog.AddEditDialog;
import myfinance.model.Article;
import myfinance.model.Common;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public class ArticleAddEditDialog extends AddEditDialog{
    
    public ArticleAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        components.put("LABEL_TITLE", new JTextField());
        
        icons.put("LABEL_TITLE", Style.ICON_TITLE);
    }

    @Override
    protected void setValues() {
        Article article = (Article) c;
        values.put("LABEL_TITLE", article.getTitle());
    }

    @Override
    public Common getCommonFromForm() throws ModelException {
        String title = ((JTextField) components.get("LABEL_TITLE")).getText();
        return new Article(title);
    }
    
}
