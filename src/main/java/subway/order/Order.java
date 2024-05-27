package subway.order;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import subway.delivery.Delivery;

import java.util.Scanner;
import subway.extraMenu.ExtraMenu;
import subway.extraMenu.ExtraMenuAdder;
import subway.management.Inventory;
import subway.management.Manager;
import subway.sandwich.Sandwich;
import subway.sandwich.SandwichMaker;

public class Order {

    Scanner sc = new Scanner(System.in);
    Inventory inventory = new Inventory();
    SandwichMaker sandwichMaker = new SandwichMaker();
    ExtraMenuAdder extraMenuAdder = new ExtraMenuAdder(inventory);
    Delivery delivery = new Delivery();

    boolean status;
    private final List<String> items = inventory.getItems();

    ArrayList<Sandwich> sandwiches = new ArrayList<>();
    ArrayList<ExtraMenu> extraMenus = new ArrayList<>();


    public Order() {
    }

    public void start() {
        Thread managerThread = new Thread(new Manager(inventory, items));
        managerThread.start();

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=            주문을 시작합니다.          =");
        System.out.println("=     원하시는 주문을 선택해주세요. (1/2)   =");
        System.out.println("=                                    =");
        System.out.println("=         1. 샌드위치 주문하기           =");
        System.out.println("=         2. 추가 메뉴 주문하기          =");
        System.out.println("======================================");

        takeOrder();
    }

    public void takeOrder() {
        boolean isAdditionalOrder = false;
        int nextSelection = 0;

        do {
            if (!isAdditionalOrder) {
                String input = sc.nextLine();

                if (input.equals("1")) {
                    nextSelection = processSandwichOrder();
                } else if (input.equals("2")) {
                    nextSelection = processExtraMenuOrder();
                } else {
                    System.out.println("============== KAKAOWAY ==============");
                    System.out.println("=   ❗️ 잘못된 입력입니다. 다시 입력해주세요.  =");
                    System.out.println("======================================");
                    continue;
                }

                isAdditionalOrder = true;
            } else {
                if (nextSelection == 1) {
                    nextSelection = processSandwichOrder();
                } else if (nextSelection == 2) {
                    nextSelection = processExtraMenuOrder();
                } else if (nextSelection == 3) {
                    confirmOrder();
                    break;
                } else {
                    System.out.println("============== KAKAOWAY ==============");
                    System.out.println("=   ❗️ 잘못된 입력입니다. 다시 입력해주세요.  =");
                }
            }

        } while (true);

    }

    public int processSandwichOrder() {
        Sandwich sandwich = sandwichMaker.makeSandwich();
        sandwiches.add(sandwich);

        return askForAdditionalOrder();
    }

    public int processExtraMenuOrder() {
        ExtraMenu extraMenu = extraMenuAdder.addExtraMenu(this);
        extraMenus.add(extraMenu);

        return askForAdditionalOrder();
    }

    public int askForAdditionalOrder() {

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=       추가 주문을 하시겠습니까? (1~3)    =");
        System.out.println("=                                    =");
        System.out.println("=  1. 샌드위치 주문하기                  =");

        if (!inventory.isInStock("랩") && !inventory.isInStock("샐러드") && !inventory.isInStock(
            "세트메뉴")) {
            System.out.println("=  2. 추가 메뉴 주문하기 (품절 / 주문 불가) =");
        } else {
            System.out.println("=  2. 추가 메뉴 주문하기                 =");
        }

        System.out.println("=  3. 주문 완료하기                     =");
        System.out.println("======================================");

        do {
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    return 1;
                case "2":
                    return 2;
                case "3":
                    return 3;
                default:
                    System.out.println("============== KAKAOWAY ==============");
                    System.out.println("=   ❗️ 잘못된 입력입니다. 다시 입력해주세요.  =");
                    break;
            }
        } while (true);
    }

    public String calculateTotalPrice() {
        long totalPrice = 0;

        for (Sandwich sandwich : sandwiches) {
            totalPrice += sandwich.getPrice();
        }
        for (ExtraMenu extraMenu : extraMenus) {
            totalPrice += extraMenu.getPrice();
        }

        // 1000원 단위로 , 찍기
        NumberFormat nf = NumberFormat.getInstance();
        return nf.format(totalPrice);
    }

    public void confirmOrder() {
        String totalPrice = calculateTotalPrice();

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=          주문이 완료되었습니다.         =");
        System.out.println("=    결제 예정 금액은 " + totalPrice + "원 입니다.     =");
        System.out.println("=      결제를 진행하시겠습니까? (Y/N)      =");
        System.out.println("======================================");

        do {
            sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.equals("Y") || input.equals("y")) {
                processPayment();

                if (!sandwiches.isEmpty()) { // 샌드위치 주문 시
                    sandwichMaker.waitForSandwich(); // 샌드위치 제조
                }

                delivery.processDelivery(); // 배달

                if (delivery.getStatus().equals("배달완료")) {
                    this.status = true;
                }

                break;

            } else if (input.equals("N") || input.equals("n")) {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("= ❗️주문을 취소합니다. 다음에 또 이용해주세요! =");
                System.out.println("======================================");
                System.exit(0); // 프로그램 종료
            } else {
                System.out.println("============== KAKAOWAY ==============");
                System.out.println("=   ❗️ 잘못된 입력입니다. 다시 입력해주세요.  =");
                System.out.println("======================================");
            }
        } while (true);
    }

    public void processPayment() {

        do {
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
                break;
            } else if (input == 2) {
                System.out.println("=         신용카드 결제를 진행합니다.       =");
                break;
            } else {
                System.out.println("=   ❗️ 잘못된 입력입니다. 다시 입력해주세요.  =");
                System.out.println("======================================");
            }
        } while (true);

        // 1초 후 결제 안료 문구 표시
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=       💳   결제가 완료되었습니다.       =");
    }

    public boolean getStatus() {
        return status;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<ExtraMenu> getExtraMenus() {
        return extraMenus;
    }
}
