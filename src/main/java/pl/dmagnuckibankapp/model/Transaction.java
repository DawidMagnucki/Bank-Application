package pl.dmagnuckibankapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.dmagnuckibankapp.dto.AccountDto;
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
    private BigDecimal amount;
    private String recipient;
    private String sender;
    private String title;

    public TransactionDto toDto() {
        return TransactionDto.builder()
                .amount(amount)
                .recipient(recipient)
                .sender(sender)
                .title(title)
                .build();
    }
}
