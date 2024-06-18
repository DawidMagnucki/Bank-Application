package pl.dmagnuckibankapp.service;

import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.dto.TransactionDto;
import pl.dmagnuckibankapp.enums.Currency;
import pl.dmagnuckibankapp.model.PaymentCard;

import java.util.List;

@Service
public interface TransactionService {
    TransactionDto create (TransactionDto transactionDto);
    TransactionDto retrieve (String id);
    List<TransactionDto> retrieveAll ();
    TransactionDto update (String id, TransactionDto transactionDto);
    boolean delete (String id);


}

