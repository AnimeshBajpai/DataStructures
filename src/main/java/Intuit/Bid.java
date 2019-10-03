package Intuit;

public class Bid implements Comparable<Bid> {
    //Can be per hour or overall
    String projectKey;
    Double cost;
    boolean isHourly;
    String buyerIdentifier;
    //Date


    @Override
    public int compareTo(Bid o) {
        return this.cost.compareTo(o.cost);
    }
}
