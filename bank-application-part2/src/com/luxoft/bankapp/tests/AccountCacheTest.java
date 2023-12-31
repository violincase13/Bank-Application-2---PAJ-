//exercise 2.3
package com.luxoft.bankapp.tests;

import com.luxoft.bankapp.domain.AbstractAccount;
import com.luxoft.bankapp.domain.AccountCache;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import com.luxoft.bankapp.domain.AbstractAccount.CheckingAccount;
import com.luxoft.bankapp.domain.AbstractAccount.SavingAccount;

public class AccountCacheTest {

    @Test
    public void testCloneAccount() {
        // Load the cache with default accounts
        AccountCache.loadCache(new SavingAccount(0, 0), new CheckingAccount(0, 0, 0));

        // Clone a SavingAccount from the cache
        AbstractAccount clonedSavingAccount = AccountCache.cloneAccount(AccountCache.getSavingAccountKey());
        assertNotNullAndNotSame(clonedSavingAccount);

        // Clone a CheckingAccount from the cache
        AbstractAccount clonedCheckingAccount = AccountCache.cloneAccount(AccountCache.getCheckingAccountKey());
        assertNotNullAndNotSame(clonedCheckingAccount);

        // Intentionally fail the test to see the output
        //assert false : "Intentional test failure";
    }

    private void assertNotNullAndNotSame(AbstractAccount account) {
        assertNotNull(account);
        assertNotSame(AccountCache.getAccount(AccountCache.getSavingAccountKey()), account);
    }
}

