package subway.extraMenu;

public class ExtraMenuAdder {

    public ExtraMenu addExtraMenu() {
        ExtraMenu extraMenu = new ExtraMenu();

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=      추가 메뉴를 선택해주세요. (1~3)     =");
        System.out.println("=                                    =");
        System.out.println("=         1. 사이드 메뉴               =");
        System.out.println("=         2. 쿠키                     =");
        System.out.println("=         3. 음료수                   =");
        System.out.println("======================================");

        extraMenu.selectExtraMenu();
        return extraMenu;
    }
}
