package subway.extraMenu.menus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import subway.extraMenu.ExtraMenu;

public class Salad extends ExtraMenu {

    private String name;
    protected List<String> toppings = new ArrayList<>();
    protected int price;

    private static final LinkedHashMap<String, Integer> salads = new LinkedHashMap<>() {{
        put("스파이시 쉬림프", 9700);
        put("스파이시 이탈리안", 8700);
        put("쉬림프", 9400);
        put("햄", 7600);
        put("써브웨이 클럽", 8900);
        put("로티세리 바비큐 치킨", 9100);
        put("로스트 치킨", 9100);
        put("K-바비큐", 9100);
        put("풀드포크 바비큐", 9000);
        put("참치", 7600);
        put("에그마요", 7300);
        put("베지", 6700);
        put("비엘티", 8400);
        put("이탈리안 비엠티", 8500);
        put("치킨 슬라이스", 8300);
        put("치킨데리야끼", 8800);
        put("스테이크 & 치즈", 9700);
        put("치킨 베이컨 아보카도", 9700);
    }};

    public Salad() {
    }

    @Override
    public void select(String name, List<String> toppings, int price) {
        super.select(name, toppings, price);
    }

    public void addTopping(List<String> toppings, int price) {
        this.toppings = toppings;
        this.price += price;
    }

    public void selectSalad() {
        int listSize = salads.size();

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=     샐러드를 1개 선택해주세요. (1~" + listSize + ")    =");
        System.out.println("=                                    =");

        int i = 1;
        for (String wrap : salads.keySet()) {
            String formattedString = String.format("%1$-26s",
                wrap + " (" + salads.get(wrap) + "원)");
            System.out.println("=  " + i + ". " + formattedString + "=");
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

        name = salads.keySet().toArray()[selectedNum - 1].toString();
        price = salads.get(name);

        askForTopping();
        select(name, toppings, price);
    }

    public void askForTopping() {
        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=       토핑을 추가하시겠습니까? (Y/N)     =");
        System.out.println("======================================");

        SaladTopping topping = new SaladTopping();

        Scanner sc = new Scanner(System.in);

        do {
            String input = sc.nextLine();

            if (input.equals("Y") || input.equals("y")) {
                topping.selectSaladTopping();

                addTopping(topping.getTopping(), topping.getTotalPrice());

                break;
            } else if (input.equals("N") || input.equals("n")) {
                toppings = (new ArrayList<String>(List.of("선택안함")));
                break;
            } else {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=     잘못된 입력입니다. 다시 입력해주세요.   =");
                System.out.println("======================================");
            }
        } while (true);
    }
}
