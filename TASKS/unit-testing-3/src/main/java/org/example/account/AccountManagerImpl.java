package org.example.account;

public class AccountManagerImpl implements AccountManager {
    private static final int MAX_CREDIT = 1000;
    @Override
    public void deposit(Customer customer, int amount) {
        customer.setBalance(customer.getBalance() + amount);
    }

    @Override
    public String withdraw(Customer customer, int amount) {
        int currentBalance = customer.getBalance();
        int newBalance = currentBalance - amount;

        System.out.println("Current Balance: " + currentBalance);
        System.out.println("Amount to Withdraw: " + amount);
        System.out.println("New Balance: " + newBalance);

        if (newBalance < 0) {
            if (!customer.isCreditAllowed()) {
                return "insufficient account balance";
            } else if (newBalance < -MAX_CREDIT && !customer.isVip()) {
                return "maximum credit exceeded";
            }
        }

        customer.setBalance(newBalance);
        return "success";
    }
}
