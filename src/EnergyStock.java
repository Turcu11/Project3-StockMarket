public class EnergyStock extends Stock{
    public EnergyStock(int id, String symbol, String name, double price, int quantity) {
        super(id, symbol, name, price, quantity);
    }

    @Override
    public int setQuantity(int quantity) {
        this.quantity = quantity;
        return  this.quantity;
    }
}
