
package myfinance.gu.panel;

import myfinance.gu.MainButton;
import myfinance.gu.MainFrame;
import myfinance.settings.HandlerCode;
import myfinance.settings.Text;

/**
 *
 * @author Stepan Babaev
 */
public class StatisticsTypePanel extends AbstractPanel{
    
    private final String title;

    public StatisticsTypePanel(MainFrame frame, String title) {
        super(frame);
        this.title = Text.get(title);
        init();
    }

    @Override
    protected void init() {
        MainButton type = new MainButton(title, null, HandlerCode.TYPE);
        add(type);
    }
    
}
