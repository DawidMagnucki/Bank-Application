package pl.dmagnuckibankapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dmagnuckibankapp.enums.AccountType;
import pl.dmagnuckibankapp.enums.Currency;
import pl.dmagnuckibankapp.enums.AccountStatus;
import pl.dmagnuckibankapp.service.TransactionHistory;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    private String accountNumber;
    private String accountName;
    private AccountType accountType;
    private double balance;
    private Client client;
    private Currency currency;
    private AccountStatus status;
    private Date dateOfCreation;
    private TransactionHistory transactionHistory;
    private double creditLimit;
    private String linkedCards;
    private double transactionLimits;

}
