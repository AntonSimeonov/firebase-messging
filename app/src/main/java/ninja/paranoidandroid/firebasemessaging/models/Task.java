package ninja.paranoidandroid.firebasemessaging.models;

/**
 * Created by anton on 25.08.16.
 */
public class Task {

    private String name;
    private String projectID;
    private String parentTaskID;
    private int priority;
    private String dateOfCreation;
    private String dateOfExecution;
    private String dateOfCompletion;
    private String problem;
    private String notes;
    private boolean status;


    public Task(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentTaskID() {
        return parentTaskID;
    }

    public void setParentTaskID(String parentTaskID) {
        this.parentTaskID = parentTaskID;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getDateOfExecution() {
        return dateOfExecution;
    }

    public void setDateOfExecution(String dateOfExecution) {
        this.dateOfExecution = dateOfExecution;
    }

    public String getDateOfCompletion() {
        return dateOfCompletion;
    }

    public void setDateOfCompletion(String dateOfCompletion) {
        this.dateOfCompletion = dateOfCompletion;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }
}
