package pl.dmagnuckibankapp.dto;

import lombok.*;
import pl.dmagnuckibankapp.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDto {

    private LocalDateTime timestamp;
    private BigDecimal amount;

    public Transaction toEntity() {
        return Transaction.builder()
                .timestamp(timestamp)
                .amount(amount)
                .build();
    }
}
