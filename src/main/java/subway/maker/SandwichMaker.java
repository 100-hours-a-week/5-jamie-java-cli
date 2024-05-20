package subway.maker;

import java.util.Timer;
import java.util.TimerTask;

public class SandwichMaker {
    private int count = 0;

    public SandwichMaker() {
    }

    public void makeSandwich() {
        System.out.println("=                                    =");
        System.out.println("=         샌드위치 제작을 시작합니다.       =");


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder("=            샌드위치 제작중");
                sb.append(".".repeat(Math.max(0, count % 4)));
                sb.append("          =");
                System.out.print(sb.toString() + "\r");
                count++;

                if (count == 5) {
                    timer.cancel();
                    System.out.println("=            샌드위치 제작 완료!          =");
                }
            }
        }, 0, 1000);

    }
}
