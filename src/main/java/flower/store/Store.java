package main.java.flower.store;
import flower.store.FlowerBucket;

import java.util.ArrayList;
import java.util.List;

public class Store {
    
    private List<FlowerBucket> buckets = new ArrayList<>();

    public void addBucket(FlowerBucket bucket) {
        buckets.add(bucket);
    }

    /**
     * Searches the store's inventory for FlowerBuckets that satisfy the given specification.
     * @param spec The search criterion (Specification).
     * @return A list of FlowerBuckets that satisfy the specification.
     */
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