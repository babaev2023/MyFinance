
package myfinance.model;

import java.util.Date;
import myfinance.exception.ModelException;

/**
 *
 * @author Stepan Babaev
 */
public class Transfer {
    
    private Account fromAccount;
    private Account toAccount;
    private double fromAmount;
    private double toAmount;
    private String notice;
    private Date date;
    
    public Transfer() {}

    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, String notice, Date date) throws ModelException {
        if (fromAccount==null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (toAccount==null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.notice = notice;
        this.date = date;
    }
    
    
    
}
