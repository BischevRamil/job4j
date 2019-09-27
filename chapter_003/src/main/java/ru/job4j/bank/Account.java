package ru.job4j.bank;

import java.util.Objects;

/**
 * @author ramil bishev
 * @since 2019-09-27
 */

public class Account {
    private double value;
    private String requisites;

    Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public String getRequisites() {
        return requisites;
    }

    @Override
    public String toString() {
        return "Account{"
                + "requisites=" + requisites
                + ", value='" + value + '\''
                + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Account account = (Account) obj;
        return requisites == account.requisites && (requisites == account.requisites || requisites != null && requisites.equals(account.getRequisites()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, requisites);
    }

    public boolean transferMoney(Account dest, double amount) {
        boolean result = false;
        if (dest != null && amount <= this.getValue()) {
            this.setValue(this.getValue() - amount);
            dest.setValue(dest.getValue() + amount);
            result = true;
        }
        return result;
    }
}
