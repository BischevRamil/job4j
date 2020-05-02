package ood.lsp.food;

import org.joda.time.Days;

/**
 * @author Ramil Bischev.
 * @version 1.0.
 * @since 2020-05-02.
 *
 * Class Food. Main class for all foods. Field shelfLife is percent of expired time.
 * ShelfLife calculated for now date. And class has shelfLife-getter for tests.
 */
public class Food {
    private final String name;
    private final org.joda.time.LocalDate createDate;
    private final org.joda.time.LocalDate expireDate;
    private Double price;
    private Integer discount;
    private Integer shelfLife;

    public Food(String name, org.joda.time.LocalDate createDate, org.joda.time.LocalDate expireDate) {
        this.name = name;
        this.createDate = createDate;
        this.expireDate = expireDate;

        org.joda.time.LocalDate today = org.joda.time.LocalDate.now();
        int periodFull = Days.daysBetween(this.createDate, this.expireDate).getDays();
        int periodToday = Days.daysBetween(this.createDate, today).getDays();

        this.shelfLife = Math.abs((periodToday * 100) / periodFull);
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getShelfLife() {
        return this.shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }
    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", createDate=" + createDate +
                ", expireDate=" + expireDate +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
