package subway.extraMenu.menus;

import java.util.LinkedHashMap;

public class Cookie extends Others {

    private final LinkedHashMap<String, Integer> cookies = new LinkedHashMap<>() {{
        put("초코칩 쿠키", 1300);
        put("더블 초코칩 쿠키", 1300);
        put("오트밀 레이즌 쿠키", 1300);
        put("라즈베리 치즈케익 쿠키", 1300);
        put("화이트 초코 마카다미아 쿠키", 1300);
    }};
}
