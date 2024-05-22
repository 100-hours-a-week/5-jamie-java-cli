package subway.sandwich;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import subway.sandwich.ingredients.*;
import subway.sandwich.type.SandwichType;
import subway.order.Order;

public class SandwichMaker {

    private int count = 0;

    public Sandwich makeSandwich() {
        Sandwich sandwich = new Sandwich();

        SandwichType sandwichType = new SandwichType();
        sandwichType.selectSize();
        sandwich.setSize(sandwichType.getSize());
        sandwich.setType(sandwichType);

        Bread bread = new Bread();
        bread.selectBread();
        sandwich.setBread(bread.getName());

        Cheese cheese = new Cheese();
        cheese.selectCheese();
        sandwich.setCheese(cheese.getName());

        Topping topping = new Topping(sandwich.getSize());
        topping.selectTopping();
        if (!topping.getList().isEmpty()) {
            sandwich.setToppings(topping.getList());
            sandwich.setPrice(topping.getPrice());
        } else {
            sandwich.setToppings(new ArrayList<String>(List.of("선택안함")));
        }

        Vegetable vegetable = new Vegetable();
        vegetable.selectVegetables();
        sandwich.setVegetables(vegetable.getList());

        Sauce sauce = new Sauce();
        sauce.selectSauces();
        sandwich.setSauces(sauce.getList());

        Order.latch.countDown();
        return sandwich;
    }

    public void waitForSandwich() {
        System.out.println("=                                    =");
        System.out.println("=         샌드위치 제작을 시작합니다.       =");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder("=            샌드위치 제작중");
                sb.append(".".repeat(Math.max(0, count % 4)));
                sb.append("          =");
                System.out.print(sb.toString() + "\r");
                count++;

                if (count == 5) {
                    timer.cancel();
                    System.out.println("=            샌드위치 제작 완료!          =");
                }
            }
        }, 0, 1000);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
