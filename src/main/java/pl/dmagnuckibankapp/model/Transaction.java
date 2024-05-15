package pl.dmagnuckibankapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dmagnuckibankapp.dto.TransactionDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime timestamp;
    private BigDecimal amount;


    @ManyToOne
    private Account account;

    public TransactionDto toDto() {
        return TransactionDto.builder()
                .timestamp(timestamp)
                .amount(amount)
                .build();
    }
}
