package pl.dmagnuckibankapp.dto;

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

    private String transactionId;
    private BigDecimal amount;
    private AccountDto recipient;
    private AccountDto sender;
    private String title;

    public Transaction toEntity() {
        return Transaction.builder()
                .transactionId(transactionId)
                .amount(amount)
                .recipient (recipient.toEntity())
                .sender (sender.toEntity())
                .title (title)
                .build();
    }
}
