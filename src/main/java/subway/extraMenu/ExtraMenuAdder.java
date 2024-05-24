package subway.extraMenu;

import java.util.Scanner;
import subway.extraMenu.menus.Others;
import subway.extraMenu.menus.Salad;
import subway.extraMenu.menus.Wrap;

public class ExtraMenuAdder {

    public ExtraMenu addExtraMenu() {
        ExtraMenu extraMenu = new ExtraMenu();

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=      추가 메뉴를 선택해주세요. (1~3)     =");
        System.out.println("=                                    =");
        System.out.println("=         1. 랩                      =");
        System.out.println("=         2. 샐러드                    =");
        System.out.println("=         3. 사이드 메뉴                =");
        System.out.println("======================================");

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        switch (input) {
            case "1" -> {
                Wrap wrap = new Wrap();
                wrap.selectWrap();
                extraMenu.setName(wrap.getName());
                extraMenu.setPrice(wrap.getPrice());
            }
            case "2" -> {
                Salad salad = new Salad();
                salad.selectSalad();

                extraMenu.setName(salad.getName());
                extraMenu.setPrice(salad.getPrice());
                extraMenu.setToppings(salad.getToppings());
            }
            case "3" -> {
                // TODO: 사이드 메뉴 추가
            }
            default -> {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=     잘못된 입력입니다. 다시 입력해주세요.   =");
                System.out.println("======================================");
            }
        }

        return extraMenu;
    }
}
