
package myfinance.gu;

import java.util.Date;
import java.util.Properties;
import javax.swing.JButton;
import myfinance.settings.Style;
import myfinance.settings.Text;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Stepan Babaev
 */
public class MainDatePicker {
    
    private final JDatePickerImpl datePicker;
    
    public MainDatePicker() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", Text.get("TODAY"));
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        
        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        model.setValue(new Date());
        
        JButton button = (JButton) datePicker.getComponent(1);
        button.setIcon(Style.ICON_DATE);
        button.setText("");
        
    }
    
    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }
    
    public void setValue(Date date) {
        ((UtilDateModel) datePicker.getModel()).setValue(date);
    }
    
    
}
