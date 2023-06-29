/*
 * Finance
 * 
 */
package myfinance;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import myfinance.settings.Text;

/**
 *
 * @author Stepan Babaev
 */
public class MyFinance {

    
    public static void main(String[] args) {
        init();
        //Проверяем что работает
        System.out.println(Text.get("PROGRAMM_NAME"));
        System.out.println(Arrays.toString(Text.getMonths()));
    }
    
    
    private static void init() {
        Text.init();
        GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            boolean registerFont;
            registerFont = ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/AcariSans-Italic.ttf") ));
                    } catch (FontFormatException | IOException ex) {
            Logger.getLogger(MyFinance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
