package pl.dmagnuckibankapp.service;

import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.dto.AccountDto;
@Service
public class AccountServiceImpl implements AccountService{
    @Override
    public void createAccount(AccountDto accountDto) {
// TODO: Dodaj odpowiedni kod obsługi metody
    }

    @Override
    public AccountDto getAccount(String accountNumber) {
    // TODO: Dodaj odpowiedni kod obsługi metody
        return null;
    }
    @Override
    public void updateAccount(AccountDto accountDto, String accountName) {
// TODO: Dodaj odpowiedni kod obsługi metody
    }

    @Override
    public void deleteAccount(AccountDto accountDto) {
// TODO: Dodaj odpowiedni kod obsługi metody
    }
}
