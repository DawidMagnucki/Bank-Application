package pl.dmagnuckibankapp.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.dto.AccountDto;
import pl.dmagnuckibankapp.exception.AccountDoesNotExistException;
import pl.dmagnuckibankapp.model.Account;
import pl.dmagnuckibankapp.repository.AccountRepository;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(Account::toDto)
                .toList();
    }

    @Override
    public AccountDto getDetails(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).toDto();
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        Account account = accountDto.toEntity();
        return accountRepository.save(account).toDto();
    }

    @Override
    public AccountDto update(String accountNumber, AccountDto accountDto) {
        Account accountToUpdate = accountRepository.findByAccountNumber(accountNumber);

        if (accountToUpdate == null) {
            throw new AccountDoesNotExistException();
        }
        accountToUpdate.setAccountNumber(accountDto.getAccountNumber());
        accountToUpdate.setBalance(accountDto.getBalance());

        return accountRepository.save(accountToUpdate).toDto();
    }

    @Override
    @Transactional
    public boolean delete(String accountNumber) {
        if (accountRepository.existsByAccountNumber(accountNumber)) {
            accountRepository.deleteByAccountNumber(accountNumber);
            return true;
        }
        return false;
    }

    /*
    @Override
    public void createAccount(AccountDto accountDto) {
        Account account = Account.builder()
                .accountName(accountDto.getAccountName())
                .accountNumber(accountDto.getAccountNumber())
                .client(Client.builder()
                        .name(accountDto.getClientDto().getName())
                        .phoneNumber(accountDto.getClientDto().getPhoneNumber())
                        .indexNumber(accountDto.getClientDto().getIndexNumber())
                        .address(Address.builder()
                                .street(accountDto.getClientDto().getAddressDto().getStreet())
                                .houseNumber(accountDto.getClientDto().getAddressDto().getHouseNumber())
                                .build())
                        .build())
                .build();
        accountRepository.save(account);
    }

    @Override
    public AccountDto getAccount(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        return AccountDto.builder()
                .accountName(account.getAccountName())
                .accountNumber(account.getAccountNumber())
                .clientDto(ClientDto.builder()
                        .name(account.getClient().getName())
                        .phoneNumber(account.getClient().getPhoneNumber())
                        .indexNumber(account.getClient().getIndexNumber())
                        .addressDto(AddressDto.builder()
                                .street(account.getClient().getAddress().getStreet())
                                .houseNumber(account.getClient().getAddress().getHouseNumber())
                                .build())
                        .build())
                .build();
    }

    @Override
    public void updateAccount(AccountDto accountDto, String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        account.setAccountName(accountDto.getAccountName());

        ClientDto clientDto = accountDto.getClientDto();
        Client client = Client.builder()
                .name(clientDto.getName())
                .phoneNumber(clientDto.getPhoneNumber())
                .indexNumber(clientDto.getIndexNumber())
                .address(Address.builder()
                        .street(clientDto.getAddressDto().getStreet())
                        .houseNumber(clientDto.getAddressDto().getHouseNumber())
                        .build())
                .build();
        account.setClient(client);
        accountRepository.save(account);
    }

    @Override
    public void deleteAccount(AccountDto accountDto) {
        Account account = accountRepository.findByAccountNumber(accountDto.getAccountNumber());
        accountRepository.delete(account);
    }
*/

}