package org.example.store;

import org.example.account.AccountManager;
import org.example.account.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;


public class StoreTest {

    @Test
    public void givenProductWithPositiveQuantityAndCustomerWithSufficientBalance_whenBuy_thenSuccess() {

        // Arrange
        Product product = new Product();
        product.setQuantity(4);

        Customer customer = new Customer();

        Store store = new StoreImpl(new AlwaysSuccessAccountManager());

        // Act
        store.buy(product, customer);

        // Assert
        Assertions.assertEquals(3, product.getQuantity());
    }
    @Test
    public void givenProductWithInsufficientQuantity_whenBuy_thenNoChange() {
        // Arrange
        Product product = new Product();
        product.setPrice(100);
        product.setQuantity(0);

        Customer customer = new Customer();
        customer.setBalance(200);

        AccountManager accountManager = Mockito.mock(AccountManager.class);


        Store store = new StoreImpl(accountManager);

        // Act
//        store.buy(product, customer);

        // Assert
        Assertions.assertThrows(RuntimeException.class,()->store.buy(product,customer));
        verify(accountManager, never()).withdraw(any(Customer.class), anyInt());
    }
    @Test
    public void givenProductWithPositiveQuantityAndCustomerWithInsufficientBalance_whenBuy_thenNoChange() {
        // Arrange
        Product product = new Product();
        product.setPrice(100);
        product.setQuantity(4);

        Customer customer = new Customer();
        customer.setBalance(50);

        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(customer, 100)).thenReturn("insufficient account balance");

        Store store = new StoreImpl(accountManager);

        // Act


        // Assert
        Assertions.assertThrows(RuntimeException.class, ()-> store.buy(product, customer));
//        verify(accountManager, never()).withdraw(any(Customer.class), anyInt());
    }

    @Test
    public void givenProductWithNegativeQuantity_whenBuy_thenNoChange() {
        // Arrange
        Product product = new Product();
        product.setPrice(100);
        product.setQuantity(-1);

        Customer customer = new Customer();
        customer.setBalance(200);

        AccountManager accountManager = mock(AccountManager.class);

        Store store = new StoreImpl(accountManager);

        // Act
//        store.buy(product, customer);

        // Assert
        Assertions.assertThrows(RuntimeException.class, ()->store.buy(product,customer));
//        verify(accountManager, never()).withdraw(any(Customer.class), anyInt());
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
