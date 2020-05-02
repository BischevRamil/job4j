package ood.lsp.food;

import java.time.LocalDate;

public class Water extends Food {
    public Water(String name, org.joda.time.LocalDate createDate, org.joda.time.LocalDate expireDate) {
        super(name, createDate, expireDate);
    }
}
