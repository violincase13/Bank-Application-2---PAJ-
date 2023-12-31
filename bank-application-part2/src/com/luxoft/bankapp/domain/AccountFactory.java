//exercise 1.1
package com.luxoft.bankapp.domain;
import com.luxoft.bankapp.domain.AbstractAccount.CheckingAccount;
import com.luxoft.bankapp.domain.AbstractAccount.SavingAccount;

public class AccountFactory {

    // private constructor to prevent instantiation
    private AccountFactory() {
        throw new AssertionError("AccountFactory should not be instantiated.");
    }

    public static CheckingAccount createCheckingAccount(int id, double amount, double overdraft) {
        return new CheckingAccount(id, amount, overdraft);
    }

    public static CheckingAccount createCheckingAccount(int id, double amount, double overdraft, Currency currency) {
        return new CheckingAccount(id, amount, overdraft, currency);
    }

    public static SavingAccount createSavingAccount(int id, double amount) {
        return new SavingAccount(id, amount);
    }

    public static SavingAccount createSavingAccount(int id, double amount, Currency currency) {
        return new SavingAccount(id, amount, currency);
    }
}
