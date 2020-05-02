package ood.lsp.food;

import java.time.LocalDate;

public class Meat extends Food {

    public Meat(String name, org.joda.time.LocalDate createDate, org.joda.time.LocalDate expireDate) {
        super(name, createDate, expireDate);
    }
}
