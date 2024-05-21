package subway.sandwich.ingredients;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {
    protected String type;
    protected List<String> list;
    protected List<String> toppings = new ArrayList<>();
    protected long price;

    public Ingredient() {
    }

    public void select(String type) { // 빵, 치즈 선택
        this.type = type;
    }
    public void select(List<String> list) { // 야채, 소스 선택
        this.list = list;
    }
    public void select(String type, long price) { // 토핑 선택)
        this.toppings.add(type);
        this.price += price;
    }

}
