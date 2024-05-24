package subway.extraMenu.menus;

import java.util.LinkedHashMap;

public class Soup extends Others {
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
}
