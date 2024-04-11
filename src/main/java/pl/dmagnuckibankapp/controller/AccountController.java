package pl.dmagnuckibankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmagnuckibankapp.dto.AccountDto;
import pl.dmagnuckibankapp.service.AccountService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/account")
@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public void createAccount(@RequestBody AccountDto accountDto) {
        accountService.create(accountDto);
    }

    @GetMapping("/get/{accountNumber}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable String accountNumber) {
        AccountDto accountDto = accountService.getDetails(accountNumber);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping ("/all")
    public ResponseEntity <List <AccountDto>> getAccounts (){
        List<AccountDto> accountDtos = accountService.getAll();
        return ResponseEntity.ok(accountDtos);
    }

    @PutMapping("/update/{accountNumber}")
    public void updateAccount(@RequestBody AccountDto accountDto, @PathVariable String accountNumber) {
        accountService.update(accountNumber, accountDto);
    }

    @DeleteMapping("/delete")
    public void deleteAccount(@RequestBody AccountDto accountDto) {
        accountService.delete(accountDto.getAccountNumber());
    }
}
