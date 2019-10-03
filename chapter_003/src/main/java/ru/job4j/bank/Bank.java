package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Map<User, ArrayList<Account>> collect = userAccounts.entrySet()
                .stream().filter(a -> a.getKey() != user)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        userAccounts.clear();
        userAccounts.putAll(collect);
    }

    public void addAccountToUser(String passport, Account account) {
        userAccounts.entrySet()
                .stream()
                .filter(a -> passport.equals(a.getKey().getPassport()))
                .findFirst()
                .ifPresent(a -> a.getValue().add(account));
    }

    public void deleteAccountFromUser(String passport, Account account) {
        userAccounts.entrySet()
                .stream()
                .filter(a -> passport.equals(a.getKey().getPassport()))
                .findFirst()
                .ifPresent(a -> a.getValue().remove(account));
    }

    public List<Account> getUserAccounts(String passport) {
        return userAccounts.entrySet()
                .stream()
                .filter(a -> passport.equals(a.getKey().getPassport()))
                .findFirst()
                .map(Map.Entry::getValue)
                .filter(Objects::nonNull)
                .get();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        Account srcAccount = getAccount(srcPassport, srcRequisite);
        Account destAccount = getAccount(destPassport, destRequisite);
        return  (srcAccount != null) && (srcAccount.transferMoney(destAccount, amount));
    }

    public Account getAccount(String passport, String requisites) {
        return getUserAccounts(passport)
                .stream()
                .filter(a -> a.getRequisites().equals(requisites))
                .findFirst()
                .filter(Objects::nonNull)
                .get();
    }

    public List<User> getUsers() {
        return userAccounts.keySet()
                .stream()
                .collect(Collectors.toList());
    }

}
