//GUI Swing
package myfinance.gu;

import static java.awt.AWTEventMulticaster.add;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import myfinance.gu.menu.MainMenu;
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
    
    public MainFrame() {
        super(Text.get("PROGRAMM_NAME"));
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
        
        //add(new FunctionsToolBar(),constraints); //Test ToolBar
        
        //Правая панель
        
        //add(new MainDatePicker().getDatePicker(),constraints); //Test DatePicker
        
        pack();
        setLocationRelativeTo(null);
        
        
        
    }
    
    
    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        mb.refresh();
        pack();
    }
    
}
