package pl.dmagnuckibankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmagnuckibankapp.dto.AccountDto;
import pl.dmagnuckibankapp.service.AccountService;

@RequestMapping("/accounts")
@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public void createAccount(@RequestBody AccountDto accountDto) {
        // TODO: Dodaj odpowiedni kod obsługi dla createAccount
        accountService.createAccount(accountDto);
    }
    @GetMapping("/get")
    public ResponseEntity<AccountDto> getAccount(@RequestBody String accountNumber) {
        // TODO: Dodaj odpowiedni kod obsługi dla getAccount
        accountService.getAccount(accountNumber);
    }
    @PutMapping("/update")
    public void updateAccount(@RequestBody AccountDto accountDto, String accountName) {
        // TODO: Dodaj odpowiedni kod obsługi dla updateAccount
        accountService.updateAccount(accountDto,accountName);
    }
    @DeleteMapping("/delete")
    public void deleteAccount(@RequestBody AccountDto accountDto) {
        // TODO: Dodaj odpowiedni kod obsługi dla deleteAccount
        accountService.deleteAccount(accountDto);
    }
}
