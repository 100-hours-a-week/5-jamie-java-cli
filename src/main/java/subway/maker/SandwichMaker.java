package subway.maker;

import java.util.List;
import subway.maker.ingredients.*;
import subway.maker.type.SandwichType;
import subway.order.Sandwich;

public class SandwichMaker {
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
        sandwich.setToppings(topping.getList());
        sandwich.setPrice(topping.getPrice());

        Vegetable vegetable = new Vegetable();
        vegetable.selectVegetables();
        sandwich.setVegetables(vegetable.getList());

        Sauce sauce = new Sauce();
        sauce.selectSauces();
        sandwich.setSauces(sauce.getList());


        System.out.println("== 샌드위치 주문 내역 (임시) == ");
        System.out.println("종류: " + sandwich.getType());
        System.out.println("사이즈: " + sandwich.getSize());
        System.out.println("빵: " + sandwich.getBread());
        System.out.println("치즈: " + sandwich.getCheese());
        System.out.println("토핑: " + sandwich.getToppings());
        System.out.println("야채: " + sandwich.getVegetables());
        System.out.println("소스: " + sandwich.getSauces());

        return sandwich;
    }


}
