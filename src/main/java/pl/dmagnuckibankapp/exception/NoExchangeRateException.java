package pl.dmagnuckibankapp.exception;

public class NoExchangeRateException extends IllegalArgumentException {

    public NoExchangeRateException() {
        super("No exchange rate for the currencies listed.");
    }

    public NoExchangeRateException(String message) {
        super(message);
    }
}