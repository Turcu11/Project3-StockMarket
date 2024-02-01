public class Main {
    public static void main(String[] args) {
        StockMarket stm = StockMarket.getInstance();

        stm.createAndAddStock("Tech", 1, "GLE", "Google", 100, 200);
        stm.createAndAddStock("Energy", 2, "ENL", "Enel", 80, 150);
        stm.createAndAddStock("Agriculture", 3, "NEH", "New Holland", 100, 200);
        stm.createAndAddStock("Tech", 4, "MET", "Facebook", 150, 800);

        stm.seeAllStocks();
        System.out.println("--------------------------------------------------");

        ClientUser user = new ClientUser(1, 10000, "John", "1234", false);
        User admin = new AdminUser(2, 1000, "Admin", "1234", true);

        stm.users.add(user);
        stm.users.add(admin);

        stm.userBuysStock(user, stm.avalibleStocks.get(1), 20);
        stm.increaseAllStocksPrice(10);
        stm.userBuysStock(user, stm.avalibleStocks.get(0), 20);
        stm.userSellsStock(user, user.getStockFromPortofolio(2), 10);

        System.out.println("--------------------------------------------------");
        stm.seeTransactionsHistory();
        System.out.println("--------------------------------------------------");

        user.seePortofolio();
    }
}