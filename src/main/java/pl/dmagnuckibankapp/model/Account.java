package pl.dmagnuckibankapp.model;

import jakarta.persistence.*;
import lombok.*;
import pl.dmagnuckibankapp.dto.AccountDto;
import pl.dmagnuckibankapp.dto.TransactionDto;
import pl.dmagnuckibankapp.enums.AccountType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private String accountName;
    private AccountType accountType;
    @OneToMany
    private List<Transaction> transactions;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Client client;

    public Account(Long id, String accountNumber, String accountName) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
    }

    public AccountDto toDto() {
//        List<TransactionDto> transactionDtos = new ArrayList<>();
//        for (Transaction transaction : transactions) {
//            transactionDtos.add(transaction.toDto());
//        }
        return AccountDto.builder()
                .accountNumber(accountNumber)
                .balance(balance)
                .clientDto(client.toDto())
//                .transactionDtos(transactionDtos)
                .build();
    }
}
