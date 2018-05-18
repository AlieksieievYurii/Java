package Main;

import java.io.Serializable;

public class Peson implements Serializable
{
    private String name;
    private String SerName;
    private String Country;
    private Boolean Student;
    private int ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerName() {
        return SerName;
    }

    public void setSerName(String serName) {
        SerName = serName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Boolean getStudent() {
        return Student;
    }

    public void setStudent(Boolean student) {
        Student = student;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
