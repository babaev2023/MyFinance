//GUI Swing
package myfinance.gu;

import static java.awt.AWTEventMulticaster.add;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import myfinance.gu.dialog.AboutDialog;
import myfinance.gu.dialog.AccountAddEditDialog;
import myfinance.gu.dialog.ConfirmDialog;
import myfinance.gu.dialog.ErrorDialog;
import myfinance.gu.menu.MainMenu;
import myfinance.gu.panel.AccountPanel;
import myfinance.gu.panel.ArticlePanel;
import myfinance.gu.panel.CurrencyPanel;
import myfinance.gu.panel.LeftPanel;
import myfinance.gu.panel.OverviewPanel;
import myfinance.gu.panel.RightPanel;
import myfinance.gu.panel.StatisticsPanel;
import myfinance.gu.panel.TransactionPanel;
import myfinance.gu.panel.TransferPanel;
import myfinance.gu.toolbar.FunctionsToolBar;
import myfinance.gu.toolbar.MainToolBar;
import myfinance.settings.Style;
import myfinance.settings.Text;

/**
 *
 * @author Stepan Babaev 
 */
public class MainFrame extends JFrame implements Refresh {
    
    
    private final GridBagConstraints constraints;
    private final MainMenu mb;
    private final MainToolBar tb;
    private final LeftPanel leftPanel;
    private RightPanel rightPanel;
    
    public MainFrame() {
        super(Text.get("PROGRAMM_NAME"));
        
        //new CurrencyAddEditDialog(this).showDialog(); //Тестируем CurrencyAddEditDialog
        //new TransferAddEditDialog(this).showDialog(); //Тестируем TransferAddEditDialog
        //new TransactionAddEditDialog(this).showDialog(); //Тестируем TransactionAddEditDialog
        //new ArticleAddEditDialog(this).showDialog(); //Тестируем ArticleAddEditDialog
        
        //new AccountAddEditDialog(this).showDialog(); //Тестируем AccountAddEditDialog
        
        //new AboutDialog().setVisible(true); //Тестируем окно "О программе"
        
        //ErrorDialog.show(this, "TEST ERROR");
       // ConfirmDialog.show(this, "Вы уверены", "Тест подтверждения");
        
        //Test MainFileChooser
        //MainFileChooser fc = new MainFileChooser(this);
        //System.out.println(fc.save());
        
        
        setResizable(false);
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //закрытие программы при выходе 
        
        mb = new MainMenu(this);
       setJMenuBar(mb);
        
        
        setLayout(new GridBagLayout());
        
        // Верхнее меню
        constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        
        tb = new MainToolBar();
        add(tb,constraints);
        
        
        //add(new MainButton("TEST Button", null, "START TEST"));
        //Левая панель
        
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;
        
        leftPanel = new LeftPanel(this);
        add(leftPanel,constraints);
        
        //add(new FunctionsToolBar(),constraints); //Test ToolBar
        
        //Правая панель
        
        //add(new MainDatePicker().getDatePicker(),constraints); //Test DatePicker
        
        //setRightPanel(new ArticlePanel(this)); //Test ArticlePanel
        setRightPanel(new TransactionPanel(this)); 
        
        pack();
        setLocationRelativeTo(null);
        
        
        
    }
    
    
    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        mb.refresh();
        leftPanel.refresh();
        rightPanel.refresh();
        pack();
    }

    public MainMenu getMenu() {
       return mb;
    }

    private void setRightPanel(RightPanel panel) {
        if (rightPanel !=null) remove(rightPanel);
        constraints.gridy =1;
        constraints.gridx =1;
        rightPanel = panel;
        panel.setBorder(Style.BORDER_PANEL);
        add(rightPanel,constraints);
        pack();
        
    }
    
}
