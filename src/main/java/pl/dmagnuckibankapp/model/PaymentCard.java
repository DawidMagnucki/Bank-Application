package pl.dmagnuckibankapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import pl.dmagnuckibankapp.enums.CreditCardProvider;
import pl.dmagnuckibankapp.enums.CreditCardType;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class PaymentCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private CreditCardProvider creditCardProvider;
    private String cardNumber;
    private String expirationDate;

//    private String cvc;
//    private String ownerName;
//    private CreditCardType creditCardType;
//    private String pin;

//    public PaymentCard(CreditCardProvider creditCardProvider, String cardNumber, String expirationDate, String cvc,
//                       String ownerName, CreditCardType creditCardType, String pin) {
//        this.creditCardProvider = creditCardProvider;
//        this.cardNumber = cardNumber;
//        this.expirationDate = expirationDate;
//        this.cvc = cvc;
//        this.ownerName = ownerName;
//        this.creditCardType = creditCardType;
//        this.pin = pin;
//    }

//    public void setExpirationDate(String expirationDate) {
//        if (isValidExpirationDate(expirationDate)) {
//            this.expirationDate = expirationDate;
//        } else {
//            throw new IllegalArgumentException("Invalid expiration date format. Please use MM/YY.");
//        }
//    }
//
//    private boolean isValidExpirationDate(String expirationDate) {
//        try {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
//            LocalDate.parse("01/" + expirationDate, formatter);
//            return true;
//        } catch (DateTimeException e) {
//            return false;
//        }
//    }
//
//    public String getPin() {
//        return pin;
//    }
//
//    public void setPin(String pin) {
//        this.pin = pin;
//    }

}
