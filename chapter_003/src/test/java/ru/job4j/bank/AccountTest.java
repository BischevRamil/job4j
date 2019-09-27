package ru.job4j.bank;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccountTest {
    @Test
    public void transferMoneyTest() {
        Account srcAccount = new Account(120, "5555");
        Account destAccount = new Account(100, "2222");
        double expected = 200;
        srcAccount.transferMoney(destAccount, 100);
        assertThat(expected, is(destAccount.getValue()));
    }
}
