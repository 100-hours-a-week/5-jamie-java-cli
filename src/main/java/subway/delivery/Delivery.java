package subway.delivery;

import subway.order.Order;

import java.util.List;
import java.util.Scanner;

public class Delivery {
    private String status = "배달 전";
    private String address;
    private String phoneNumber;
    private String deliveryTime;

    Scanner sc = new Scanner(System.in);

    public Delivery() {
    }

    public void processDelivery() {
//        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=     배달 주소와 전화번호를 입력해주세요.    =");
        System.out.println("======================================");

        System.out.print("배달 주소: ");
        this.address = sc.nextLine();

        System.out.print("전화번호 (숫자만 입력): ");
        this.phoneNumber = sc.nextLine();

        System.out.println("============== KAKAOWAY ==============");
        System.out.println("=     배달 주소와 전화번호가 등록되었습니다.   =");

        assignDeliveryTime();

        System.out.println("=       배달 예정 시간은 " + this.deliveryTime + " 입니다.      =");
//        System.out.println("======================================");

        updateStatus("배달중");

        // 2초 후 status 업데이트
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        updateStatus("배달완료");
        Order.latch.countDown();
    }


    public void assignDeliveryTime() {
        List<String> times = List.of("10분", "20분", "30분", "40분", "50분", "60분");
        this.deliveryTime = times.get((int) (Math.random() * times.size()));
    }

    public String getStatus() {
        return status;
    }

    public void updateStatus(String status) {
        this.status = status;
    }
}
