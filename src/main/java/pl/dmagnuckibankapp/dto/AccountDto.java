package pl.dmagnuckibankapp.dto;

import lombok.*;
import pl.dmagnuckibankapp.enums.AccountType;
import pl.dmagnuckibankapp.model.Account;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountDto {

    private String accountNumber;
    private String accountName;
    private AccountType accountType;

}