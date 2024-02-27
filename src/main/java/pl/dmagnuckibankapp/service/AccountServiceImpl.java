package pl.dmagnuckibankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.dto.AccountDto;
import pl.dmagnuckibankapp.model.Account;
import pl.dmagnuckibankapp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    @Override
    public void createAccount(AccountDto accountDto) {
        Account account = Account.builder().accountName(accountDto.getAccountName()).accountNumber(accountDto.getAccountNumber()).build();
        accountRepository.save(account);
    }
    @Override
    public AccountDto getAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        return AccountDto.builder().accountName(account.getAccountName()).accountNumber(account.getAccountNumber()).build();
    }
    @Override
    public void updateAccount(AccountDto accountDto, String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        account.setAccountName(accountDto.getAccountName());
        accountRepository.save(account);
    }
    @Override
    public void deleteAccount(AccountDto accountDto) {
        Account account = accountRepository.findByAccountNumber(accountDto.getAccountNumber());
        accountRepository.delete(account);
    }
}