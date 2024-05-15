package pl.dmagnuckibankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmagnuckibankapp.model.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

}
