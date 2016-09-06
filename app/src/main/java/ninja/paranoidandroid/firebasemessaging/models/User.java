package ninja.paranoidandroid.firebasemessaging.models;

/**
 * Created by anton on 25.08.16.
 */
public class User {

    private String name;
    private String position;

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
