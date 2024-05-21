package subway.sandwich.ingredients;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Vegetable extends BasicIngredient {

    private List<String> list;
    static String[] vegetables = {"양상추", "토마토", "오이", "피망", "양파", "피클", "올리브", "할라피뇨"};

    public Vegetable() {
    }

    @Override
    public void select(List<String> list) {
        super.select(list);
    }

    public List<String> getList() {
        return super.list;
    }

    public void selectVegetables() {
        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=      [5]  야채를 선택해주세요. (1~8)    =");
        System.out.println("=                                    =");
        System.out.println("=       숫자를 **띄어서** 입력해주세요.     =");
        System.out.println("=      모두 선택하시려면 0을 입력해주세요.    =");
        System.out.println("=                                    =");

        int i = 1;
        for (String vegetable : vegetables) {
            String formattedString = String.format("%1$-25s", vegetable);
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
            if (!input.contains(" ") && Integer.parseInt(input) == 0) {
                selectedNumList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
                break;
            } else {
                boolean isValid = true;

                for (String st : input.split(" ")) {
                    if (Integer.parseInt(st) > vegetables.length || Integer.parseInt(st) < 1) {
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

        List<String> selectedTypeList = new ArrayList<>();
        for (int selectedNum : selectedNumList) {
            selectedTypeList.add(vegetables[selectedNum - 1]);
        }
        this.select(selectedTypeList);
    }
}
