package subway.extraMenu.menus;

import java.util.List;
import subway.extraMenu.ExtraMenu;

public class SetMenu extends ExtraMenu {

    protected String name;
    protected String cookie;
    protected String drink;

    public SetMenu() {
    }

    @Override
    public void select(String name, List<String> list, int price) {
        super.select(name, list, price);
    }

    public void setCookie(String name) {
        this.cookie = name;
    }

    public void setDrink(String name) {
        this.drink = name;
    }

    public void selectSetMenus() {
        Cookie cookie = new Cookie();
        cookie.selectCookie();
        setCookie(cookie.getCookie());

        Drink drink = new Drink();
        drink.selectDrink();
        setDrink(drink.getDrink());

        this.name = "세트 메뉴";

        select(name, List.of(this.cookie, this.drink), 2500);
    }
}
