package pl.dmagnuckibankapp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CurrencyDto {

    private long Id;
    private String name;
    private String currencyCode;
    private double value;
}
