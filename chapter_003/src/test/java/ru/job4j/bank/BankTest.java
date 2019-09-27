package ru.job4j.bank;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {
    private Bank testBank = new Bank();
    private User vasya = new User("vasya", "passportVasya");
    private User petya = new User("petya", "passportPetya");

    @Before
    public void init() {
        testBank.addUser(vasya);
        testBank.addUser(petya);
    }
    @Test
    public void addUserTest() {
        int expected = 2;
        assertThat(expected, is(testBank.getUsers().size()));
    }

    @Test
    public void deleteUserTest() {
        testBank.deleteUser(vasya);
        int expected = 1;
        assertThat(expected, is(testBank.getUsers().size()));
    }

    @Test
    public void addAccountToUserTest() {
        Account account = new Account(200, "2222");
        testBank.addAccountToUser(petya.getPassport(), account);
        int expected = 1;
        assertThat(expected, is(testBank.getUserAccounts(petya.getPassport()).size()));
    }

    @Test
    public void deleteAccountFromUserTest() {
        Account account = new Account(200, "2222");
        testBank.addAccountToUser(petya.getPassport(), account);
        testBank.deleteAccountFromUser(petya.getPassport(), account);
        int expected = 0;
        assertThat(expected, is(testBank.getUserAccounts(petya.getPassport()).size()));
    }

    @Test
    public void transferMoneyFromUserToUserTest() {
        Account petyaAccount = new Account(200, "petyaReq");
        testBank.addAccountToUser(petya.getPassport(), petyaAccount);
        Account vasyaAccount = new Account(100, "vasyaReq");
        testBank.addAccountToUser(vasya.getPassport(), vasyaAccount);
        boolean result = testBank.transferMoney(petya.getPassport(), petyaAccount.getRequisites(), vasya.getPassport(), vasyaAccount.getRequisites(), 50);
        assertThat(result, is(true));
        assertThat((double) 150, is(vasyaAccount.getValue()));
        assertThat((double) 150, is(petyaAccount.getValue()));
    }

    @Test
    public void transferMoneyFromUserToUserTestNotEnoughMoney() {
        Account petyaAccount = new Account(200, "petyaReq");
        testBank.addAccountToUser(petya.getPassport(), petyaAccount);
        Account vasyaAccount = new Account(100, "vasyaReq");
        testBank.addAccountToUser(vasya.getPassport(), vasyaAccount);
        boolean result = testBank.transferMoney(petya.getPassport(), petyaAccount.getRequisites(), vasya.getPassport(), vasyaAccount.getRequisites(), 201);
        assertThat(result, is(false));
        assertThat((double) 100, is(vasyaAccount.getValue()));
        assertThat((double) 200, is(petyaAccount.getValue()));
    }
}
