package pl.dmagnuckibankapp.service;

import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.enums.Currency;
import pl.dmagnuckibankapp.model.PaymentCard;

@Service
public interface TransactionService {
    void currencyExchange(double amount, Currency baseCurrency, Currency targetCurrency);

    // wymiana waluty
    void deposit(String accountName, double amount); // przelewanie pieniędzy na konto

    void withdrawal(PaymentCard card, String pin, double amount); // wyciąganie pieniędzy z bankomatu

    void transfer(String accountNumber, double amount); // przelewanie pieniędzy na inne konto

    void payment(String accountNumber, double amount); /* tutaj bardziej mi chodzi o to, że
        transfer, możemy zrobić właścicielowi mieszkania, jako tradycyjny transfer, a payment, to zapłata za cos,
        np. w internecie, przez google pay, apple pay, paypal, itp. */

    void loan(String accountNumber, double amount); // branie kredytu

    void interestTransactions(String accountNumber, double amount);

    // Naliczanie i wypłacanie odsetek od depozytów, pożyczek i innych produktów finansowych.
    void internalTransfer(double amount, String originalAccount, String destinationAccount);
    // przelew na inny własny rachunek
}

