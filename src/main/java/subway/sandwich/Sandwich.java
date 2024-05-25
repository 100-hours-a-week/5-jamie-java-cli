package subway.sandwich;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {

    private String type;
    private String size;
    private String bread;
    private String cheese;
    private List<String> vegetables = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();
    private List<String> toppings = new ArrayList<>();
    private int price;

    public Sandwich() {
    }

    public void setType(String type) {
        this.type = type;
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

    public void setPrice(int price) {
        this.price += price;
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
