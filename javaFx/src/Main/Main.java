package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

    private AnchorPane pane;
    private Scene scene;
    @Override
    public void start(Stage Stage) throws Exception
    {
        pane = FXMLLoader.load(this.getClass().getResource("activity.fxml"));
        scene = new Scene(pane,300,300);
        Stage.setScene(scene);
        Stage.show();
    }

    public static void main(String[] args) {launch();}
}
