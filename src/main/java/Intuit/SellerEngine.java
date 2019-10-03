package Intuit;

import java.util.*;

public class SellerEngine {
    Map<String, Seller> sellerSet = new HashMap();

    public void registerSeller(String seller) {
        sellerSet.put(seller, new Seller(seller));
    }

    public List<Project> getProjectsForSeller(String sellerId) {
        Seller seller = sellerSet.get(sellerId);
        return seller.getProjects();
    }

    public void populateSellerProject(Project project) {
        List<Project> projectList = sellerSet.get(project.getSellerId()).getProjects();
        projectList.add(project);
    }
}
