//exercise 1.2
package com.luxoft.bankapp.tests;
import org.junit.Test;
import static org.junit.Assert.*;

import com.luxoft.bankapp.domain.Currency;
import com.luxoft.bankapp.domain.AccountFactory;
import com.luxoft.bankapp.domain.AbstractAccount.CheckingAccount;
import com.luxoft.bankapp.domain.AbstractAccount.SavingAccount;

public class AccountFactoryTest {

    @Test
    public void testCreateCheckingAccount() {
        CheckingAccount checkingAccount1 = AccountFactory.createCheckingAccount(1, 1000, 200);
        CheckingAccount checkingAccount2 = AccountFactory.createCheckingAccount(2, 500, 100, new Currency("USD"));

        assertNotNull(checkingAccount1);
        assertNotNull(checkingAccount2);

        assertEquals(1, checkingAccount1.getId());
        assertEquals(1000, checkingAccount1.getBalance(), 0.001);
        assertEquals(200, checkingAccount1.overdraft, 0.001);

        assertEquals(2, checkingAccount2.getId());
        assertEquals(500, checkingAccount2.getBalance(), 0.001);
        assertEquals(100, checkingAccount2.overdraft, 0.001);

        // Intentionally fail the test to see the output
        //assert false : "Intentional test failure";
    }

    @Test
    public void testCreateSavingAccount() {
        SavingAccount savingAccount1 = AccountFactory.createSavingAccount(3, 1500);
        SavingAccount savingAccount2 = AccountFactory.createSavingAccount(4, 800, new Currency("EUR"));

        assertNotNull(savingAccount1);
        assertNotNull(savingAccount2);

        assertEquals(3, savingAccount1.getId());
        assertEquals(1500, savingAccount1.getBalance(), 0.001);

        assertEquals(4, savingAccount2.getId());
        assertEquals(800, savingAccount2.getBalance(), 0.001);

        // Intentionally fail the test to see the output
        //assert false : "Intentional test failure";
    }
}
