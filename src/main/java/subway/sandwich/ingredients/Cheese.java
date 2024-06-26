package subway.sandwich.ingredients;

import java.util.Scanner;

public class Cheese extends Ingredient {

    private static final String[] cheeseTypes = {"모차렐라 치즈", "아메리칸 치즈", "슈레드 치즈"};

    public Cheese() {
    }

    @Override
    public void select(String type) {
        super.select(type);
    }

    public String getName() {
        return super.type;
    }

    public void selectCheese() {
        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=     [3]  치즈를 선택해주세요. (1~3)     =");
        System.out.println("=                                    =");

        int i = 1;
        for (String cheese : cheeseTypes) {
            String formattedString = String.format("%1$-23s", cheese);
            System.out.println("=      " + i + ". " + formattedString + " =");
            i++;
        }
        System.out.println("======================================");

        int selectedNum;
        Scanner sc = new Scanner(System.in);

        do {
            String input = sc.nextLine().trim(); // 공백 제거

            // 입력값이 숫자가 아니라면 다시 입력받기
            if (input.isEmpty() || !input.matches("^[0-9]*$")) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=         ❗️ 숫자를 입력해주세요.         =");
                System.out.println("======================================");
            } else if (Integer.parseInt(input) > cheeseTypes.length
                || Integer.parseInt(input) < 1) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=   ❗️ 잘못된 입력입니다. 다시 입력해주세요.  =");
                System.out.println("======================================");
            } else {
                selectedNum = Integer.parseInt(input);
                break;
            }
        }
        while (true);

        String selectedType = cheeseTypes[selectedNum - 1];
        this.select(selectedType);
    }

}