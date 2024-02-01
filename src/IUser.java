import java.util.ArrayList;

public interface IUser {
    public double getBalance();
    public void setBalance(double balance);

    boolean validateBuyStock(IStock stock, int quantity);

    String getName();

    ArrayList<IStock> getPortofolio();

    int getId();

    public Stock getStockFromPortofolio(int id);

    void addStockToPortofolio(IStock stock);
}
