package Intuit;

import java.util.ArrayList;
import java.util.List;

public class Seller {
    String sellerId;
    List<Project> projects = new ArrayList();

    public Seller(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public int hashCode() {
        return sellerId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Seller seller = (Seller) obj;
        return this.getSellerId().equals(seller.getSellerId());
    }
}
