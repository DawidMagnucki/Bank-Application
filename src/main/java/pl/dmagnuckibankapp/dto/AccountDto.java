package pl.dmagnuckibankapp.dto;

import lombok.*;
import pl.dmagnuckibankapp.enums.AccountType;
import pl.dmagnuckibankapp.model.Account;
import pl.dmagnuckibankapp.model.Client;
import pl.dmagnuckibankapp.model.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class AccountDto {

    private String accountNumber;
    private BigDecimal balance;
    private String accountName;
    private AccountType accountType;
    private ClientDto clientDto;
    private List<TransactionDto> transactionDtos;

    public Account toEntity() {
        List<Transaction> transactions = new ArrayList<>();
        for (TransactionDto transaction : transactionDtos) {
            transactions.add(transaction.toEntity());
        }
        return Account.builder()
                .accountNumber(accountNumber)
                .balance(balance)
                .client(clientDto.toEntity())
                .transactions(transactions)
                .build();
    }

}