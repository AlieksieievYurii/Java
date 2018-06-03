package main;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("activity.fxml"));

        Parent parent = loader.load();
        parent.setId("pane");
        Scene scene = new Scene(parent);
        scene.getStylesheets().addAll(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cross Hair");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();

        Controller controller = loader.getController();
        controller.setStage(primaryStage);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                controller.stopWork();
            }
        });

        primaryStage.show();
    }

    public static void main(String[] args)
    {launch(args);}
}
