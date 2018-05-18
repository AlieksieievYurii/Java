package sample;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller
{
    @FXML
    private Button btn;
    @FXML
    private Button btn_two;
    @FXML
    private Label label;

    @FXML
    private void initialize()
    {
        myListener l = new myListener();
        btn.setOnAction(l);
        btn_two.setOnAction(l);
    }

    private class myListener implements EventHandler
    {

        @Override
        public void handle(Event event)
        {
            if(event.getSource() == btn)
            {
                label.setText(((Button)event.getSource()).getText()+"OL");
            }
            else if(event.getSource() == btn_two)
            {
                label.setText(((Button)event.getSource()).getText()+"LO");
            }
        }
    }
}
