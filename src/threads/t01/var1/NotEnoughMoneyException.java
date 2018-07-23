package threads.t01.var1;

public class NotEnoughMoneyException extends RuntimeException {
    public NotEnoughMoneyException() {
        System.out.println("Not enough money!");
    }
}
