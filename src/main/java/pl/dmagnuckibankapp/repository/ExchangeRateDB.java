package pl.dmagnuckibankapp.repository;

import pl.dmagnuckibankapp.enums.Currency;
import pl.dmagnuckibankapp.exception.MySQLException;
import pl.dmagnuckibankapp.exception.NoExchangeRateException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRateDB {
    private Map<String, Map<String, Double>> exchangeRates;

    public ExchangeRateDB() throws MySQLException {
        this.exchangeRates = new HashMap<>();
//        initializeExchangeRatesFromDatabase();
    }

    private void initializeExchangeRatesFromDatabase() throws MySQLException {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root", "root", "1234");

            String query = "SELECT * FROM currencies";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String baseCurrency = resultSet.getString("base_currency");
                String targetCurrency = resultSet.getString("target_currency");
                double rate = resultSet.getDouble("exchange_rate");

                exchangeRates.computeIfAbsent(baseCurrency, k -> new HashMap<>());
                exchangeRates.get(baseCurrency).put(targetCurrency, rate);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException exception) {
            throw new MySQLException("Error while retrieving data from the database", exception);
        }
    }

    public double getExchangeRate(String baseCurrency, String targetCurrency) {
        if (exchangeRates.containsKey(baseCurrency) && exchangeRates.get(baseCurrency).containsKey(targetCurrency)) {
            return exchangeRates.get(baseCurrency).get(targetCurrency);
        } else {
            throw new NoExchangeRateException();
        }
    }

    public double getExchangeRateFromDatabase(Currency baseCurrency, Currency targetCurrency) throws NoExchangeRateException {
        String baseCurrencyCode = baseCurrency.name();
        String targetCurrencyCode = targetCurrency.name();

        if (exchangeRates.containsKey(baseCurrencyCode) && exchangeRates.get(baseCurrencyCode).containsKey(targetCurrencyCode)) {
            return exchangeRates.get(baseCurrencyCode).get(targetCurrencyCode);
        } else {
            throw new NoExchangeRateException("No exchange rate for the currencies listed.");
        }
    }

}
