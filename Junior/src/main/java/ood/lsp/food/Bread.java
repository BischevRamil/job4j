package ood.lsp.food;

import java.time.LocalDate;

public class Bread extends Food {
    public Bread(String name, org.joda.time.LocalDate createDate, org.joda.time.LocalDate expireDate) {
        super(name, createDate, expireDate);
    }
}
