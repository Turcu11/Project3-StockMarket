public class ClientUser extends User{


    public ClientUser(int id, double balance, String name, String password, boolean isAdmin) {
        super(id, balance, name, password, isAdmin);
    }

   public boolean validateByuStock(IStock stock, int quantity){
       return stock.getQuantity() >= quantity && this.getBalance() >= stock.getPrice() * quantity;
    }

    public void seePortofolio(){
        if (portofolio != null && portofolio.size() > 0) {
            portofolio.forEach(IStock::getStockDetails);
        } else {
            System.out.println("Portfolio is null.");
        }
    }
}
