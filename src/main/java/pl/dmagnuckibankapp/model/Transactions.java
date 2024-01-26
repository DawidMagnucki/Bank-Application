package pl.dmagnuckibankapp.model;

import pl.dmagnuckibankapp.enums.Currency;

public abstract class Transactions {
    public abstract void currencyExchange (double amount, Currency baseCurrency, Currency targetCurrency);
    // wymiana waluty
    public abstract void deposit (String accountName, double amount); // przelewanie pieniędzy na konto
    public abstract void withdrawal (PaymentCard card, String pin, double amount); // wyciąganie pieniędzy z bankomatu
    public abstract void transfer (String accountNumber, double amount); // przelewanie pieniędzy na inne konto
    public abstract void payment (String accountNumber, double amount); /* tutaj bardziej mi chodzi o to, że
        transfer, możemy zrobić właścicielowi mieszkania, jako tradycyjny transfer, a payment, to zapłata za cos,
        np. w internecie, przez google pay, apple pay, paypal, itp. */
    public abstract void loan (String accountNumber, double amount); // branie kredytu
    public abstract void interestTransactions (String accountNumber, double amount);
    // Naliczanie i wypłacanie odsetek od depozytów, pożyczek i innych produktów finansowych.
    public abstract void internalTransfer (double amount, String originalAccount, String destinationAccount);
    // przelew na inny własny rachunek
}
