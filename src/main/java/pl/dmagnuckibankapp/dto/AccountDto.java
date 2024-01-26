package pl.dmagnuckibankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dmagnuckibankapp.enums.AccountType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountDto {

    private String accountNumber;
    private String accountName;
    private AccountType accountType;
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