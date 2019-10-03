package Intuit;

import java.util.ArrayList;
import java.util.List;

public class BuyerEngine {
    List<Buyer> buyers = new ArrayList();
    BiddingEngine biddingEngine;

    /**
     * Registers new buyers
     *
     * @param buyer
     */
    void registerBuyer(Buyer buyer) {
        buyers.add(buyer);
        System.out.print("Buyer added successfully");
    }

    /**
     * notify all buyers with a project
     *
     * @param project
     */
    void notifyBuyers(Project project) {
        for (Buyer buyer : buyers) {
            System.out.println("Hey Buyer -- " + buyer.getId() + " New project submitted--" + project.getKey());
        }
    }

    void submitBid(Bid bid, Project project) {
        biddingEngine.submitBid(bid, project);
    }
}
