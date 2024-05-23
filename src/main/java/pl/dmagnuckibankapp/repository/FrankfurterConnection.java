package pl.dmagnuckibankapp.repository;

import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FrankfurterConnection {

    public String getLatest() {
        RestClient restClient = RestClient.create();
        return restClient.get()
                .uri("https://api.frankfurter.app/latest")
                .retrieve()
                .body(String.class);
    }

    public String getLatestFromCurrency(String currencyCode) {
        RestClient restClient = RestClient.create();
        return restClient.get()
                .uri("https://api.frankfurter.app/latest?from=" + currencyCode)
                .retrieve()
                .body(String.class);
    }

    public String getRatesToSpecifiedCurrencies(String currencies) {
        RestClient restClient = RestClient.create();
        String formattedCurrencies = formatCurrencies(currencies); // Validate and format input
        if (formattedCurrencies.isEmpty()) {
            return "Invalid input format. Every next currency should be introduced followed by comma, e.g. EUR,USD,GBP"; // Or throw an exception
        }
        return restClient.get()
                .uri("https://api.frankfurter.app/latest?to=" + formattedCurrencies)
                .retrieve()
                .body(String.class);
    }

    private String formatCurrencies(String currencies) {
        String[] currencyArray = currencies.split(",");
        StringBuilder formattedCurrencies = new StringBuilder();
        for (String currency : currencyArray) {
            String trimmedCurrency = currency.trim();
            if (isValidCurrency(trimmedCurrency)) {
                formattedCurrencies.append(trimmedCurrency).append(",");
            } else {
                return "";
            }
        }
        if (formattedCurrencies.length() > 0) {
            formattedCurrencies.setLength(formattedCurrencies.length() - 1);
        }
        return formattedCurrencies.toString();
    }

    private boolean isValidCurrency(String currency) {
        return currency.length() == 3;
    }

    public String getHistoricalRates(String date) {
        RestClient restClient = RestClient.create();
        if (!isDate(date)) {
            throw new RuntimeException("Invalid date format. Please use following format: YYYY-MM-DD, e.g. 2000-05-15");
        }
        return restClient.get()
                .uri("https://api.frankfurter.app/" + date)
                .retrieve()
                .body(String.class);
    }

    private boolean isDate(String date) {
        try {
            LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public String getHistoricalRatesForGivenPeriod(String startPeriod, String endPeriod) {
        RestClient restClient = RestClient.create();
        if (!isDate(startPeriod) || !isDate(endPeriod)) {
            throw new RuntimeException("Invalid date format. Please use following format: YYYY-MM-DD, e.g. 2000-05-15");
        }
        return restClient.get()
                .uri("https://api.frankfurter.app/" + startPeriod + ".." + endPeriod)
                .retrieve()
                .body(String.class);
    }

    public String getHistoricalRatesUpToToday(String startPeriod) {
        RestClient restClient = RestClient.create();
        if (!isDate(startPeriod)) {
            throw new RuntimeException("Invalid date format. Please use following format: YYYY-MM-DD, e.g. 2000-05-15");
        }
        return restClient.get()
                .uri("https://api.frankfurter.app/" + startPeriod + "..")
                .retrieve()
                .body(String.class);
    }

    public String getHistoricalRatesUpToTodayWithSpecificCurrency(String startPeriod, String currency) {
        RestClient restClient = RestClient.create();
        if (!isDate(startPeriod)) {
            throw new RuntimeException("Invalid date format. Please use following format: YYYY-MM-DD, e.g. 2000-05-15");
        } else {
            if (!isValidCurrency(currency)) {
                throw new RuntimeException("Invalid currency format. Please enter 3 letter format, e.g. EUR");
            }
            return restClient.get()
                    .uri("https://api.frankfurter.app/" + startPeriod + "..?to=" + currency)
                    .retrieve()
                    .body(String.class);
        }
    }

    public String convertCurrency(double amount, String fromCurrency, String toCurrency) {
        RestClient restClient = RestClient.create();
        String url = UriComponentsBuilder.fromHttpUrl("https://api.frankfurter.app/latest")
                .queryParam("amount", amount)
                .queryParam("from", fromCurrency)
                .queryParam("to", toCurrency)
                .toUriString();

        return restClient.get()
                .uri(url)
                .retrieve()
                .body(String.class);
    }

    public String getCurrenciesList() {
        RestClient restClient = RestClient.create();
        return restClient.get()
                .uri("https://api.frankfurter.app/currencies")
                .retrieve()
                .body(String.class);
    }


}



