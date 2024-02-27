package pl.dmagnuckibankapp.dto;

import lombok.*;
import pl.dmagnuckibankapp.enums.AccountType;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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