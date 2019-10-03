package Intuit;

import java.util.*;

public class MarketPlace {

    static int PAGE_WINDOW = 100;
    List<Project> biddableProjectList;
    List<Project> assignedProjects;

    BuyerEngine buyerEngine;
    SellerEngine sellerEngine;
    MarketPlaceArchive archiver;

    Map<String, List<Bid>> projectBidMap = new HashMap();

    public MarketPlace() {
        buyerEngine = new BuyerEngine();
        sellerEngine = new SellerEngine();
        MarketPlaceArchive archiver = new MarketPlaceArchive();
    }

    public List getAllProjects() {
        return new ArrayList(biddableProjectList);
    }

    public void submitProject(Project project) {
        biddableProjectList.add(project);
        Collections.sort(biddableProjectList);
        sellerEngine.populateSellerProject(project);
        buyerEngine.notifyBuyers(project);
    }

    public List listProjects(int index) {
        return biddableProjectList.subList(index, index + PAGE_WINDOW);
    }

    public Bid getLowestBidForProject(String projectId) {
        Bid lowestBid;
        if (projectBidMap.containsKey(projectId)) {
            //since the list is sorted, first element will be with smallest bid
            lowestBid = projectBidMap.get(projectId).stream().findFirst().get();
        } else {
            System.out.print("No bids Yet for the project");
            lowestBid = null;
        }
        return lowestBid;
    }

    public void archiveProjects(Project project) {
        archiver.archiveProject(project);

    }

    public void removeFromBiddableProjects(Project project) {
        biddableProjectList.remove(project);
        archiver.archiveProject(project);
    }

    public void assignBid(Project project, Bid bid) {
        project.setWinnerBid(bid);
        assignedProjects.add(project);
        biddableProjectList.remove(project);
    }


}
