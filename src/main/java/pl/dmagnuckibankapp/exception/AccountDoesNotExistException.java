package pl.dmagnuckibankapp.exception;

public class AccountDoesNotExistException extends RuntimeException {

    private static final String MESSAGE = "Account does not exist";

    public AccountDoesNotExistException() {
        super(MESSAGE);
    }

    public AccountDoesNotExistException(String message){
        super(message);
    }


}
