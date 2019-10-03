package Intuit;

import java.util.List;

/**
 * This class will archive un-sold projects
 */
public class MarketPlaceArchive {
    List<Project> archivedProjects;

    public void archiveProject(Project project) {
        archivedProjects.add(project);
    }
}
