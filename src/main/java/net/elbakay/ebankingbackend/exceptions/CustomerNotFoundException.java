package net.elbakay.ebankingbackend.exceptions;
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
       super(message);
    }
}
