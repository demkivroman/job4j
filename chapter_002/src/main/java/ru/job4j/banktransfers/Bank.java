package ru.job4j.banktransfers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
        if (!list.contains(account)) {
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
        Account acc = null;
        for (Account account : accounts) {
            if (account.getRequisites().equals(requisite)) {
                acc = account;
                break;
            }
        }
        return acc;
    }

    private User getUser(String passport) {
        User user = null;
        for (Map.Entry<User, List<Account>> entry : this.userAccounts.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                user = entry.getKey();
                break;
            }
        }
        return user;
    }

}
