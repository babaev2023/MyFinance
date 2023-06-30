
package myfinance.model;

import myfinance.saveload.SaveData;

/**
 *
 * @author Stepan Babaev
 */
abstract public class Common {
    
   public Common() {}
    
    public String getValueForComboBox() {
        return null;
    }

    public void postAdd(SaveData aThis) {}
    public void postEdit(SaveData aThis) {}
    public void postRemove(SaveData aThis) {}
    
}
