package flower.store.businessmodel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import flower.store.FlowerColor; 
import flower.store.FlowerType; 

@Setter
@Getter
@ToString 
public class Flower implements Item { 
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

    
    @Override
    public String getDescription() {
        return "Flower (" + flowerType + ") with price " + price + " and color " + color;
    }
}