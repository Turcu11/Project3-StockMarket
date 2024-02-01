import java.util.Formatter;

public abstract class Stock implements IStock{

    private int id;
    private String symbol;
    private String name;
    public double price;
    public int quantity;

    public Stock(int id, String symbol, String name, double price, int  quantity){
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public void getStockDetails() {
        System.out.println("ID: "+id + ", " + "Name: " + name + ", " + "Symbol: " + symbol + ", " + "Price: " + price + ", " + "Quantity: " + quantity);
    }

    public String getName() {
//        System.out.println(name);
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
        return quantity;
    }

    public String getType(){
        String fullClassName = this.getClass().getName();
        String type = fullClassName.replace("Stock", "");
        return type;
    }

    public String getSymbol() {
        return symbol;
    }
}
