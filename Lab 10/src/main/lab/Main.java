package main.lab;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application
{

    @FXML
    Circle circle;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("Lab 10");
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("activity.fxml"));
        Parent parent = loader.load();
        Scene scene = new Scene(parent,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void initialize()
    {
        circle.setFill(javafx.scene.paint.Color.RED);
    }

    public static void main(String[] args)
    {launch(args);}
}
