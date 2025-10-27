package flower.store.payment;

import org.springframework.stereotype.Component;

@Component
public class CreditCardStrategy implements Payment {
    @Override
    public boolean pay(double amount) {
        return true; 
    }
    @Override
    public String getMethodName() { return "Credit Card"; }
}