package net.elbakay.ebankingbackend.services;

import net.elbakay.ebankingbackend.entities.BankAccount;
import net.elbakay.ebankingbackend.entities.Customer;
import net.elbakay.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    public Customer saveCustomer (Customer customer);
        BankAccount saveCurrentBankAccount(double initialBalance ,double overDraft ,Long customerId) throws CustomerNotFoundException;
        BankAccount saveSavingBankAccount(double initialBalance ,double interestRate ,Long customerId) throws CustomerNotFoundException;

    List<Customer> listCustomers();
        BankAccount getBankAccount(String accountId);
        void debit(String accountId, double amount , String description);
        void credit(String accountId, double amount , String description);
        void transfer(String accountIdSource , String accountIdDestination , double amount);


}
