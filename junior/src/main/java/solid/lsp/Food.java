package solid.lsp;

import java.util.Calendar;
import java.util.Date;

public class Food {
    private String name;
    private Calendar expaireDate;
    private Calendar createDate;
    private double price;
    private int discount;

    public Food(String name, Calendar expaireDate, Calendar createDate, double price, int discount) {
        this.name = name;
        this.expaireDate = expaireDate;
        this.createDate = createDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getExpaireDate() {
        return expaireDate;
    }

    public void setExpaireDate(Calendar expaireDate) {
        this.expaireDate = expaireDate;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
