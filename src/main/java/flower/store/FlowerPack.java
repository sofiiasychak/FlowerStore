package flower.store;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
public class FlowerPack {
    private Flower flower;
    private int quantity;
    
    public double getPrice() {
        return flower.getPrice() * quantity;
    }
}
