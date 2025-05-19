package net.elbakay.ebankingbackend.repositories;

import net.elbakay.ebankingbackend.entities.BankAccount;
import net.elbakay.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
