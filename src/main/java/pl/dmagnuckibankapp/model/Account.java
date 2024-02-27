package pl.dmagnuckibankapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private String accountName;

    public Account(Long id, String accountNumber, String accountName) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    public Account() {
    }
//    private AccountType accountType;
//    private double balance;
//    private Client client;
//    private Currency currency;
//    private AccountStatus status;
//    private Date dateOfCreation;
//    private TransactionHistory transactionHistory;
//    private double creditLimit;
//    private String linkedCards;
//    private double transactionLimits;

}
