package dev.n1t.exception;

public class StockNotFoundException extends RuntimeException{

public StockNotFoundException(Long stockId){
    super(String.format("User with email %l not found", stockId));


};
}
