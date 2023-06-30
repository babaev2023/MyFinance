/*
 * Finance
 * 
 */
package myfinance;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import myfinance.exception.ModelException;
import myfinance.model.*;
import myfinance.saveload.SaveData;
import myfinance.settings.Settings;
import myfinance.settings.Text;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Stepan Babaev
 */
public class MyFinance {

    
    public static void main(String[] args) throws ModelException {
        init();
        //Проверяем что работает
        testModel();
        
        //System.out.println(Format.dateMonth(new Date()));
        //System.out.println(Text.get("PROGRAMM_NAME"));
        //System.out.println(Arrays.toString(Text.getMonths()));
    }
    
    
    private static void init() {
        Text.init();
        GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            Settings.init();
            
            boolean registerFont;
            registerFont = ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_ACARISANS_ITALIC ));
                    } catch (FontFormatException | IOException ex) {
            Logger.getLogger(MyFinance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void testModel() throws ModelException {
        Currency c1 = new Currency("Рубль", "RUB", 1, true, true);
        Currency c2 = new Currency("Доллар", "USD", 85, true, false);
        Currency c3 = new Currency("Евро", "EUR", 98, false, false);
        
        Account ac1 = new Account("Кошелёк", c1, 1000);
        Account ac2 = new Account("Карта Visa", c1, 0);
        Account ac3 = new Account("Депозит в банке (RUB)", c1, 100000);
        Account ac4 = new Account("Депозит в банке (USD)", c2, 0);
        
        Article article1 = new Article("Продукты");
        Article article2 = new Article("ЖКХ");
        Article article3 = new Article("Зарплата");
        Article article4 = new Article("Ресторан");
        Article article5 = new Article("Депозит");
        
        ArrayList<Currency> currencies = new ArrayList();
        currencies.add(c1);
        currencies.add(c2);
        currencies.add(c3);
        
        
        ArrayList<Account> accounts = new ArrayList();
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);
        accounts.add(ac4);
        
        ArrayList<Article> articles = new ArrayList();
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        
        ArrayList<Transaction> transactions = new ArrayList();
        transactions.add(new Transaction(ac2, article3, 30000));
        transactions.add(new Transaction(ac2, article1, -1500, "Продукты"));
        transactions.add(new Transaction(ac1, article2, -5500, "Кварплата"));
        transactions.add(new Transaction(ac1, article2, -4000, "Кредит"));
        transactions.add(new Transaction(ac3, article5, 1000));
        transactions.add(new Transaction(ac2, article3, 25000, new Date((new Date()).getTime() - (long) 86400000 * 30)));
        transactions.add(new Transaction(ac3, article5, 1000, new Date((new Date()).getTime() - (long) 86400000 * 30)));
        
        //Генерация транзакций
        for (int i = 0; i < 50; i++) {
            Article tempArticle;
            Account tempAccount;
            if (Math.random() < 0.5) tempArticle = article1;
            else tempArticle = article4;
            if (Math.random() < 0.5) tempAccount = ac1;
            else tempAccount = ac2;
            double tempAmount = Math.round(Math.random() * (-1000));
            Date tempDate = new Date((long) (new Date().getTime() - (long) 86400000 * 30 * Math.random()));
            transactions.add(new Transaction(tempAccount, tempArticle, tempAmount, tempDate));
        }
        
        ArrayList<Transfer> transfers = new ArrayList();
        transfers.add(new Transfer(ac2, ac1, 21000, 21000));
        transfers.add(new Transfer(ac2, ac3, 1000, 1000));
        transfers.add(new Transfer(ac2, ac4, 5950, 70));
        
        
        
        for (Account a : accounts) {
            a.setAmountFromTransactionsAndTransfers(transactions, transfers);
        }
        
        SaveData sd = SaveData.getInstance();
        sd.setArticles(articles);
        sd.setAccounts(accounts);
        sd.setCurrencies(currencies);
        sd.setTransactions(transactions);
        sd.setTransfers(transfers);
        sd.save();
        //sd.load();
        System.out.println(sd);
    }
    
}
