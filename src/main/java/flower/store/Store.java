package flower.store;
import java.util.ArrayList;
import java.util.List;

public class Store {
    
    private List<FlowerBucket> buckets = new ArrayList<>();

    public void addBucket(FlowerBucket bucket) {
        buckets.add(bucket);
    }


    public List<FlowerBucket> search(Specification spec) {
        List<FlowerBucket> foundBuckets = new ArrayList<>();
        
        for (FlowerBucket bucket : buckets) {
            if (spec.isSatisfiedBy(bucket)) {
                foundBuckets.add(bucket);
            }
        }
        return foundBuckets;
    }
}