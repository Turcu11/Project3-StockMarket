import java.util.Date;

public interface ITransaction {
    public void getTransactionDetails();
    public void setTransactionDetails(IUser user, IStock stock, int quantity, Date date);

}
