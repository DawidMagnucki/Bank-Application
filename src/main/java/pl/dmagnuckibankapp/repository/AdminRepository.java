package pl.dmagnuckibankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmagnuckibankapp.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByIndexNumber(String indexNumber);

    boolean existsByIndexNumber(String indexNumber);

    void deleteByIndexNumber(String indexNumber);
}
