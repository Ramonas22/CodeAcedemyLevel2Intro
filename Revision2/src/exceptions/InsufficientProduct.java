package exceptions;

public class InsufficientProduct extends Exception{
    Integer remainder;

    public InsufficientProduct(Integer remainder) {
        this.remainder = remainder;
    }

    public InsufficientProduct(String message, Integer remainder) {
        super(message);
        this.remainder = remainder;
    }

    public Integer getRemainder() {
        return remainder;
    }
}
