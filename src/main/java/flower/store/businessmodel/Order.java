package flower.store.businessmodel;

import lombok.Getter;

import java.util.List;

@Getter
public class Order {
    private List<Item> items;
    private double totalPrice;

    public Order(List<Item> items) {
        this.items = items;
        this.totalPrice = items.stream().mapToDouble(Item::getPrice).sum();
    }
    
}