package pl.dmagnuckibankapp.exception;

public class CrudOperationRequestException extends RuntimeException{

    public CrudOperationRequestException (String message){
        super(message);
    }
}
