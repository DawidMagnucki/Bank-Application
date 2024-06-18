package pl.dmagnuckibankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmagnuckibankapp.model.Transaction;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long> {


    Optional<Transaction> findById (Long id);
    void deleteById (Long id);
    boolean existsById (Long id);

}
