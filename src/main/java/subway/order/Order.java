package subway.order;

import subway.delivery.Delivery;
import subway.maker.SandwichMaker;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Order {

    Scanner sc = new Scanner(System.in);
    SandwichMaker sandwichMaker = new SandwichMaker();
    Delivery delivery = new Delivery();
    boolean status;
    public static CountDownLatch latch = new CountDownLatch(1);

    public Order() {
    }

    public void start() {
        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=            주문을 시작합니다.          =");
        System.out.println("=     원하시는 주문을 선택해주세요. (1/2)   =");
        System.out.println("=                                    =");
        System.out.println("=         1. 샌드위치 주문하기           =");
        System.out.println("=         2. 사이드 메뉴 주문하기         =");
        System.out.println("======================================");

        int input = sc.nextInt();

        if (input == 1) {
            System.out.println("샌드위치 주문하기");
//            orderSandwich();
        } else if (input == 2) {
//            orderExtraMenu();
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            start();
        }

        processOrder();
    }

//    public void addSandwich(Sandwich sandwich) {
//        this.sandwich = sandwich;
//    }
//
//    public void addExtraMenu(ExtraMenu extraMenu) {
//        this.extraMenu = extraMenu;
//    }

    public void calculatePrice() {

    }

    public void processOrder() {
        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=            주문이 완료되었습니다.       =");
        System.out.println("=      결제 예정 금액은 100000원 입니다.   =");
        System.out.println("=        결제를 진행하시겠습니까? (Y/N)    =");
        System.out.println("======================================");

        sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equals("Y") || input.equals("y")) {
            processPayment();

            try {
                sandwichMaker.makeSandwich();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            delivery.processDelivery();

            try { // processDelivery() 메소드가 끝나면 latch.await()가 끝나면서 다음 코드 실행
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (delivery.getStatus().equals("배달완료")) {
                this.status = true;
            }

        } else {

            System.out.println("============== KAKAOWAY ==============");
            System.out.println("=   주문을 취소합니다. 다음에 또 이용해주세요! =");
            System.out.println("======================================");
            System.exit(0); // 프로그램 종료
        }
    }

    public void processPayment() {
        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=            결제를 진행합니다.          =");
        System.out.println("=      결제 방법을 선택해주세요. (1/2)     =");
        System.out.println("=                                    =");
        System.out.println("=         1. 카카오페이 결제             =");
        System.out.println("=         2. 신용카드 결제              =");
        System.out.println("======================================");

        int input = sc.nextInt();
        System.out.println("============== KAKAOWAY ==============");
        if (input == 1) {
            System.out.println("=        카카오페이 결제를 진행합니다.      =");
        } else if (input == 2) {
            System.out.println("=         신용카드 결제를 진행합니다.       =");
        } else {
            System.out.println("=     잘못된 입력입니다. 다시 입력해주세요.   =");
            System.out.println("======================================");
            processPayment();
        }

        // 1초 후 결제 안료 문구 표시
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=           결제가 완료되었습니다.        =");
    }

    public boolean getStatus() {
        return status;
    }
}
