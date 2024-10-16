package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class StoreWithMockitoTest {

    @Test
    public void givenProductWithPositiveQuantityAndCustomerWithSufficientBalance_whenBuy_thenSuccess() {

        // Arrange
        Product product = new Product();
        product.setPrice(100);
        product.setQuantity(4);

        Customer customer = new Customer();

        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(customer, 80))
                .thenReturn("success");

        when(accountManager.withdraw(customer, 100))
                .thenReturn("success");

        Store store = new StoreImpl(accountManager);

        // Act
        store.buy(product, customer);

        // Assert
        Assertions.assertEquals(3, product.getQuantity());
        verify(accountManager).withdraw(customer, 100);
    }

    static class AlwaysSuccessAccountManager implements AccountManager {

        @Override
        public void deposit(Customer customer, int amount) {

        }

        @Override
        public String withdraw(Customer customer, int amount) {
            return "success";
        }
    }


}
