package subway.maker.ingredients;

import java.util.List;

public class BasicIngredient extends Ingredient {
    public BasicIngredient() {
    }

    @Override
    public void select(String type) {
        super.select(type);
    }

    @Override
    public void select(List<String> list) {
        super.select(list);
    }

    @Override
    public void select(String type, long price) {
        super.select(type, price);
    }
}
