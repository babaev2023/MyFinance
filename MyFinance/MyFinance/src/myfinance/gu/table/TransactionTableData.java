
package myfinance.gu.table;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import myfinance.gu.table.model.MainTableModel;
import myfinance.gu.table.model.TransactionTableModel;
import myfinance.gu.table.renderer.MainTableCellRenderer;
import myfinance.settings.Style;
import myfinance.settings.Text;

/**
 *
 * @author Stepan Babaev
 */
public class TransactionTableData extends TableData{
    
    private static final String[] columns = new String[]{"DATE", "ACCOUNT", "ARTICLE", "AMOUNT", "NOTICE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_DATE, Style.ICON_ACCOUNT, Style.ICON_ARTICLE, Style.ICON_AMOUNT, Style.ICON_NOTICE};
    
    public TransactionTableData() {
        super(new TransactionTableModel(columns), columns, icons);
        init();
    }
    
    public TransactionTableData(int count) {
        super(new TransactionTableModel(columns, count), columns, icons);
        init();
    }
    
    //@Override
    //public void refresh() {
    //    super.refresh();
     //   init();
    //}
    
    @Override
    protected final void init() {
        getColumn(Text.get("AMOUNT")).setCellRenderer(new TableCellAmountRenderer());
    }
    
    private class TableCellAmountRenderer extends MainTableCellRenderer {
     //Меняем цвет транзакций - красный расход, зеленый доход   
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if ((value.toString()).contains("-")) renderer.setForeground(Style.COLOR_EXP);
            else renderer.setForeground(Style.COLOR_INCOME);
            return renderer;
        }
        
    }
    
}
