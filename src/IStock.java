public interface IStock {
    public String  getType();
    public int getId();
    public String getSymbol();
    public String getName();
    public double getPrice();


    public void getStockDetails();
    public int getQuantity();

    public int setQuantity(int quantity);
    public void setPrice(double price);

}
