package subway.sandwich.ingredients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Topping extends Ingredient {

    private String type;
    private long price;
    private final String size;

    static LinkedHashMap<String, Integer> toppings15cm = new LinkedHashMap<>() {{
        put("미트", 3000);
        put("에그마요", 2000);
        put("베이컨", 1500);
        put("치즈", 1400);
        put("에그 슬라이스", 1200);
        put("아보카도", 1500);
        put("오믈렛", 1800);
        put("페퍼로니", 1400);
    }};
    static LinkedHashMap<String, Integer> toppings30cm = new LinkedHashMap<>() {{
        put("미트", 6000);
        put("에그마요", 4000);
        put("베이컨", 3000);
        put("치즈", 2800);
        put("에그 슬라이스", 2400);
        put("아보카도", 3000);
        put("오믈렛", 3600);
        put("페퍼로니", 2800);
    }};


    public Topping(String size) {
        this.size = size;
    }

    @Override
    public void select(String type, long price) {
        super.select(type, price);
    }

    public List<String> getList() {
        return super.toppings;
    }

    public long getPrice() {
        return super.price;
    }

    public void selectTopping() {
        LinkedHashMap<String, Integer> toppingTypes; // 선택한 사이즈에 따라 토핑 종류 다르게
        if (this.size.equals("15cm")) {
            toppingTypes = toppings15cm;
        } else {
            toppingTypes = toppings30cm;
        }

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=     [4] 추가 토핑을 선택해주세요. (1~8)  =");
        System.out.println("=                                    =");
        System.out.println("=    선택하지 않으실 경우 엔터를 눌러주세요.   =");
        System.out.println("=                                    =");
        System.out.println("=          2개 이상의 토핑 추가 시        =");
        System.out.println("=       숫자를 **띄어서** 입력해주세요.     =");
        System.out.println("=      모두 선택하시려면 0을 입력해주세요.    =");
        System.out.println("=                                    =");

        int i = 1;
        for (String topping : toppingTypes.keySet()) {
            String formattedString = String.format("%1$-25s",
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
            if (!input.contains(" ") && Integer.parseInt(input) == 0) {
                selectedNumList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
                break;
            } else {
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
            }
        } while (true);

        if (!selectedNumList.isEmpty()) {
            for (int selectedNum : selectedNumList) {
                String selectedType = (String) toppingTypes.keySet().toArray()[selectedNum - 1];
                this.select(selectedType, toppingTypes.get(selectedType));
            }
        }
    }
}