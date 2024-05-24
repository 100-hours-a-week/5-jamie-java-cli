package subway.extraMenu;

import java.util.ArrayList;
import java.util.List;

public class ExtraMenu {

    protected String name;
    protected List<String> toppings = new ArrayList<>();
    protected int price;

    public ExtraMenu() {
    }

    public void select(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public void select(String name, List<String> toppings, int price) {
        this.name = name;
        this.toppings = toppings;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public int getPrice() {
        return price;
    }
}
