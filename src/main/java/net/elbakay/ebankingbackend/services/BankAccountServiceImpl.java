package net.elbakay.ebankingbackend.services;

import lombok.AllArgsConstructor;
import net.elbakay.ebankingbackend.entities.BankAccount;
import net.elbakay.ebankingbackend.entities.CurrentAccount;
import net.elbakay.ebankingbackend.entities.Customer;
import net.elbakay.ebankingbackend.entities.SavingAccount;
import net.elbakay.ebankingbackend.exceptions.CustomerNotFoundException;
import net.elbakay.ebankingbackend.repositories.AccountOperationRepository;
import net.elbakay.ebankingbackend.repositories.BankAccountRepository;
import net.elbakay.ebankingbackend.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
//@Log4j journalisation api: slf4j


public class BankAccountServiceImpl implements BankAccountService{

    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private AccountOperationRepository accountOperationRepository;
    //Logger log= LoggerFactory.getLogger(this.getClass().getName());


    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Saving new Customer");

        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException {

        Customer customer =  customerRepository.findById(customerId).orElse(null);
        if(customer==null)
            throw new CustomerNotFoundException("customer not found");

        CurrentAccount currentAccount=new CurrentAccount();


        currentAccount.setId(UUID.randomUUID().toString());
        currentAccount.setCreatedDate(new Date());
        currentAccount.setBalance(initialBalance);
        currentAccount.setCustomer(customer);
        currentAccount.setOverDraft(overDraft);
        CurrentAccount savedBankAccount = bankAccountRepository.save(currentAccount);
        return savedBankAccount;

    }

    @Override
    public CurrentAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException {

        Customer customer =  customerRepository.findById(customerId).orElse(null);
        if(customer==null)
            throw new CustomerNotFoundException("customer not found");

        CurrentAccount currentAccount=new CurrentAccount();


        currentAccount.setId(UUID.randomUUID().toString());
        currentAccount.setCreatedDate(new Date());
        currentAccount.setBalance(initialBalance);
        currentAccount.setCustomer(customer);
        currentAccount.setOverDraft(overDraft);
        CurrentAccount savedBankAccount = bankAccountRepository.save(currentAccount);
        return savedBankAccount;
    }


    @Override
    public List<Customer> listCustomers() {
        return null;
    }

    @Override
    public BankAccount getBankAccount(String accountId) {
        return null;
    }

    @Override
    public void debit(String accountId, double amount, String description) {

    }

    @Override
    public void credit(String accountId, double amount, String description) {

    }

    @Override
    public void transfer(String accountIdSource, String accountIdDestination, double amount) {

    }
}
