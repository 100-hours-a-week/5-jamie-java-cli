package subway.management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private final Map<String, Boolean> stockStatus = new HashMap<>();

    public Inventory() {
        stockStatus.put("랩", true);
        stockStatus.put("샐러드", true);
        stockStatus.put("세트메뉴", true);
    }

    public synchronized void setStockStatus(String name) {
        stockStatus.put(name, false);
    }

    public synchronized boolean isInStock(String name) {
        return stockStatus.getOrDefault(name, true);
    }

    public List<String> getItems() {
        return List.copyOf(stockStatus.keySet());
    }
}
