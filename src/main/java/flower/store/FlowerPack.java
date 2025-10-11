package flower.store;

import lombok.Getter;

@Getter
public class FlowerPack {
    private Flower flower;
    private int quantity;
    
    public double getPrice() {
        return flower.getPrice() * quantity;
    }
}
