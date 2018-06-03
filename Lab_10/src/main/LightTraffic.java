package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class LightTraffic
{
    private static Color COLOR_RED_ACTIVE = Color.rgb(255,0,0);
    private static Color COLOR_RED_NOACTIVE = Color.rgb(100,0,0);

    private static Color COLOR_YELLOW_ACTIVE = Color.rgb(255,255,0);
    private static Color COLOR_YELLOW_NOACTIVE = Color.rgb(140,140,0);

    private static Color COLOR_GREEN_ACTIVE = Color.rgb(0,255,0);
    private static Color COLOR_GREEN_NOACTIVE = Color.rgb(0,100,0);

    private Circle red;
    private Circle yellow;
    private Circle green;

    public LightTraffic(Circle red,Circle yellow , Circle green)
    {
        this.red = red;
        this.yellow = yellow;
        this.green = green;
    }

    LightTraffic(Circle red, Circle green)
    {
        this.red = red;
        this.green = green;
    }

    public void setTraffic(int state)
    {
        switch(state)
        {
            case 0://STOP
                red.setFill(COLOR_RED_ACTIVE);
                yellow.setFill(COLOR_YELLOW_NOACTIVE);
                green.setFill(COLOR_GREEN_NOACTIVE);
                break;
            case 1://READY
                red.setFill(COLOR_RED_NOACTIVE);
                yellow.setFill(COLOR_YELLOW_ACTIVE);
                green.setFill(COLOR_GREEN_NOACTIVE);
                break;
            case 2://GO
                red.setFill(COLOR_RED_NOACTIVE);
                yellow.setFill(COLOR_YELLOW_NOACTIVE);
                green.setFill(COLOR_GREEN_ACTIVE);
                break;
             default://WRONG
                 System.out.println("Error of state!");
                 new Exception("Wrong state of lightTrafic").printStackTrace();
                 break;
        }
    }
    public void setTrafficP(int state)
    {
        switch (state)
        {
            case 0:
                red.setFill(COLOR_RED_ACTIVE);
                green.setFill(COLOR_GREEN_NOACTIVE);
                break;
            case 1:
                red.setFill(COLOR_RED_NOACTIVE);
                green.setFill(COLOR_GREEN_ACTIVE);
                break;
             default:
                 System.out.println("Error of state!");
                 new Exception("Wrong state of lightTrafic").printStackTrace();
                 break;
        }
    }
}
