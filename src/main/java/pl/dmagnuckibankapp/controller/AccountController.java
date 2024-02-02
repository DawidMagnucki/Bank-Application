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
        AccountDto accountDto = null;
        return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/update")
    public void updateAccount(@RequestBody AccountDto accountDto, String accountName) {
        // TODO: Dodaj odpowiedni kod obsługi dla updateAccount
        System.out.println(accountDto);
    }
    @DeleteMapping("/delete")
    public void deleteAccount(@RequestBody AccountDto accountDto) {
        // TODO: Dodaj odpowiedni kod obsługi dla deleteAccount
        System.out.println(accountDto);
    }
}
