package ru.job4j.bank;

import java.util.*;

/**
 * @author ramil bishev
 * @since 2019-09-27
 */

public class Bank {
    private TreeMap<User, ArrayList<Account>> userAccounts = new TreeMap<>();

    public void addUser(User user) {
        this.userAccounts.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        if (this.userAccounts.containsKey(user)) {
            this.userAccounts.remove(user);
        }
    }

    public void addAccountToUser(String passport, Account account) {
        for (User user:userAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                this.userAccounts.get(user).add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        for (User user:userAccounts.keySet()) {
            if (user.getPassport().equals(passport) && userAccounts.get(user).contains(account)) {
                this.userAccounts.get(user).remove(account);
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        for (User user:userAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                result.addAll(userAccounts.get(user));
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        Account srcAccount = getAccount(srcPassport, srcRequisite);
        Account destAccount = getAccount(destPassport, destRequisite);
        return  (srcAccount != null) && (srcAccount.transferMoney(destAccount, amount));
    }

    public Account getAccount(String passport, String requisites) {
        Account result = null;
        for (User user:userAccounts.keySet()) {
            if (user.getPassport().equals(passport)) {
                for (Account account:userAccounts.get(user)) {
                    if (account.getRequisites().equals(requisites)) {
                        result = account;
                    }
                }
            }
        }
        return result;
    }

    public List<User> getUsers() {
        List<User> result = new ArrayList<>();
        for (User user:userAccounts.keySet()) {
            result.add(user);
        }
        return result;
    }

}
