package ood.lsp.food;

import java.time.LocalDate;

public class Milk extends Food {
    public Milk(String name, org.joda.time.LocalDate createDate, org.joda.time.LocalDate expireDate) {
        super(name, createDate, expireDate);
    }
}
