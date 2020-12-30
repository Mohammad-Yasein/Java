import java.util.ArrayList;

public class Portfolio {
    ArrayList<Project> projects;

    public Portfolio() {
    }

    public Portfolio(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public double getPortfolioCost() {
        double cost = 0;
        for (Project project : projects) {
            cost += project.getInitialCost();
        }
        return cost;
    }

    public void showPortfolio() {
        for (Project project : projects) {
            System.out.println(project.elevatorPitch());
        }
        System.out.println(getPortfolioCost());
    }
}