import java.util.ArrayList;

public abstract class User implements IUser{
    private int id;
    private double balance;
    private String name;
    private String password;
    private boolean isAdmin;
    public ArrayList<IStock> portofolio;

    public User(int id, double balance, String name, String password, boolean isAdmin) {
        this.id = id;
        this.balance = balance;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
        this.portofolio = new ArrayList<IStock>();
    }

    public boolean validateBuyStock(IStock stock, int quantity){
        if(stock.getQuantity() >= quantity && this.getBalance() >= stock.getPrice() * quantity){
            return true;
        }
        return false;
    }

    public ArrayList<IStock> getPortofolio() {
        return portofolio;
    }

    public String getName() {
        return name;
    }

    public void addStockToPortofolio(IStock stock){
        portofolio.add(stock);
    }

    @Override
    public int getId() {
        return id;
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Stock getStockFromPortofolio(int id){
        for(IStock stock : portofolio){
            if(stock.getId() == id){
                return (Stock) stock;
            }
        }
        return null;
    }

    public int setBalance(int balance) {
        this.balance = balance;
        return balance;
    }
}
