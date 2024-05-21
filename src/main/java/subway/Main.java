package subway;

import subway.delivery.Delivery;
import subway.order.Order;

import java.util.Scanner;

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
                startOrder();
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

    public void startOrder() {
        order.start();
    }

    public void completeOrder() {
        System.out.println("=                                    =");
        System.out.println("=                                    =");
        System.out.println("=            배달이 완료되었습니다.        =");
        System.out.println("=           주문해주셔서 감사합니다.       =");
        System.out.println("=                  🤍                =");
        System.out.println("=                                    =");
        System.out.println("=              [ 주문내역 ]            =");
        // TODO: 주문 내역 출력
        System.out.println("======================================");
    }
}
