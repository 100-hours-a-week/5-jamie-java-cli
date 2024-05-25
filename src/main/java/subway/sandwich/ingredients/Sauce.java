package subway.sandwich.ingredients;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sauce extends Ingredient {

    private List<String> list;
    private static final String[] sauces = {"랜치", "스위트 어니언", "마요네즈", "스위트 칠리", "핫 칠리", "스모크 바비큐", "허니 머스타드",
        "사우스웨스트 치폴레", "홀스래디쉬", "머스타드", "올리브 오일", "레드와인 식초", "소금", "후추"};

    public Sauce() {
    }

    @Override
    public void select(List<String> list) {
        super.select(list);
    }

    public List<String> getList() {
        return super.list;
    }

    public void selectSauces() {
        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=      [5]  소스를 선택해주세요. (1~8)    =");
        System.out.println("=                                    =");
        System.out.println("=       숫자를 **띄어서** 입력해주세요.     =");
        System.out.println("=       최대 3개 까지 선택 가능합니다.      =");
        System.out.println("=                                    =");

        int i = 1;
        for (String sauce : sauces) {
            String formattedString = String.format("%1$-24s", sauce);
            System.out.println("=      " + i + ". " + formattedString + " =");
            i++;
        }
        System.out.println("======================================");

        List<Integer> selectedNumList = new ArrayList<>();
        do {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (!input.matches("^[0-9 ]+$")) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=           숫자를 입력해주세요.          =");
                System.out.println("======================================");
                continue;
            }

            // 입력값의 숫자들을 하나씩 리스트에 저장
            boolean isValid = true;
            String[] inputList = input.split(" "); // 개수 제한을 위해 배열로 저장

            if (inputList.length > 3) {
                isValid = false;
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=4개 이상 선택할 수 없습니다. 다시 입력해주세요.=");
                System.out.println("======================================");
                continue;
            }

            for (String st : inputList) {
                if (Integer.parseInt(st) > sauces.length || Integer.parseInt(st) < 1) {
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

        List<String> selectedTypeList = new ArrayList<>();
        for (
            int selectedNum : selectedNumList) {
            selectedTypeList.add(sauces[selectedNum - 1]);
        }
        this.select(selectedTypeList);
    }
}
