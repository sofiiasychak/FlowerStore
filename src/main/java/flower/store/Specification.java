package main.java.flower.store;

/**
 * Interface for the Specification pattern, used to check if
 * a FlowerBucket satisfies a specific criterion.
 */
public interface Specification {
    
    /**
     * Checks if the FlowerBucket satisfies the specification.
     * @param bucket The flower bucket to check.
     * @return true if the bucket satisfies the specification, false otherwise.
     */
    boolean isSatisfiedBy(FlowerBucket bucket);
}