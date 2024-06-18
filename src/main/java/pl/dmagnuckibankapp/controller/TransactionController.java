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
    public ResponseEntity<TransactionDto> create (@RequestBody TransactionDto transactionDto){
        TransactionDto savedTransaction = transactionService.create(transactionDto);
        return ResponseEntity.ok(savedTransaction);
    }

    @GetMapping ("/retrieve/{id}")
    public ResponseEntity<TransactionDto> retrieve (@PathVariable String id){
        TransactionDto transactionDto = transactionService.retrieve(id);
        return ResponseEntity.ok(transactionDto);
    }

    @GetMapping ("/retrieve-all")
    public ResponseEntity<List<TransactionDto>> retrieveAll (){
        List<TransactionDto> transactionDtos = transactionService.retrieveAll();
        return ResponseEntity.ok(transactionDtos);
    }

    @PutMapping("/update/{id}")
    public void update (@RequestBody TransactionDto transactionDto, @PathVariable String id){
        transactionService.update(id, transactionDto);
    }

    @DeleteMapping("/delete")
    public void delete (@RequestBody String id){
        transactionService.delete(id);
    }

}
