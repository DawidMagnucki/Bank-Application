package pl.dmagnuckibankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.dto.TransactionDto;
import pl.dmagnuckibankapp.model.Transaction;
import pl.dmagnuckibankapp.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl (TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        Transaction transaction = Transaction.builder()
                .transactionId(transactionDto.getTransactionId())
                .amount(transactionDto.getAmount())
                .recipient(transactionDto.getRecipient().toEntity())
                .sender(transactionDto.getSender().toEntity())
                .title(transactionDto.getTitle())
                .build();
        return transactionRepository.save(transaction).toDto();
    }

    @Override
    public TransactionDto retrieve(String transactionId) {
        Transaction transaction = transactionRepository.findByTransactionId(transactionId);
                return TransactionDto.builder()
                .transactionId(transaction.getTransactionId())
                .amount(transaction.getAmount())
                .recipient(transaction.getRecipient().toDto())
                .sender(transaction.getSender().toDto())
                .title(transaction.getTitle())
                .build();
    }

    @Override
    public List<TransactionDto> retrieveAll() {
        return transactionRepository
                .findAll()
                .stream()
                .map(Transaction::toDto)
                .toList();
    }

    @Override
    public TransactionDto update(String transactionId, TransactionDto transactionDto) {
        Transaction transaction = transactionRepository.findByTransactionId(transactionId);
        transaction.setTransactionId(transactionDto.getTransactionId());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setRecipient(transactionDto.getRecipient().toEntity());
        transaction.setSender(transactionDto.getSender().toEntity());
        transaction.setTitle(transactionDto.getTitle());

        return transactionRepository.save(transaction).toDto();
    }

    @Override
    public boolean delete(String transactionId) {
        if (transactionRepository.existsByTransactionId(transactionId)){
            transactionRepository.deleteByTransactionId(transactionId);
            return true;
        }
        return false;
    }
}
