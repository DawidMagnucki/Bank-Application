package pl.dmagnuckibankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmagnuckibankapp.dto.AccountDto;
import pl.dmagnuckibankapp.service.AccountService;

@RequestMapping("/account")
@RestController
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public void createAccount(@RequestBody AccountDto accountDto) {
        accountService.createAccount(accountDto);
    }
    @GetMapping("/get/{accountNumber}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable String accountNumber) {
        AccountDto accountDto = accountService.getAccount(accountNumber);
        return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/update/{accountNumber}")
    public void updateAccount(@RequestBody AccountDto accountDto, @PathVariable String accountNumber) {
        accountService.updateAccount(accountDto,accountNumber);
    }
    @DeleteMapping("/delete")
    public void deleteAccount(@RequestBody AccountDto accountDto) {
        accountService.deleteAccount(accountDto);
    }
}
