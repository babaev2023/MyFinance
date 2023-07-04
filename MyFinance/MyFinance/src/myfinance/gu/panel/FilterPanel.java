
package myfinance.gu.panel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import myfinance.gu.MainButton;
import myfinance.gu.MainFrame;
import myfinance.saveload.SaveData;
import myfinance.settings.Format;
import myfinance.settings.HandlerCode;
import myfinance.settings.Style;

/**
 *
 * @author Stepan Babaev
 */
public final class FilterPanel extends AbstractPanel{
    
    public FilterPanel(MainFrame frame) {
        super(frame);
        init();
    }
    
    @Override
    protected void init() {
        FlowLayout layout = new FlowLayout();
        layout.setVgap(0);
        setLayout(layout);
        MainButton left = new MainButton(Style.ICON_LEFT, null, HandlerCode.LEFT);
        MainButton step = new MainButton(Format.getTitleFilter(SaveData.getInstance().getFilter()), null, HandlerCode.STEP);
        MainButton right = new MainButton(Style.ICON_RIGHT, null, HandlerCode.RIGHT);
        
        setBorder(Style.BORDER_FILTER_PANEL);
        
        step.setFont(Style.FONT_BUTTON_FILTER);
        step.setPreferredSize(new Dimension(Style.WIDTH_FILTER_BUTTON, left.getPreferredSize().height));
        
        add(left);
        add(step);
        add(right);
    }
    
}
