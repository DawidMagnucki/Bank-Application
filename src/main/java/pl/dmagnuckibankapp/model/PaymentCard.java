package pl.dmagnuckibankapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dmagnuckibankapp.enums.CreditCardProvider;
import pl.dmagnuckibankapp.enums.CreditCardType;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentCard {

    private CreditCardProvider creditCardProvider;
    private String cardNumber;
    private String expirationDate;
    private String cvc;
    private String ownerName;
    private CreditCardType creditCardType;
    private String pin;

    public PaymentCard(CreditCardProvider creditCardProvider, String cardNumber, String expirationDate, String cvc,
                       String ownerName, CreditCardType creditCardType, String pin) {
        this.creditCardProvider = creditCardProvider;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvc = cvc;
        this.ownerName = ownerName;
        this.creditCardType = creditCardType;
        this.pin = pin;
    }

    public CreditCardProvider getCreditCardProvider() {
        return creditCardProvider;
    }

    public void setCreditCardProvider(CreditCardProvider creditCardProvider) {
        this.creditCardProvider = creditCardProvider;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public CreditCardType getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(CreditCardType creditCardType) {
        this.creditCardType = creditCardType;
    }

    public void setExpirationDate(String expirationDate) {
        if (isValidExpirationDate(expirationDate)) {
            this.expirationDate = expirationDate;
        } else {
            throw new IllegalArgumentException("Invalid expiration date format. Please use MM/YY.");
        }
    }

    private boolean isValidExpirationDate(String expirationDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            LocalDate.parse("01/" + expirationDate, formatter);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
