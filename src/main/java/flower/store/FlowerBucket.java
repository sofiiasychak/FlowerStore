package flower.store;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket {
    private List<FlowerPack> flowerPacks = new ArrayList<>();
    
    public List<FlowerPack> getFlowerPacks() {
        return flowerPacks;
    }
    
    public void add(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }
    
    public double getPrice() {
        double totalPrice = 0;
        for (FlowerPack pack : flowerPacks) {
            totalPrice += pack.getPrice();
        }
        return totalPrice;
    }
}
//slava ukraini