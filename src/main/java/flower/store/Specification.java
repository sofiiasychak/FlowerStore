package main.java.flower.store;


public interface Specification {
    
    boolean isSatisfiedBy(FlowerBucket bucket);
}