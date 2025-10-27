package flower.store;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Flower {
    private double sepalLength;
    private FlowerColor color;
    private double price;
    private FlowerType flowerType;
    
    public Flower(double price, double sepalLength) {
        this.price = price;
        this.sepalLength = sepalLength;
    }

    public String getColorCode() {
        return color.toString();
    }
}
