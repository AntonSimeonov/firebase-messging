package ninja.paranoidandroid.firebasemessaging.models;

/**
 * Created by anton on 11.09.16.
 */
public class ProjectTasks {

    private String name;
    private String startDate;
    private String endDate;


    public ProjectTasks(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
