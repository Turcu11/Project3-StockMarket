import java.util.ArrayList;
import java.util.Date;

public class TransactionsHistory {

    ArrayList<ITransaction> transactions = new ArrayList<ITransaction>();

    public void seeAllTransactions(){
        System.out.println("Transactions history: ");
        transactions.forEach(ITransaction::getTransactionDetails);
    }

    public void addSellTransaction(IUser user, IStock stock, int quantity){
        ITransaction transaction = new Transaction("sell", user, stock, quantity, new Date());
        transactions.add(transaction);
    }

    public void addBuyTransaction(IUser user, IStock stock, int quantity){
        ITransaction transaction = new Transaction("buy", user, stock, quantity, new Date());
        transactions.add(transaction);
    }
}
