package pl.dmagnuckibankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.dmagnuckibankapp.dto.AccountDto;
import pl.dmagnuckibankapp.exception.CrudOperationRequestException;
import pl.dmagnuckibankapp.service.AccountService;

@RestController
public class AccountController {

    private AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping ("/createAccount")
    public void createAccount (@RequestBody AccountDto accountDto){
        try {
        // TODO: Dodaj odpowiedni kod obsługi dla createAccount
            System.out.println(accountDto);
        } catch (CrudOperationRequestException e){
            System.err.println("Error while processing request. Please try again." + e.getMessage());
        }
    }
    @PostMapping ("/getAccount")
    public ResponseEntity<AccountDto> getAccount(@RequestBody String accountNumber) {
        try {
            // TODO: Dodaj odpowiedni kod obsługi dla getAccount
            AccountDto accountDto = null;
            return ResponseEntity.ok(accountDto);
        } catch (CrudOperationRequestException e) {
            System.err.println("Error while processing request. Please try again." + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping ("/updateAccount")
    public void updateAccount (@RequestBody AccountDto accountDto, String accountName){
        try {
            // TODO: Dodaj odpowiedni kod obsługi dla updateAccount
            System.out.println(accountDto);
        } catch (CrudOperationRequestException e){
            System.err.println("Error while processing request. Please try again." + e.getMessage());
        }
    }
    @PostMapping ("/deleteAccount")
    public void deleteAccount (@RequestBody AccountDto accountDto){
        try {
            // TODO: Dodaj odpowiedni kod obsługi dla deleteAccount
            System.out.println(accountDto);
        } catch (CrudOperationRequestException e){
            System.err.println("Error while processing request. Please try again." + e.getMessage());
        }
    }
}
