package subway.extraMenu.menus;

import java.util.Scanner;

public class Cookie extends SetMenu {

    private final String[] cookieTypes = {"초코칩 쿠키", "더블 초코칩 쿠키", "오트밀 레이즌 쿠키", "라즈베리 치즈케익 쿠키",
        "화이트 초코 마카다미아 쿠키"};

    public Cookie() {
    }

    @Override
    public void setCookie(String name) {
        super.setCookie(name);
    }

    public String getCookie() {
        return this.cookie;
    }

    public void selectCookie() {
        int listSize = cookieTypes.length;

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=     [1] 쿠키를 선택해주세요. (1~" + listSize + ")      =");
        System.out.println("=                                    =");

        int i = 1;
        for (String cookie : cookieTypes) {
            String formattedString = String.format("%1$-22s", cookie);
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

        String selectedType = cookieTypes[selectedNum - 1];
        this.setCookie(selectedType);
    }
}
