package pl.dmagnuckibankapp.service;

import pl.dmagnuckibankapp.dto.AccountDto;

public interface AccountService {
    void createAccount (AccountDto accountDto);

    AccountDto getAccount (String accountNumber);

    void updateAccount (AccountDto accountDto, String accountName);

    void deleteAccount (AccountDto accountDto);
}
