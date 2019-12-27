package banktransfers;

import org.junit.Test;
import ru.job4j.banktransfers.Account;
import ru.job4j.banktransfers.Bank;
import ru.job4j.banktransfers.User;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {
    @Test
    public void whenCheckGetUsrersAccountNull() {
        Bank bank = new Bank();
        User user = new User("Roman", "ks052635");
        bank.addUser(user);
        Account account = new Account(10000, "4056897812");
        bank.addAccountToUser(user.getPassport(), account);
        List<Account> list = bank.getUserAccounts("incorrect");
        bank.deleteAccountFromUser("incorrect", account);

        assertThat(
                list.size(),
                is(0)
        );
    }

    @Test
    public void whenAddUserToMap() {
        Bank bank = new Bank();
        bank.addUser(new User("Roman", "ks052635"));
        Account account = new Account(10000, "4056897812");
        bank.addAccountToUser("ks052635", account);
        List<Account> list = bank.getUserAccounts("ks052635");
        assertThat(
                account,
                is(list.get(0))
        );

    }
    @Test
    public void whencheckDeleteUSer() {
        Bank bank = new Bank();
        User user = new User("Roman", "ks052635");
        bank.addUser(user);
        Account account = new Account(10000, "4056897812");
        bank.addAccountToUser(user.getPassport(), account);
        bank.deleteUser(user);
        List<Account> expected = bank.getUserAccounts(user.getPassport());

        assertThat(
                expected.size(),
                is(0)
        );
    }
    @Test
    public void whenCheckDeleteAccountFromUser() {
        Bank bank = new Bank();
        User user = new User("Roman", "ks052635");
        bank.addUser(user);
        Account account = new Account(10000, "4056897812");
        bank.addAccountToUser(user.getPassport(), account);
        bank.deleteAccountFromUser(user.getPassport(), account);
        List<Account> list = bank.getUserAccounts(user.getPassport());

        assertThat(
                list.size(),
                is(0)
        );
    }
    @Test
    public void whenCheckTransferMoneyWhenDifferentUsers() {
        Bank bank = new Bank();
        User roman = new User("Roman", "ks052634");
        User petro = new User("Petro", "vs457896");
        bank.addUser(roman);
        bank.addUser(petro);
        Account accRoman = new Account(100, "512132222");
        Account accPetro = new Account(50, "256398742");
        bank.addAccountToUser(roman.getPassport(), accRoman);
        bank.addAccountToUser(petro.getPassport(), accPetro);
        boolean transfer = bank.transferMoney(roman.getPassport(), accRoman.getRequisites(),
                petro.getPassport(), accPetro.getRequisites(), 50);

        assertThat(
                transfer,
                is(true)
        );

        assertThat(
                accRoman.getValue(),
                is(50.0)
        );

        assertThat(
                accPetro.getValue(),
                is(100.0)
        );

    }
    @Test
    public void whenCheckTransferBalanceIsLessThanAmount() {
        Bank bank = new Bank();
        User roman = new User("Roman", "ks052634");
        User petro = new User("Petro", "vs457896");
        bank.addUser(roman);
        bank.addUser(petro);
        Account accRoman = new Account(100, "512132222");
        Account accPetro = new Account(50, "256398742");
        bank.addAccountToUser(roman.getPassport(), accRoman);
        bank.addAccountToUser(petro.getPassport(), accPetro);
        boolean transfer = bank.transferMoney(roman.getPassport(), accRoman.getRequisites(),
                petro.getPassport(), accPetro.getRequisites(), 150);

        assertThat(
                transfer,
                is(false)
        );
    }
}
