package pl.dmagnuckibankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.dmagnuckibankapp.dto.TransactionDto;
import pl.dmagnuckibankapp.service.TransactionService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/transaction")
@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping ("/create")
    public String create (@RequestBody TransactionDto transactionDto){
        return String.valueOf(transactionDto);
    }

    @GetMapping ("/retrieve/{transactionId}")
    public ResponseEntity<TransactionDto> retrieve (@PathVariable String transactionId){
        TransactionDto transactionDto = transactionService.retrieve(transactionId);
        return ResponseEntity.ok(transactionDto);
    }

    @GetMapping ("/retrieve-all")
    public ResponseEntity<List<TransactionDto>> retrieveAll (){
        List<TransactionDto> transactionDtos = transactionService.retrieveAll();
        return ResponseEntity.ok(transactionDtos);
    }

    @PutMapping("/update/{transactionId}")
    public void update (@RequestBody TransactionDto transactionDto, @PathVariable String transactionId){
        transactionService.update(transactionId, transactionDto);
    }

    @DeleteMapping("/delete")
    public void delete (@RequestBody TransactionDto transactionDto){
        transactionService.delete(transactionDto.getTransactionId());
    }

}
