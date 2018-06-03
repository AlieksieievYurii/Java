package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("activity.fxml"));
        Parent parent = loader.load();
        primaryStage.setTitle("Lab 9 A");
        primaryStage.setScene(new Scene(parent,180,317));
        primaryStage.show();
        Controller c = loader.getController();
        c.setStage(primaryStage);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
