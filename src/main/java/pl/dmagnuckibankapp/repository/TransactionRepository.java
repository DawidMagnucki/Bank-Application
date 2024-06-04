package pl.dmagnuckibankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmagnuckibankapp.model.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long> {

    Transaction findByTransactionId (String transactionId);
    void deleteByTransactionId (String transactionId);
    boolean existsByTransactionId (String transactionId);

}
