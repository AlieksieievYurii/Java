package main;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Controller
{
    private Stage stage;

    private LightTraffic lightTrafficOne;
    private LightTraffic lightTrafficTwo;
    private LightTraffic lightTrafficThree;
    private LightTraffic lightTrafficFour;
    private LightTraffic lightTrafficPeopleOneA;
    private LightTraffic lightTrafficPeopleOneB;
    private LightTraffic lightTrafficPeopleTwoA;
    private LightTraffic lightTrafficPeopleTwoB;
    private LightTraffic lightTrafficPeopleThreeA;
    private LightTraffic lightTrafficPeopleThreeB;
    private LightTraffic lightTrafficPeopleFourA;
    private LightTraffic lightTrafficPeopleFourB;

    private ControllerLightTrafic controllerLightTrafic;

    @FXML
    Circle tlOneRed,tlTwoRed,tlThreeRed,tlFourRed;

    @FXML
    Circle tlOneYellow,tlTwoYellow,tlThreeYellow,tlFourYellow;

    @FXML
    Circle tlOneGreen, tlTwoGreen,tlThreeGreen,tlFourGreen;

    @FXML
    Circle ptlOneAGreen,ptlOneARed,ptlOneBGreen,ptlOneBRed;
    @FXML
    Circle ptlTwoAGreen,ptlTwoARed,ptlTwoBGreen,ptlTwoBRed;
    @FXML
    Circle ptlThreeAGreen,ptlThreeARed,ptlThreeBGreen,ptlThreeBRed;
    @FXML
    Circle ptlFourAGreen,ptlFourARed,ptlFourBGreen,ptlFourBRed;

    public void setStage(Stage stage)
    {this.stage = stage;}

    public void initialize()
    {
        lightTrafficOne = new LightTraffic(tlOneRed,tlOneYellow,tlOneGreen);
        lightTrafficTwo = new LightTraffic(tlTwoRed,tlTwoYellow,tlTwoGreen);
        lightTrafficThree = new LightTraffic(tlThreeRed,tlThreeYellow,tlThreeGreen);
        lightTrafficFour = new LightTraffic(tlFourRed,tlFourYellow,tlFourGreen);

        lightTrafficPeopleOneA = new LightTraffic(ptlOneARed,ptlOneAGreen);
        lightTrafficPeopleOneB = new LightTraffic(ptlOneBRed,ptlOneBGreen);

        lightTrafficPeopleTwoA = new LightTraffic(ptlTwoARed,ptlTwoAGreen);
        lightTrafficPeopleTwoB = new LightTraffic(ptlTwoBRed,ptlTwoBGreen);

        lightTrafficPeopleThreeA = new LightTraffic(ptlThreeARed,ptlThreeAGreen);
        lightTrafficPeopleThreeB = new LightTraffic(ptlThreeBRed,ptlThreeBGreen);

        lightTrafficPeopleFourA = new LightTraffic(ptlFourARed,ptlFourAGreen);
        lightTrafficPeopleFourB = new LightTraffic(ptlFourBRed,ptlFourBGreen);

        controllerLightTrafic = new ControllerLightTrafic(
                lightTrafficOne,
                lightTrafficTwo,
                lightTrafficThree,
                lightTrafficFour,
                lightTrafficPeopleOneA,
                lightTrafficPeopleOneB,
                lightTrafficPeopleTwoA,
                lightTrafficPeopleTwoB,
                lightTrafficPeopleThreeA,
                lightTrafficPeopleThreeB,
                lightTrafficPeopleFourA,
                lightTrafficPeopleFourB);

        Thread thread = new Thread(controllerLightTrafic);
        thread.start();
    }
    public void stopWork()
    {
        controllerLightTrafic.stopThread();
    }
}
