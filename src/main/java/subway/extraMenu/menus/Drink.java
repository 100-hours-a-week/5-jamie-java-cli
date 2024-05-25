package subway.extraMenu.menus;

import java.util.Scanner;

public class Drink extends SetMenu {

    private final String[] drinkTypes = {"코카콜라", "스프라이트", "코카콜라 제로", "스프라이트 제로", "닥터페퍼", "생수"};

    public Drink() {
    }

    @Override
    public void setDrink(String name) {
        super.setDrink(name);
    }

    public String getDrink() {
        return this.drink;
    }

    public void selectDrink() {
        int listSize = drinkTypes.length;

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=     [2] 음료수를 선택해주세요. (1~" + listSize + ")      =");
        System.out.println("=                                    =");

        int i = 1;
        for (String drink : drinkTypes) {
            String formattedString = String.format("%1$-25s", drink);
            System.out.println("=      " + i + ". " + formattedString + " =");
            i++;
        }
        System.out.println("======================================");

        Scanner sc = new Scanner(System.in);

        int selectedNum;
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

        String selectedType = drinkTypes[selectedNum - 1];
        this.setDrink(selectedType);
    }


}
