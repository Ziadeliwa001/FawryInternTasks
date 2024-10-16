package org.example.account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountManagerImplTest {
    private AccountManager accountManager;
    private Customer customer;

    @BeforeEach
    public void setUp() {
        accountManager = new AccountManagerImpl();
        customer = new Customer();
        customer.setBalance(1000);
        customer.setCreditAllowed(true);
        customer.setVip(false);
    }

    @Test
    public void testDeposit() {
        accountManager.deposit(customer, 500);
        assertEquals(1500, customer.getBalance());
    }

    @Test
    public void testWithdrawSuccess() {
        String result = accountManager.withdraw(customer, 500);
        assertEquals("success", result);
        assertEquals(500, customer.getBalance());
    }

    @Test
    public void testWithdrawInsufficientBalance() {
        customer.setCreditAllowed(false);
        String result = accountManager.withdraw(customer, 1500);
        assertEquals("insufficient account balance", result);
        assertEquals(1000, customer.getBalance());
    }

    @Test
    public void testWithdrawMaximumCreditExceeded() {
        String result = accountManager.withdraw(customer, 2500);
        assertEquals("maximum credit exceeded", result);
        assertEquals(1000, customer.getBalance());
    }

    @Test
    public void testWithdrawWithCredit() {
        String result = accountManager.withdraw(customer, 1500);
        assertEquals("success", result);
        assertEquals(-500, customer.getBalance());
    }

    @Test
    public void testWithdrawWithVipCredit() {
        customer.setVip(true);
        String result = accountManager.withdraw(customer, 2001);
        assertEquals("success", result);
        assertEquals(-1001, customer.getBalance());
    }
}
