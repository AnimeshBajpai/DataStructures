package Intuit;

import java.util.Date;
import java.util.Map;

public class Project implements Comparable<Project> {
    String sellerId;
    String key;
    //These project specifications can include misc project informtion for buyers to decide
    Map<String, Object> projectSpecs;
    Date deadline;
    //Empty until deadline is reached
    Bid winnerBid;

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Map<String, Object> getProjectSpecs() {
        return projectSpecs;
    }

    public void setProjectSpecs(Map<String, Object> projectSpecs) {
        this.projectSpecs = projectSpecs;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Bid getWinnerBid() {
        return winnerBid;
    }

    public void setWinnerBid(Bid winnerBid) {
        this.winnerBid = winnerBid;
    }

    public int compareTo(Project project) {
        return deadline.compareTo(project.deadline);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Project project = (Project) obj;
        return this.key.equals(project.key);
    }
}
