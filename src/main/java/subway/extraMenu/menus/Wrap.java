package subway.extraMenu.menus;

import java.util.LinkedHashMap;
import java.util.Scanner;
import subway.extraMenu.ExtraMenu;

public class Wrap extends ExtraMenu {

    private int price;

    private static final LinkedHashMap<String, Integer> wraps = new LinkedHashMap<>() {{
        put("스테이크 & 치즈 아보카도 랩", 6600);
        put("쉬림프 에그마요 랩", 6200);
        put("치킨 베이컨 미니랩", 3900);
    }};

    public Wrap() {
    }

    @Override
    public void select(String name, int price) {
        super.select(name, price);
    }

    public void selectWrap() {
        int listSize = wraps.size();

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=       랩을 1개 선택해주세요. (1~" + listSize + ")     =");
        System.out.println("=                                    =");

        int i = 1;
        for (String wrap : wraps.keySet()) {
            String formattedString = String.format("%1$-25s",
                wrap + " (" + wraps.get(wrap) + "원)");
            System.out.println("=  " + i + ". " + formattedString + " =");
            i++;
        }
        System.out.println("======================================");

        int selectedNum;
        Scanner sc = new Scanner(System.in);
        do {
            String input = sc.nextLine();

            if (!input.matches("^[0-9]*$")) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=           숫자를 입력해주세요.          =");
                System.out.println("======================================");
            } else if (Integer.parseInt(input) > listSize || Integer.parseInt(input) < 1) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=     잘못된 입력입니다. 다시 입력해주세요.   =");
                System.out.println("======================================");
            } else {
                selectedNum = Integer.parseInt(input);
                break;
            }
        } while (true);

        String name = wraps.keySet().toArray()[selectedNum - 1].toString();
        price = wraps.get(name);

        select(name, price);
    }

    public int getPrice() {
        return price;
    }
}
