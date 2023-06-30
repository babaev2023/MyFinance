
package myfinance.saveload;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import myfinance.settings.Settings;
/**
 *
 * @author Stepan Babaev
 */
public class SaveLoad {
    
    
    
 public static void load(SaveData sd) {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            Wrapper wrapper = (Wrapper) um.unmarshal(Settings.getFileSave());
            sd.setAccounts(wrapper.getAccounts());
            sd.setArticles(wrapper.getArticles());
            sd.setTransactions(wrapper.getTransactions());
            sd.setTransfers(wrapper.getTransfers());
            sd.setCurrencies(wrapper.getCurrencies());
        } catch (JAXBException ex) {
            System.out.println("Файл не существует!");
        }
        
 }
    
    public static void save(SaveData sd) {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            Wrapper wrapper = new Wrapper();
            
            wrapper.setAccounts(sd.getAccounts());
            wrapper.setArticles(sd.getArticles());
            wrapper.setTransactions(sd.getTransactions());
            wrapper.setTransfers(sd.getTransfers());
            wrapper.setCurrencies(sd.getCurrencies());
            
            m.marshal(wrapper, Settings.getFileSave());
            
        } catch (JAXBException ex) {
           System.out.println("Файл не сохранен!");
        }
    }
    
}
