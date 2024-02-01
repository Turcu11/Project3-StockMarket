public class StockFactory {
    public Stock createStock(String stockType, int id, String symbol, String name, double price, int  quantity){
        return switch (stockType) {
            case "Tech" ->  new TechStock(id, symbol, name, price, quantity);
            case "Realestate"  -> new RealestateStock(id, symbol, name, price, quantity);
            case "Agriculture" -> new AgricultureStock(id, symbol, name, price, quantity);
            case "Energy" -> new EnergyStock(id, symbol, name, price, quantity);
            default -> null;
        };
    }
}
