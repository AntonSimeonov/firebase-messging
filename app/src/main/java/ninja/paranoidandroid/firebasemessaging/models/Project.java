package ninja.paranoidandroid.firebasemessaging.models;

/**
 * Created by anton on 25.08.16.
 */
public class Project {

    private String name;
    private String companyKey;
    private String startDate;
    private String endDate;
    private String description;
    private String goal;
    private double budget;

    public Project() {

    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    public String getGoal() {
        return goal;
    }

    public double getBudget() {
        return budget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getCompanyKey() {
        return companyKey;
    }

    public void setCompanyKey(String companyKey) {
        this.companyKey = companyKey;
    }
}
