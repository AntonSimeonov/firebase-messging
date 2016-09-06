package ninja.paranoidandroid.firebasemessaging.models;

/**
 * Created by anton on 25.08.16.
 */
public class Company {

    private String name;
    private String email;
    private String description;

    public Company(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
