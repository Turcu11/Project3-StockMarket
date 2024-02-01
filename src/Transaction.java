import java.util.Date;

public class Transaction implements ITransaction{

    private String type;
    private IUser user;
    private IStock stock;
    private int quantity;
    private Date date;

    public Transaction(String type, IUser user, IStock stock, int quantity, Date date){
        this.type = type;
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
        this.date = date;
    }


    @Override
    public void getTransactionDetails() {
        System.out.println("Type: " + type + ", " + "User: " + user.getName() + ", " + "Stock: " + stock.getName() + ", " + "Quantity: " + quantity + ", " + "Date: " + date);
    }

    @Override
    public void setTransactionDetails(IUser user, IStock stock, int quantity, Date date) {
        this.user = user;
        this.stock = stock;
        this.quantity = quantity;
        this.date = date;
    }
}
