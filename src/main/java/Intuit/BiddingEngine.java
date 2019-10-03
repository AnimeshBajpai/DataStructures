package Intuit;

import java.util.*;

//Async Thread to calculate the winning bid
public class BiddingEngine {
    Map<Project, List<Bid>> projectBidMap = new TreeMap();
    MarketPlace marketPlace;

    public BiddingEngine(MarketPlace marketPlace) {
        this.marketPlace = marketPlace;
    }

    /**
     * Assign bids to projects when the deadline has passed and populate them with assigned project list
     * and remove them from biddable projects
     */
    void evaluateAndpopulateWinningBid() {
        while (true) {
            for (Map.Entry<Project, List<Bid>> entry : projectBidMap.entrySet()) {
                Project project = entry.getKey();
                List<Bid> bidList = entry.getValue();

                Date deadLine = project.getDeadline();
                Date currentTime = new Date();
                if (currentTime.after(deadLine)) {
                    if (bidList.size() == 0) {
                        projectBidMap.remove(project);
                        System.out.print("No bids for the project within deadline");
                        marketPlace.archiveProjects(project);
                    }
                    marketPlace.assignBid(project, bidList.stream().findFirst().get());
                }
            }
        }
    }

    void syncProjects() {
        while (true) {
            List<Project> allProjects = marketPlace.getAllProjects();
            allProjects.removeAll(projectBidMap.keySet());
            for (Project newProject : allProjects) {
                submitProject(newProject);
            }
        }
    }

    void submitBid(Bid bid, Project project) {
        List bidList = projectBidMap.get(project);
        bidList.add(bid);
        Collections.sort(bidList);
        projectBidMap.put(project, bidList);
    }

    public void submitProject(Project project) {
        projectBidMap.put(project, new ArrayList<Bid>());
    }
}
