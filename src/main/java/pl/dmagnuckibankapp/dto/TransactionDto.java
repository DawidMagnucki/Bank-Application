package pl.dmagnuckibankapp.dto;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dmagnuckibankapp.model.Transaction;

import java.math.BigDecimal;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionDto {

    @Positive (message = "Amount must be over 0.00")
    private BigDecimal amount;
    private String recipient;
    private String sender;
    private String title;

    public Transaction toEntity() {
        return Transaction.builder()
                .amount(amount)
                .recipient (recipient)
                .sender (sender)
                .title (title)
                .build();
    }
}
