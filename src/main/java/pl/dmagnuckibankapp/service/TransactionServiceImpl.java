package pl.dmagnuckibankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.dto.TransactionDto;
import pl.dmagnuckibankapp.model.Transaction;
import pl.dmagnuckibankapp.repository.TransactionRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionDto create(TransactionDto transactionDto) {
        Transaction transaction = Transaction.builder()

                .amount(transactionDto.getAmount())
                .recipient(transactionDto.getRecipient())
                .sender(transactionDto.getSender())
                .title(transactionDto.getTitle())
                .build();
        return transactionRepository.save(transaction).toDto();
    }

    @Override
    public TransactionDto retrieve(String id) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(Long.valueOf(id));
        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
            return TransactionDto.builder()
                    .amount(transaction.getAmount())
                    .recipient(transaction.getRecipient())
                    .sender(transaction.getSender())
                    .title(transaction.getTitle())
                    .build();
        } else {
            throw new NoSuchElementException("Transaction not found with id: " + id);
        }
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
    public TransactionDto update(String id, TransactionDto transactionDto) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(Long.valueOf(id));
        if (optionalTransaction.isPresent()) {
            Transaction transaction = optionalTransaction.get();
                transaction.setAmount(transactionDto.getAmount());
                transaction.setRecipient(transactionDto.getRecipient());
                transaction.setSender(transactionDto.getSender());
                transaction.setTitle(transactionDto.getTitle());
                return transactionRepository.save(transaction).toDto();
            } else {
                throw new NoSuchElementException("Transaction not found with id: " + id);
            }
        }

    @Override
    public boolean delete(String id) {
        if (transactionRepository.existsById(Long.valueOf(id))) {
            transactionRepository.deleteById(Long.valueOf(id));
            return true;
        }
        return false;
    }
}
