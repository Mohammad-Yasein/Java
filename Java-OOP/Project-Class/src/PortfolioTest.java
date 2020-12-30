import java.util.ArrayList;

public class PortfolioTest {
    public static void main(String[] args) {
        ArrayList<Project> projects = new ArrayList<Project>();
        projects.add(new Project("First Project", "This is the first project", 100));
        projects.add(new Project("Second Project", "This is the second project", 150));
        projects.add(new Project("Third Project", "This is the third project", 200));
        Portfolio portfolio = new Portfolio(projects);

        System.out.println(portfolio.getPortfolioCost());
        portfolio.showPortfolio();
    }
}
