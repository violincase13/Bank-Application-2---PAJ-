//exercise 2.2
package com.luxoft.bankapp.domain;

import java.util.HashMap;
import java.util.Map;
import com.luxoft.bankapp.domain.AbstractAccount.CheckingAccount;
import com.luxoft.bankapp.domain.AbstractAccount.SavingAccount;

public class AccountCache {

    private static final String SAVING_ACCOUNT_KEY = "SAVING";
    private static final String CHECKING_ACCOUNT_KEY = "CHECKING";

    private static Map<String, AbstractAccount> accountCache = new HashMap<>();

    // Load the cache with default accounts
    static {
        SavingAccount savingAccount = new SavingAccount(0, 0);
        CheckingAccount checkingAccount = new CheckingAccount(0, 0, 0);

        accountCache.put(SAVING_ACCOUNT_KEY, savingAccount);
        accountCache.put(CHECKING_ACCOUNT_KEY, checkingAccount);
    }

    // Method to clone an account from the cache
    public static AbstractAccount cloneAccount(String accountType) {
        AbstractAccount cachedAccount = accountCache.get(accountType);
        if (cachedAccount != null) {
            try {
                return (AbstractAccount) cachedAccount.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException("Clone not supported", e);
            }
        }
        return null;
    }

    // Load the cache with custom accounts
    public static void loadCache(AbstractAccount savingAccount, AbstractAccount checkingAccount) {
        accountCache.put(SAVING_ACCOUNT_KEY, savingAccount);
        accountCache.put(CHECKING_ACCOUNT_KEY, checkingAccount);
    }

    // Getters for keys
    public static String getSavingAccountKey() {
        return SAVING_ACCOUNT_KEY;
    }

    public static String getCheckingAccountKey() {
        return CHECKING_ACCOUNT_KEY;
    }

    // Getter for accounts
    public static AbstractAccount getAccount(String accountType) {
        return accountCache.get(accountType);
    }
}

