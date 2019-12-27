package ru.job4j.banktransfers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank {
    private Map<User, List<Account>> userAccounts = new HashMap<>();
    public void addUser(User user) {
        this.userAccounts.put(user, new LinkedList<Account>());
    }
    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }
    public void addAccountToUser(String passport, Account account) {
        User user = this.getUser(passport);
        List<Account> list = this.userAccounts.get(user);
        if (list != null && !list.contains(account)) {
            list.add(account);
        }
    }
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> userAc = this.getUserAccounts(passport);
        userAc.remove(account);

    }
    public List<Account> getUserAccounts(String passport) {
        User user = this.getUser(passport);
        List<Account> result = this.userAccounts.get(user);
        if (result == null) {
            result = new LinkedList<Account>();
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean result = false;
        Account srcAccount = this.getAccount(this.getUserAccounts(srcPassport), srcRequisite);
        Account destAccount = this.getAccount(this.getUserAccounts(destPassport), destRequisite);
        if (srcAccount != null && destAccount != null) {
            double isBalance = srcAccount.getValue();
            if (isBalance < amount) {
                result = false;
            } else {
                srcAccount.setValue(isBalance - amount);
                destAccount.setValue(destAccount.getValue() + amount);
                result = true;
            }
        }
        return result;
    }

    private Account getAccount(List<Account> accounts, String requisite) {
        List<Account> rsl;
        rsl = accounts.stream().filter(
                el -> el.getRequisites().equals(requisite)
        ).collect(Collectors.toList());
        return rsl.size() > 0 ? rsl.get(0) : null;
    }

    private User getUser(String passport) {
        List<User> rsl = this.userAccounts.entrySet().stream().map(
                el -> el.getKey()
        ).filter(
                el -> el.getPassport().equals(passport)
        ).collect(Collectors.toList());
        return rsl.size() > 0 ? rsl.get(0) : null;
    }

}
