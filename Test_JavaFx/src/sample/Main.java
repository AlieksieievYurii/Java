package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application
{

    private Stage stage;
    private Scene scene;
    private AnchorPane pane;



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.stage = primaryStage;
        pane = FXMLLoader.load(this.getClass().getResource("sample.fxml"));
        scene = new Scene(pane,300,300);
        stage.setScene(scene);
        stage.show();
    }


}
