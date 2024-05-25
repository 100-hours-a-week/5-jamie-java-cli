package subway.delivery;

import java.util.Timer;
import java.util.TimerTask;
import subway.order.Order;

import java.util.List;
import java.util.Scanner;

public class Delivery {

    private String status = "배달 전";
    private String address;
    private String phoneNumber;
    private String deliveryTime;

    Scanner sc = new Scanner(System.in);
    private int count = 0;

    public Delivery() {
    }

    public void processDelivery() {
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

        updateStatus("배달중");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder("=                배달 중");
                sb.append(".".repeat(Math.max(0, count % 4)));
                sb.append("           =");
                System.out.print(sb.toString() + "\r");
                count++;

                if (count == 4) {
                    timer.cancel();
                    System.out.println("=               배달 완료!             =");
                    System.out.println("======================================");
                }
            }
        }, 0, 1000);

        try {
            Thread.sleep(5000);
            updateStatus("배달완료");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
