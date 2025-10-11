package test.java.flower.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StoreTest {
    private Store store;
    private Flower roseRed;
    private Flower tulipBlue;
    private Flower chamomileRed;

    @BeforeEach
    public void setUp() {
        store = new Store();

        roseRed = new Flower();
        roseRed.setFlowerType(FlowerType.ROSE);
        roseRed.setColor(FlowerColor.RED);
        roseRed.setPrice(10.0);
        roseRed.setSepalLength(5.0);

        tulipBlue = new Flower();
        tulipBlue.setFlowerType(FlowerType.TULIP);
        tulipBlue.setColor(FlowerColor.BLUE);
        tulipBlue.setPrice(8.0);
        tulipBlue.setSepalLength(7.0);

        chamomileRed = new Flower();
        chamomileRed.setFlowerType(FlowerType.CHAMOMILE);
        chamomileRed.setColor(FlowerColor.RED);
        chamomileRed.setPrice(5.0);
        chamomileRed.setSepalLength(3.0);

        FlowerPack pack1 = new FlowerPack(roseRed, 10);
        FlowerPack pack2 = new FlowerPack(tulipBlue, 5);
        FlowerPack pack3 = new FlowerPack(chamomileRed, 20);

        FlowerBucket bucket1 = new FlowerBucket();
        bucket1.add(pack1);
        store.addBucket(bucket1);

        FlowerBucket bucket2 = new FlowerBucket(); 
        bucket2.add(pack2);
        store.addBucket(bucket2);

        FlowerBucket bucket3 = new FlowerBucket();
        bucket3.add(pack3);
        bucket3.add(pack2);
        store.addBucket(bucket3);
    }


    @Test
    public void testFlowerPackPrice() {
        FlowerPack pack = new FlowerPack(roseRed, 10);
        Assertions.assertEquals(100.0, pack.getPrice(), 0.001);
    }

    @Test
    public void testFlowerBucketPrice() {
        List<FlowerPack> packs = store.buckets.get(2).getFlowerPacks();
        
        double expectedPrice = (chamomileRed.getPrice() * 20) + (tulipBlue.getPrice() * 5);
        Assertions.assertEquals(expectedPrice, packs.get(0).getPrice() + packs.get(1).getPrice(), 0.001);
        Assertions.assertEquals(140.0, store.buckets.get(2).getPrice(), 0.001);
    }
    

    @Test
    public void testFlowerColorSpecification_Found() {
        Specification redSpec = new FlowerColorSpecification(FlowerColor.RED);
        List<FlowerBucket> found = store.search(redSpec);

        Assertions.assertEquals(2, found.size());
        Assertions.assertTrue(found.contains(store.buckets.get(0)));
        Assertions.assertTrue(found.contains(store.buckets.get(2)));
    }

    @Test
    public void testFlowerColorSpecification_NotFound() {
        FlowerColor green = FlowerColor.BLUE; 

        FlowerColorSpecification blueSpec = new FlowerColorSpecification(FlowerColor.BLUE);
        
        List<FlowerBucket> found = store.search(blueSpec);
        Assertions.assertEquals(2, found.size());

        Assertions.assertFalse(store.buckets.get(0).getFlowerPacks().stream()
                .anyMatch(p -> p.getFlower().getColor() == FlowerColor.BLUE));
    }

    @Test
    public void testFlowerTypeSpecification_Found() {
    }
}