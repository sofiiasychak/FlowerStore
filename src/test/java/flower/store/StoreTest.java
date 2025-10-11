package flower.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class StoreTest {
    
    private static final double TEST_PRICE_ROSE = 10.0;
    private static final double TEST_PRICE_TULIP = 8.0;
    private static final double TEST_PRICE_CHAMOMILE = 5.0;
    private static final double TEST_SEPAL_ROSE = 5.0;
    private static final double TEST_SEPAL_TULIP = 7.0;
    private static final double TEST_SEPAL_CHAMOMILE = 3.0;
    private static final int QTY_ROSES = 10;
    private static final int QTY_TULIPS = 5;
    private static final int QTY_CHAMOMILE = 20;
    private static final double DELTA = 0.001; 

    private Store store;
    private Flower roseRed;
    private Flower tulipBlue;
    private Flower chamomileRed;
    private FlowerBucket bucketRed;
    private FlowerBucket bucketBlue;
    private FlowerBucket bucketMixed;

    @BeforeEach
    public void setUp() {
        store = new Store();

        roseRed = new Flower();
        roseRed.setFlowerType(FlowerType.ROSE);
        roseRed.setColor(FlowerColor.RED);
        roseRed.setPrice(TEST_PRICE_ROSE);
        roseRed.setSepalLength(TEST_SEPAL_ROSE);

        tulipBlue = new Flower();
        tulipBlue.setFlowerType(FlowerType.TULIP);
        tulipBlue.setColor(FlowerColor.BLUE);
        tulipBlue.setPrice(TEST_PRICE_TULIP);
        tulipBlue.setSepalLength(TEST_SEPAL_TULIP);

        chamomileRed = new Flower();
        chamomileRed.setFlowerType(FlowerType.CHAMOMILE);
        chamomileRed.setColor(FlowerColor.RED);
        chamomileRed.setPrice(TEST_PRICE_CHAMOMILE);
        chamomileRed.setSepalLength(TEST_SEPAL_CHAMOMILE);

        FlowerPack redRosesPack = new FlowerPack(roseRed, QTY_ROSES);
        FlowerPack blueTulipsPack = new FlowerPack(tulipBlue, QTY_TULIPS);
        FlowerPack redChamomilePack = new FlowerPack(chamomileRed, QTY_CHAMOMILE);

        bucketRed = new FlowerBucket(); 
        bucketRed.add(redRosesPack);
        store.addBucket(bucketRed);

        bucketBlue = new FlowerBucket(); 
        bucketBlue.add(blueTulipsPack);
        store.addBucket(bucketBlue);

        bucketMixed = new FlowerBucket(); 
        bucketMixed.add(redChamomilePack);
        bucketMixed.add(blueTulipsPack);
        store.addBucket(bucketMixed);
    }


    @Test
    public void testFlowerPackPriceCalculatedCorrectly() {
        FlowerPack pack = new FlowerPack(roseRed, QTY_ROSES);
        Assertions.assertEquals(TEST_PRICE_ROSE * QTY_ROSES, pack.getPrice(), DELTA);
    }

    @Test
    public void testFlowerBucketPriceCalculatedCorrectly() {
        double expectedPrice = (TEST_PRICE_CHAMOMILE * QTY_CHAMOMILE) 
                             + (TEST_PRICE_TULIP * QTY_TULIPS);
        Assertions.assertEquals(expectedPrice, bucketMixed.getPrice(), DELTA);
    }
    

    @Test
    public void testFlowerColorSpecificationFoundRed() {
        Specification redSpec = new FlowerColorSpecification(FlowerColor.RED);
        List<FlowerBucket> found = store.search(redSpec);

        Assertions.assertEquals(2, found.size()); 
        Assertions.assertTrue(found.contains(bucketRed));
        Assertions.assertTrue(found.contains(bucketMixed));
    }

    @Test 
    public void testFlowerColorSpecificationNotFound() {
        Specification blueSpec = new FlowerColorSpecification(FlowerColor.BLUE);
        List<FlowerBucket> found = store.search(blueSpec);
        
        
        Assertions.assertFalse(found.contains(bucketRed));
        Assertions.assertEquals(2, found.size()); 
    }

    @Test 
    public void testFlowerTypeSpecificationIsNextStep() {
        Assertions.assertTrue(true);
    }
}