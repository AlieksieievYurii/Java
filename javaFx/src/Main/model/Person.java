package Main.model;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;

public class Person
{
    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    private SimpleStringProperty name;

    public Person(String name)
    {
        this.name = new SimpleStringProperty(name);
    }

    public Observable getStringObservable()
    {
        return name;
    }


    @Override
    public String toString() {
        return name.getValue();
    }
}
