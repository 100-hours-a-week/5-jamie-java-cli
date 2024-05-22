package subway.extraMenu;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class ExtraMenu {

    private String type;
    private long price;

    private final LinkedHashMap<String, Integer> sideMenus = new LinkedHashMap<>() {{
        put("콘 수프 (하프)", 2400);
        put("머쉬룸 수프 (하프)", 2400);
        put("콘 수프 (레귤러)", 3900);
        put("머쉬룸 수프 (레귤러)", 3900);
        put("해쉬브라운", 1800);
        put("웨지 포테이토", 1900);
        put("과자 칩", 1300);
        put("고구마 칩", 2200);
    }};
    private final LinkedHashMap<String, Integer> cookies = new LinkedHashMap<>() {{
        put("초코칩 쿠키", 1300);
        put("더블 초코칩 쿠키", 1300);
        put("오트밀 레이즌 쿠키", 1300);
        put("라즈베리 치즈케익 쿠키", 1300);
        put("화이트 초코 마카다미아 쿠키", 1300);
    }};
    private final LinkedHashMap<String, Integer> drinks = new LinkedHashMap<>() {{
        put("코카콜라", 2000);
        put("스프라이트", 2000);
        put("코카콜라 제로", 2000);
        put("닥터페퍼", 2000);
        put("아메리카노", 2500);
    }};

    public ExtraMenu() {
    }

    public void selectExtraMenu() {
        label:
        do {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            switch (Integer.parseInt(input)) {
                case 1:
                    selectDetailExtraMenu(sideMenus);
                    break label;
                case 2:
                    selectDetailExtraMenu(cookies);
                    break label;
                case 3:
                    selectDetailExtraMenu(drinks);
                    break label;
                default:
                    System.out.println("============== KAKAOWAY ==============");
                    System.out.println("=     잘못된 입력입니다. 다시 입력해주세요.   =");
                    System.out.println("======================================");
                    break;
            }
        } while (true);
    }

    public void selectDetailExtraMenu(LinkedHashMap<String, Integer> extraMenus) {
        int listSize = extraMenus.size();

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=     사이드 메뉴를 1개 선택해주세요. (1~" + listSize + ")  =");
        System.out.println("=                                    =");

        int i = 1;
        for (String extraMenu : extraMenus.keySet()) {
            String formattedString = String.format("%1$-25s",
                extraMenu + " (" + extraMenus.get(extraMenu) + "원)");
            System.out.println("=      " + i + ". " + formattedString + " =");
            i++;
        }
        System.out.println("======================================");

        int selectedNum;
        do {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            if (!input.matches("^[0-9 ]*$")) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=           숫자를 입력해주세요.          =");
                System.out.println("======================================");
            } else if (Integer.parseInt(input) > extraMenus.size()
                || Integer.parseInt(input) < 1) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=     잘못된 입력입니다. 다시 입력해주세요.   =");
                System.out.println("======================================");
            } else {
                selectedNum = Integer.parseInt(input);
                break;
            }

        } while (true);

        this.type = extraMenus.keySet().toArray()[selectedNum - 1].toString();
        this.price = extraMenus.get(this.type);
    }

    public String getType() {
        return type;
    }

    public long getPrice() {
        return price;
    }
}
