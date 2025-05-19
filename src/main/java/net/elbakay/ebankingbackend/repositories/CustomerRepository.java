package net.elbakay.ebankingbackend.repositories;

import net.elbakay.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer , Long> {
}
