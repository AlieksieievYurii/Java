package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Controller
{
    private Stage stage;
    private FileChooser fileChooser;
    private File file;

    @FXML
    Button btn;

    @FXML
    ImageView imgImage;

    @FXML
    ListView<String> listView;

    @FXML
    private void initialize()
    {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Select image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("GIF", "*.gif"),
                new FileChooser.ExtensionFilter("BMP", "*.bmp"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );

        listView.setOrientation(Orientation.VERTICAL);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(observable.getValue());
                File file = new File(observable.getValue());
                imgImage.setImage(new Image(file.toURI().toString()));

            }
        });

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                file = fileChooser.showOpenDialog(stage);
            listView.getItems().add(file.getPath());
            }
        });
    }

    public void setStage(Stage stage)
    {this.stage = stage;}
}
