package pl.dmagnuckibankapp.repository;

import pl.dmagnuckibankapp.exception.MySQLException;

import java.sql.*;

public class CurrenciesDB {
    public void retrieveCurrencies() throws MySQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String user = "root";
        String password = "1234";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM bank_app_currencies.currencies")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String stateOrTerritory = resultSet.getString("State or Territory");
                String currency = resultSet.getString("Currency");
                String symbolOrAbbreviation = resultSet.getString("Symbol or Abbreviation");
                String isoCode = resultSet.getString("ISO Code");
                String fractionalUnit = resultSet.getString("Fractional Unit");
                String numberToBasic = resultSet.getString("Number to Basic");

                System.out.println("ID: " + id + ", State or Territory: " + stateOrTerritory +
                        ", Currency: " + currency + ", Symbol or Abbreviation: " + symbolOrAbbreviation +
                        ", ISO Code: " + isoCode + ", Fractional Unit: " + fractionalUnit +
                        ", Number to Basic: " + numberToBasic);
            }

        } catch (SQLException exception) {
            throw new MySQLException("Error while retrieving data from database", exception);
        }
    }
}