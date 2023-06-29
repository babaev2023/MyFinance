
package myfinance.model;

import java.util.Objects;
import myfinance.exception.ModelException;

/**
 *
 * @author Stepan Babaev
 */
public class Account extends Common{
    
    private String title;
    private Currency currency;
    private double startAmount;
    private double amount;
    
    public Account() {}

    public Account(String title, Currency currency, double startAmount) throws ModelException {
        if (title.length()==0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (currency==null)throw new ModelException(ModelException.CURRENCY_EMPTY);
        this.title = title;
        this.currency = currency;
        this.startAmount = startAmount;
        
    }
    
    public double getAmount() {
        return amount;
    
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        return Objects.equals(this.title, other.title);
    }
    
    @Override
     public String getValueForComboBox() {
         return title;
     }
    
     public void setAmountFromTransactionsAndTransfers() {
     
     
     }
     
     
}
