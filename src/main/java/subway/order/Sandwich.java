package subway.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import subway.maker.SandwichMaker;
import subway.maker.type.SandwichType;
import subway.maker.ingredients.*;


public class Sandwich {

    private String type;
    private String size;
    private String bread;
    private String cheese;
    private List<String> vegetables = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();
    private List<String> toppings = new ArrayList<>();
    private long price;

    private int count = 0;

    private SandwichMaker sandwichMaker;

    public Sandwich() {
    }

    public void setType(SandwichType sandwichType) {
        this.type = sandwichType.getName();
        this.price += sandwichType.getPrice();
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }

    public void setSauces(List<String> sauces) {
        this.sauces = sauces;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    public void setPrice(long price) {
        this.price += price;
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


    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getBread() {
        return bread;
    }

    public String getCheese() {
        return cheese;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public List<String> getToppings() {
        return toppings;
    }

    public long getPrice() {
        return price;
    }
}
