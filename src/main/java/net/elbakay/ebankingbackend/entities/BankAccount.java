package net.elbakay.ebankingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.elbakay.ebankingbackend.enums.AccountStatus;

import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//singletable : les classes qui herite de cette classe vont etres stockés dans une seule table
@DiscriminatorColumn(name="TYPE" , length = 4 )
@Data
@AllArgsConstructor @NoArgsConstructor
public abstract class BankAccount {
    @Id
    private String id ;
    private double balance;
    private Date createdDate;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> accountOperations;
}
