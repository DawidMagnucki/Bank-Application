package pl.dmagnuckibankapp.service;

import org.springframework.stereotype.Service;
import pl.dmagnuckibankapp.enums.Currency;
import pl.dmagnuckibankapp.exception.MySQLException;
import pl.dmagnuckibankapp.exception.NoExchangeRateException;
import pl.dmagnuckibankapp.model.PaymentCard;
import pl.dmagnuckibankapp.model.Transactions;
import pl.dmagnuckibankapp.repository.ExchangeRateDB;
@Service
public class TransactionService extends Transactions {
    private ExchangeRateDB exchangeRateDB;

    public TransactionService() throws MySQLException {
        this.exchangeRateDB = new ExchangeRateDB();
    }

    @Override
    public void currencyExchange(double amount, Currency baseCurrency, Currency targetCurrency) {
        try {
            double exchangeRate = exchangeRateDB.getExchangeRateFromDatabase(baseCurrency, targetCurrency);
            double exchangedAmount = amount * exchangeRate;

            System.out.println(amount + " " + baseCurrency + " exchanged to " +
                    exchangedAmount + " " + targetCurrency + " at exchange rate: " + exchangeRateDB);
        } catch (NoExchangeRateException e) {
            System.err.println(e.getMessage());
        }
    }


    @Override
    public void deposit(String accountName, double amount) {

    }

    @Override
    public void withdrawal(PaymentCard card, String pin, double amount) {

    }

    @Override
    public void transfer(String accountNumber, double amount) {

    }

    @Override
    public void payment(String accountNumber, double amount) {

    }

    @Override
    public void loan(String accountNumber, double amount) {

    }

    @Override
    public void interestTransactions(String accountNumber, double amount) {

    }

    @Override
    public void internalTransfer(double amount, String originalAccount, String destinationAccount) {

    }
}
