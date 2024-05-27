package subway.management;

import java.util.List;
import java.util.Random;

public class Manager implements Runnable {
    private static final int MAX_OUT_OF_STOCK_ITEMS = 3;
    private int outOfStockItemsCount = 0;
    private final Inventory inventory;
    private final List<String> items;
    private final Random random = new Random();

    public Manager(Inventory inventory, List<String> items) {
        this.inventory = inventory;
        this.items = items;
    }

    @Override
    public void run() {
        while (outOfStockItemsCount < MAX_OUT_OF_STOCK_ITEMS) {
            try {
                Thread.sleep(5000 + random.nextInt(15000)); // 5~20초 랜덤 대기

                int index = random.nextInt(items.size()); // 재고가 소진된 항목을 랜덤으로 선택
                String item = items.get(index);

                if (inventory.isInStock(item)) { // 재고가 소진되지 않은 항목인 경우
                    inventory.setStockStatus(item);
                    outOfStockItemsCount++;
                    System.out.println();
                    System.out.println("❗️알립니다: " + item + " 재고가 소진되었습니다.");
                    System.out.println();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
