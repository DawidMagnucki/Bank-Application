package pl.dmagnuckibankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dmagnuckibankapp.enums.CreditCardProvider;
import pl.dmagnuckibankapp.enums.CreditCardType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentCardDto {

    private CreditCardProvider creditCardProvider;
    private String cardNumber;
    private String expirationDate;
    private String cvc;
    private String ownerName;
    private CreditCardType creditCardType;
    private String pin;

}
