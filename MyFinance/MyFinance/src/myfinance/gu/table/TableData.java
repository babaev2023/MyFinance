
package myfinance.gu.table;

import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import myfinance.gu.Refresh;
import myfinance.gu.handler.FunctionsHandler;
import myfinance.gu.menu.TablePopupMenu;
import myfinance.gu.table.model.MainTableModel;
import myfinance.gu.table.renderer.MainTableCellRenderer;
import myfinance.gu.table.renderer.TableHeaderIconRenderer;
import myfinance.settings.Style;
import myfinance.settings.Text;

/**
 *
 * @author Stepan Babaev
 */
abstract public class TableData extends JTable implements Refresh{
    
    
    private final FunctionsHandler handler;
    private final TablePopupMenu popup;
    private final String[] columns;
    private final ImageIcon[] icons;
    
    public TableData(MainTableModel model,FunctionsHandler handler , String[] columns, ImageIcon[] icons) {
        super(model);
        this.handler = handler;
        this.popup = new TablePopupMenu(handler);
        this.columns = columns;
        this.icons = icons;
        
        getTableHeader().setFont(Style.FONT_TABLE_HEADER);
        setFont(Style.FONT_TABLE);
        setRowHeight(getRowHeight() + Style.TABLE_ADD_ROW_HEIGHT);
        
        setAutoCreateRowSorter(true); //Сортировка
        setPreferredScrollableViewportSize(Style.DIMENSION_TABLE_SHOW_SIZE); //Фиксируем размер таблицы
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //Одиночное выделение
        
        addMouseListener(handler);
        addKeyListener(handler);
        
        
        //Добавили иконку в строках
        for (int i = 0; i < columns.length; i++) {
            getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
        }
        
        
        MainTableCellRenderer renderer = new MainTableCellRenderer();
        setDefaultRenderer(String.class, renderer);
        //Добавили popup
        setComponentPopupMenu(popup);
        
        
    }
    
    //Чтобы popup работал не на всей таблице -
    //@Override
    //public JPopupMenu getComponentPopupMenu() {
    //    Point p = getMousePosition();
    //    if (p != null) {
    //        int row = rowAtPoint(p);
    //        if (p != null && row !=-1) setRowSelectionInterval(row, row);
    //    
    //    }
    //    return super.getComponentPopupMenu();
    //}
    
    @Override
    public JPopupMenu getComponentPopupMenu() {
        Point p = getMousePosition();
        if (p != null) {
            int row = rowAtPoint(p);
            if (isRowSelected(row)) return super.getComponentPopupMenu();
            else return null;
        }
        return super.getComponentPopupMenu();
    }
    
    @Override
    public void refresh() {
        int selectedRow = getSelectedRow();
        ((MainTableModel) getModel()).refresh();
        for (int i = 0; i < columns.length; i++) {
            getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
        }
        if (selectedRow != -1 && selectedRow < getRowCount()) {
            setRowSelectionInterval(selectedRow, selectedRow);
            requestFocus();
        }
        init();
    }
    
    protected void init() {
        
    }

    public FunctionsHandler getFunctionHandler() {
        return handler;
    }

        
}
