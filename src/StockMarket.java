import java.util.ArrayList;

public class StockMarket {

    private static volatile StockMarket instance;
    ArrayList<IStock> avalibleStocks = new ArrayList<IStock>();
    ArrayList<IUser> users = new ArrayList<IUser>();
    StockFactory SF = new StockFactory();

    TransactionsHistory transactionsHistory = new TransactionsHistory();

    private StockMarket(){

    }
    public static StockMarket getInstance(){
        StockMarket result = instance;
        if(result == null){
            synchronized (StockMarket.class){
                result = instance;
                if(result == null){
                    instance = result = new StockMarket();
                }
            }
        }
        return result;
    }

    public void increaseAllStocksPrice(double percentageIncrease) {
        for (IStock stock : avalibleStocks) {
            double newPrice = stock.getPrice() * (1 + percentageIncrease / 100);
            stock.setPrice(newPrice);
        }

        for (IUser user : users) {
            for (IStock stock : user.getPortofolio()) {
                double newPrice = stock.getPrice() * (1 + percentageIncrease / 100);
                stock.setPrice(newPrice);
            }
        }
    }

    public void createAndAddStock(String type, int id, String symbol, String name, double price, int quantity){
        Stock stock = SF.createStock(type, id, symbol, name, price, quantity);
        avalibleStocks.add(stock);
    }
    public void seeAllStocks(){
        avalibleStocks.forEach(IStock::getStockDetails);
    }
    public void userBuysStock(IUser user, IStock stock, int quantity) {
        for (IUser currentUser : users) {
            if (currentUser.getId() == user.getId()) {
                int totalCost = (int) (stock.getPrice() * quantity);
                if (user.getBalance() >= totalCost) {
                    user.setBalance(user.getBalance() - totalCost);
                    for (IStock currentStock : avalibleStocks) {
                        if (currentStock.getId() == stock.getId()) {
                            currentStock.setQuantity(currentStock.getQuantity() - quantity);
                            break;
                        }
                    }
                    if (user.validateBuyStock(stock, quantity)) {
                        IStock stockToAdd = SF.createStock(
                                stock.getType(),
                                stock.getId(),
                                stock.getSymbol(),
                                stock.getName(),
                                stock.getPrice(),
                                quantity
                        );
                        if(stockToAdd.getQuantity() > 0 && stockToAdd != null) {
                            user.addStockToPortofolio(stockToAdd);
                            transactionsHistory.addBuyTransaction(user, stock, quantity);
                        } else {
                            System.out.println("StockToAdd is null.");
                        }
                        System.out.println("Stock bought successfully.");
                    } else {
                        System.out.println("Not enough stocks in the market.");
                    }
                } else {
                    System.out.println("Not enough balance.");
                }
                return;
            }
        }
        System.out.println("User not found.");
    }

    public void userSellsStock(IUser user, IStock stock, int quantity){
        for(IUser currentUser : users){
            if(currentUser.getId() == user.getId()){
                for(IStock currentStock : avalibleStocks){
                    if(currentStock.getId() == stock.getId()){
                        currentStock.setQuantity(currentStock.getQuantity() + quantity);
                        break;
                    }
                }
                for(IStock currentStock : user.getPortofolio()){
                    if(currentStock.getId() == stock.getId()){
                        currentStock.setQuantity(currentStock.getQuantity() - quantity);
                        transactionsHistory.addSellTransaction(user, stock, quantity);
                        break;
                    }
                }
                user.setBalance(user.getBalance() + stock.getPrice() * quantity);
                return;
            }
        }
        System.out.println("User not found.");
    }

    public void seeTransactionsHistory(){
        transactionsHistory.seeAllTransactions();
    }

    public ArrayList<IStock> findStocksByType(String type){
        ArrayList<IStock> result = new ArrayList<IStock>();
        System.out.println("Stocks of type: " + type);
        for(IStock stock : avalibleStocks){
            if(stock.getType().equals(type)){
                stock.getStockDetails();
                result.add(stock);
            }
        }
        return result;
    }

    public ArrayList<IStock> findStocksByName(String name){
        ArrayList<IStock> result = new ArrayList<IStock>();
        System.out.println("Stocks with name: " + name);
        for(IStock stock : avalibleStocks){
            if(stock.getName().equals(name)){
                stock.getStockDetails();
                result.add(stock);
            }
        }
        return result;
    }
}
