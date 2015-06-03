package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by BeytullahC on 6/3/2015.
 */

@XmlRootElement(name = "User")
public class User {

    public User() {

    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    private String name;
    private String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
