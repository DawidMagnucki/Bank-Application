package pl.dmagnuckibankapp.controller;

import org.springframework.web.bind.annotation.*;
import pl.dmagnuckibankapp.repository.FrankfurterConnection;

@RequestMapping("/currency")
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
        return frankfurterConnection.getLatest(currencyCode);
    }

    @GetMapping(value = "/latest", params = "to")
    public String limitRatesToSpecifiedCurrencies(@RequestParam("to") String currencyCode) {
        return frankfurterConnection.getLatest(currencyCode);
    }

    @GetMapping("/{date}")
    public String getHistoricalRates(@PathVariable String date) {
        return frankfurterConnection.getByDate(date);
    }

    @GetMapping("/currencies")
    public String getCurrencies() {
        return frankfurterConnection.getLatest();
    }
}
