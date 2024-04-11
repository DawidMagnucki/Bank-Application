package pl.dmagnuckibankapp.service;

import pl.dmagnuckibankapp.dto.AccountDto;

import java.util.List;

public interface AccountService {

    /**
     * It should return all accounts that all available in our bank system
     *
     * @return accounts with all information
     */
    List<AccountDto> getAll();

    /**
     * It should return details of the specific account
     *
     * @param accountNumber of the account that we're looking for
     * @return account details
     */
    AccountDto getDetails(String accountNumber);

    /**
     * It should create an account
     *
     * @param accountDto to create
     * @return created account
     */
    AccountDto create(AccountDto accountDto);

    /**
     * It should update an account
     *
     * @param accountDto to update
     * @return updated account
     */
    AccountDto update(String accountNumber, AccountDto accountDto);

    /**
     * It should delete an account
     *
     * @param accountNumber to delete
     * @return true if account was successfully deleted
     */
    boolean delete(String accountNumber);
}
