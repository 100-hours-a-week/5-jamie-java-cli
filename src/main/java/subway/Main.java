package subway;

import subway.delivery.Delivery;
import subway.extraMenu.ExtraMenu;
import subway.order.Order;

import java.util.Scanner;
import subway.sandwich.Sandwich;

public class Main {

    Scanner sc = new Scanner(System.in);

    static Order order = new Order();

    public static void main(String[] args) {
        Main main = new Main();
        main.start();

        if (order.getStatus()) {
            main.completeOrder();
        }
    }

    public void start() {
        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=     카카오웨이에 오신 것을 환영합니다!     =");
        System.out.println("=      주문을 시작하시겠습니까? (Y/N)      =");
        System.out.println("======================================");

        do {
            String input = sc.nextLine();
            if (input.equals("Y") || input.equals("y")) {
                order.start();
                break;
            } else if (input.equals("N") || input.equals("n")) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=          프로그램을 종료합니다.          =");
                System.out.println("======================================");
                System.exit(0); // 프로그램 종료
            } else {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("= 잘못된 입력입니다. 다시 입력해주세요. (Y/N) =");
                System.out.println("======================================");
            }
        } while (true);
    }

    public void completeOrder() {
        System.out.println("=                                    =");
        System.out.println("=                                    =");
        System.out.println("=            배달이 완료되었습니다.        =");
        System.out.println("=           주문해주셔서 감사합니다.       =");
        System.out.println("=                  🤍                =");
        System.out.println("=                                    =");
        System.out.println("=              [ 주문내역 ]            =");

        // 주문된 샌드위치 출력
        for (Sandwich sandwich : order.getSandwiches()) {
            System.out.println("== ============ 샌드위치 ===============");
            System.out.println("= 샌드위치: " + sandwich.getType());
            System.out.println("= 사이즈: " + sandwich.getSize());
            System.out.println("= 빵: " + sandwich.getBread());
            System.out.println("= 치즈: " + sandwich.getCheese());
            System.out.println("= 토핑: " + sandwich.getToppings());
            System.out.println("= 야채: " + sandwich.getVegetables());
            System.out.println("= 소스: " + sandwich.getSauces());
            System.out.println("= 가격: " + sandwich.getPrice());
        }

        // 주문된 추가 메뉴 출력
        for (ExtraMenu extraMenu : order.getExtraMenus()) {
            System.out.println("== ============ 추가메뉴 ===============");
            System.out.println("= 추가 메뉴: " + extraMenu.getType());
            System.out.println("= 가격: " + extraMenu.getPrice());
        }

        System.out.println("======================================");
    }
}
