
package pl.dmagnuckibankapp.exception;
public class MySQLException extends Exception {
    public MySQLException(String message) {
        super(message);
    }

    public MySQLException(String message, Throwable cause) {
        super(message, cause);
    }
}