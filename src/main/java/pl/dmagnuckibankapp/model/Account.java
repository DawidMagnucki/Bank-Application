package pl.dmagnuckibankapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private String accountName;

    @ManyToOne
    private Client client;

    public Account(Long id, String accountNumber, String accountName) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    public Account() {
    }

}
