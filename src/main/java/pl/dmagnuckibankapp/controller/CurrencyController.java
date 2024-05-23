package pl.dmagnuckibankapp.controller;

import org.springframework.web.bind.annotation.*;
import pl.dmagnuckibankapp.repository.FrankfurterConnection;

@RequestMapping("/currencies")
@RestController
public class CurrencyController {

    private final FrankfurterConnection frankfurterConnection;

    public CurrencyController() {
        this.frankfurterConnection = new FrankfurterConnection();
    }

    @GetMapping("/latest")
    public String getLatestRates() {
        return frankfurterConnection.getLatest();
    }

    @GetMapping(value = "/latest", params = "from")
    public String getRateInOtherCurrency(@RequestParam("from") String currencyCode) {
        return frankfurterConnection.getLatestFromCurrency(currencyCode);
    }

    @GetMapping(value = "/latest", params = "to")
    public String limitRatesToSpecifiedCurrencies(@RequestParam("to") String currencies) {
        return frankfurterConnection.getRatesToSpecifiedCurrencies(currencies);
    }

    @GetMapping("/historical/{date}")
    public String getHistoricalRates(@PathVariable String date) {
        return frankfurterConnection.getHistoricalRates(date);
    }

    @GetMapping("/historical/{startPeriod}/{endPeriod}")
    public String getHistoricalRatesForGivenPeriod(@PathVariable String startPeriod, @PathVariable String endPeriod) {
        return frankfurterConnection.getHistoricalRatesForGivenPeriod(startPeriod, endPeriod);
    }

    @GetMapping("/historical/{startPeriod}/to-today")
    public String getHistoricalRatesUpToToday(@PathVariable String startPeriod) {
        return frankfurterConnection.getHistoricalRatesUpToToday(startPeriod);
    }

    @GetMapping(value = "/historical/{startPeriod}", params = "to")
    public String getHistoricalRatesUpToTodayWithSpecificCurrency(@PathVariable String startPeriod, @RequestParam("to") String currency) {
        return frankfurterConnection.getHistoricalRatesUpToTodayWithSpecificCurrency(startPeriod, currency);
    }

    @GetMapping("/convert")
    public String convertCurrency(@RequestParam("amount") double amount, @RequestParam("from") String fromCurrency, @RequestParam("to") String toCurrency) {
        return frankfurterConnection.convertCurrency(amount, fromCurrency, toCurrency);
    }

    @GetMapping ("/all")
    public String getCurrencies() {
        return frankfurterConnection.getCurrenciesList();
    }
}
