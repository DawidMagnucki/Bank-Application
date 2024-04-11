package pl.dmagnuckibankapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dmagnuckibankapp.dto.TransactionDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    private Long id;
    private LocalDateTime timestamp;
    private BigDecimal amount;


    @ManyToOne
    private List<Account> accounts;

    public TransactionDto toDto() {
        return TransactionDto.builder()
                .timestamp(timestamp)
                .amount(amount)
                .build();
    }
}
