package subway.extraMenu;

import java.util.Scanner;
import subway.extraMenu.menus.Salad;
import subway.extraMenu.menus.SetMenu;
import subway.extraMenu.menus.Wrap;
import subway.management.Inventory;
import subway.order.Order;

public class ExtraMenuAdder {

    private final Inventory inventory;

    public ExtraMenuAdder(Inventory inventory) {
        this.inventory = inventory;
    }

    public ExtraMenu addExtraMenu(Order order) {
        ExtraMenu extraMenu = new ExtraMenu();

        if (!inventory.isInStock("랩") && !inventory.isInStock("샐러드") && !inventory.isInStock(
            "세트메뉴")) {
            System.out.println("============== KAKAOWAY ==============");
            System.out.println("=           😭  죄송합니다.             =");
            System.out.println("=      추가 메뉴가 모두 품절되었습니다.      =");
            return extraMenu;
        }

        if (!order.getSandwiches().isEmpty()) {
            System.out.println("============== KAKAOWAY ==============");
            System.out.println("=      추가 메뉴를 선택해주세요. (0~3)     =");
            System.out.println("=                                    =");
            System.out.println("=    0. 돌아가기                       =");

            if (inventory.isInStock("랩")) {
                System.out.println("=    1. 랩                           =");
            } else {
                System.out.println("=    1. 랩 (품절 / 주문 불가)            =");
            }

            if (inventory.isInStock("샐러드")) {
                System.out.println("=    2. 샐러드                         =");
            } else {
                System.out.println("=    2. 샐러드 (품절 / 주문 불가)          =");
            }

            if (inventory.isInStock("세트메뉴")) {
                System.out.println("=    3. 쿠키 음료 세트  (2500원 추가)     =");
            } else {
                System.out.println("=    3. 쿠키 음료 세트  (품절 / 주문 불가)  =");
            }

            System.out.println("======================================");
        } else {
            System.out.println("============== KAKAOWAY ==============");
            System.out.println("=      추가 메뉴를 선택해주세요. (1~2)     =");
            System.out.println("=                                    =");

            if (inventory.isInStock("랩")) {
                System.out.println("=    1. 랩                           =");
            } else {
                System.out.println("=    1. 랩 (품절 / 주문 불가)            =");
            }

            if (inventory.isInStock("샐러드")) {
                System.out.println("=    2. 샐러드                         =");
            } else {
                System.out.println("=    2. 샐러드 (품절 / 주문 불가)          =");
            }

            System.out.println("======================================");
        }

        Scanner sc = new Scanner(System.in);

        do {
            String input = sc.nextLine();

            switch (input) {
                case "0" -> {
                    return extraMenu;
                }
                case "1" -> {
                    if (!inventory.isInStock("랩")) {
                        System.out.println("============== KAKAOWAY ==============");
                        System.out.println("=         ❗️랩은 품절되었습니다.          =");
                        System.out.println("=         다른 메뉴를 선택해주세요.        =");
                        System.out.println("======================================");
                        return addExtraMenu(order);
                    }

                    Wrap wrap = new Wrap();
                    wrap.selectWrap();

                    extraMenu.setName(wrap.getName());
                    extraMenu.setPrice(wrap.getPrice());
                }
                case "2" -> {
                    if (!inventory.isInStock("샐러드")) {
                        System.out.println("============== KAKAOWAY ==============");
                        System.out.println("=        ❗️️샐러드는 품절되었습니다.        =");
                        System.out.println("=         다른 메뉴를 선택해주세요.        =");
                        System.out.println("======================================");
                        return addExtraMenu(order);
                    }

                    Salad salad = new Salad();
                    salad.selectSalad();

                    extraMenu.setName(salad.getName());
                    extraMenu.setPrice(salad.getPrice());
                    extraMenu.setToppings(salad.getToppings());
                }
                case "3" -> {
                    if (order.getSandwiches().isEmpty()) { // 샌드위치 주문 안했을 경우 세트메뉴 주문 불가
                        System.out.println("============== KAKAOWAY ==============");
                        System.out.println("=   ❗️ 잘못된 입력입니다. 다시 입력해주세요.  =");
                        System.out.println("======================================");
                    }

                    if (!inventory.isInStock("세트메뉴")) {
                        System.out.println("============== KAKAOWAY ==============");
                        System.out.println("=    ❗️쿠키 음료 세트는 품절되었습니다.      =");
                        System.out.println("=         다른 메뉴를 선택해주세요.         =");
                        System.out.println("======================================");
                        return addExtraMenu(order);
                    }

                    SetMenu setMenu = new SetMenu();
                    setMenu.selectSetMenus();

                    extraMenu.setName(setMenu.getName());
                    extraMenu.setSetMenus(setMenu.getSetMenus());
                    extraMenu.setPrice(setMenu.getPrice());
                }
                default -> {
                    System.out.println("============== KAKAOWAY ==============");
                    System.out.println("=   ❗️ 잘못된 입력입니다. 다시 입력해주세요.  =");
                    System.out.println("======================================");
                }
            }
        } while (extraMenu.getName() == null);

        return extraMenu;
    }
}
