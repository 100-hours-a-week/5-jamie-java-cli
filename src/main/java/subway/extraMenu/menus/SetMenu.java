package subway.extraMenu.menus;

import java.util.Scanner;
import subway.extraMenu.ExtraMenu;

public class Others extends ExtraMenu {

    public Others() {

    }

    @Override
    public void select(String name, int price) {
        super.select(name, price);
    }

    public void selectDetails(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void selectOthers() {
        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=     사이드 메뉴를 선택해주세요. (1~3)     =");
        System.out.println("=                                    =");
        System.out.println("=         1. 쿠키                     =");
        System.out.println("=         2. 음료수                    =");
        System.out.println("=         3. 기타                     =");
        System.out.println("======================================");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        label:
        do {
            switch (input) {
                case "1":
                    Cookie cookie = new Cookie();
                    cookie.selectCookie();
                    break label;
                case "2":
                    select("음료수", 2000);
                    break label;
                case "3":
                    select("기타", 1000);
                    break label;
                default:
                    System.out.println("============== KAKAOWAY ==============");
                    System.out.println("=     잘못된 입력입니다. 다시 입력해주세요.   =");
                    System.out.println("======================================");
                    input = sc.nextLine();
                    break;
            }
        } while (true);
    }
}
