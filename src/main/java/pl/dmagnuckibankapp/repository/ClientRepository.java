package pl.dmagnuckibankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmagnuckibankapp.model.Client;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {
    Client findByIndexNumber(String indexNumber);
}
