package net.elbakay.ebankingbackend.repositories;

import net.elbakay.ebankingbackend.entities.AccountOperation;
import net.elbakay.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
}
