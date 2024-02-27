package pl.dmagnuckibankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.dmagnuckibankapp.model.Admin;

public interface AdminRepository extends JpaRepository <Admin, Long> {


    Admin findByIndexNumber(String indexNumber);
}
