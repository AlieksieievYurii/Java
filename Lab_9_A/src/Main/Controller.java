package Main;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;

public class Controller
{
    private MoneyBack moneyBack;
    @FXML
    public TextField tvPrice;

    @FXML
    public TextField tvMoney;

    @FXML
    public Button btnCount;

    @FXML
    public ListView lstMoneyBack;

    private Stage stage;

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    public void initialize()
    {
        btnCount.setOnAction(new myListener());
        moneyBack = new MoneyBack();
    }

    private class myListener implements EventHandler
    {

        @Override
        public void handle(Event event)
        {
            double price;
            double money;
            try {

                price = Double.parseDouble(tvPrice.getText());
                money = Double.parseDouble(tvMoney.getText());

            }catch (Exception error){
                JOptionPane.showMessageDialog(null,"Enter price and money!");
                return;
            }

            if(money < price)
            {
                JOptionPane.showMessageDialog(null,"Ohhh. You are loser, you can not to buy it!");
                return;
            }


            lstMoneyBack.setItems(FXCollections.observableArrayList(moneyBack.countBackMoney(price,money)));
            lstMoneyBack.refresh();

        }
    }
}
