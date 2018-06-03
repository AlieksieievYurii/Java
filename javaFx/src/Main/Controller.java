package Main;

import Main.model.Person;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.util.Callback;


public class Controller
{

    @FXML
    private ListView listView;

    @FXML
    private Button btnAdd;

    private Person p = new Person("YUUURA");

    private ObservableList<Person> observableList = FXCollections.observableArrayList(new Callback<Person, Observable[]>() {
        @Override
        public Observable[] call(Person param) {
            return new Observable[]{p.getStringObservable()};
        }
    });

    @FXML
    private void initialize()
    {
        listView.setItems(observableList);
        observableList.addAll(p,new Person("Jana"));
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(event.getSource() == btnAdd)
                {
                    add();
                }
            }
        });
    }

    private void add()
    {
        if(p.getName().equals("YUUURA"))
        {
            p.setName("JAK");
        }else
        {
            p.setName("YUUURA");
        }
        System.out.println(p.getName());
    }
}
