package subway.extraMenu.menus;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class SaladTopping extends Salad {

    private final List<String> selectedToppings = new ArrayList<>();
    private int selectedToppingPrice;

    private static final LinkedHashMap<String, Integer> toppingTypes = new LinkedHashMap<>() {{
        put("미트", 3000);
        put("에그마요", 2000);
        put("베이컨", 1500);
        put("베이컨 비츠", 1500);
        put("치즈", 1400);
        put("에그 슬라이스", 1200);
        put("아보카도", 1500);
        put("오믈렛", 1800);
        put("페퍼로니", 1400);
    }};

    public SaladTopping() {
    }

    public void addTopping(String name, int price) {
        selectedToppings.add(name);
        selectedToppingPrice += price;
    }

    public void selectSaladTopping() {
        int listSize = toppingTypes.size();

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=      샐러드 토핑을 선택해주세요. (1~" + listSize + ")    =");
        System.out.println("=                                    =");
        System.out.println("=          2개 이상의 토핑 추가 시        =");
        System.out.println("=       숫자를 **띄어서** 입력해주세요.     =");
        System.out.println("=                                    =");

        int i = 1;
        for (String topping : toppingTypes.keySet()) {
            String formattedString = String.format("%1$-24s",
                topping + " (" + toppingTypes.get(topping) + "원)");
            System.out.println("=      " + i + ". " + formattedString + " =");
            i++;
        }
        System.out.println("======================================");

        List<Integer> selectedNumList = new ArrayList<>();
        do {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                break;
            } else if (!input.matches("^[0-9 ]*$")) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=           숫자를 입력해주세요.          =");
                System.out.println("======================================");
                continue;
            }

            // 입력값의 숫자들을 하나씩 리스트에 저장
            boolean isValid = true;

            for (String st : input.split(" ")) {
                if (Integer.parseInt(st) > toppingTypes.size()
                    || Integer.parseInt(st) < 1) {
                    isValid = false;
                    System.out.println("============== KAKAOWAY ==============");
                    System.out.println("=     잘못된 입력입니다. 다시 입력해주세요.   =");
                    System.out.println("======================================");
                    break;
                }
                selectedNumList.add(Integer.parseInt(st));
            }
            if (isValid) {
                break;
            }
        } while (true);

        if (!selectedNumList.isEmpty()) {
            for (int selectedNum : selectedNumList) {
                String selectedType = (String) toppingTypes.keySet().toArray()[selectedNum - 1];
                this.addTopping(selectedType, toppingTypes.get(selectedType));
            }
        }

    }

    public List<String> getTopping() {
        return selectedToppings;
    }

    public int getTotalPrice() {
        return selectedToppingPrice;
    }
}
