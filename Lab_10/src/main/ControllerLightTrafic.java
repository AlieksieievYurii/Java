package main;

public class ControllerLightTrafic implements Runnable
{
    private LightTraffic lfOne,lfTwo,lfThree,lfFour;
    private LightTraffic plfOneA,plfOneB,plfTwoA,plfTwoB,plfThreeA,plfThreeB,plfFourA,plfFourB;
    private boolean flagWorks;

    ControllerLightTrafic(LightTraffic lfOne,
                          LightTraffic lfTwo,
                          LightTraffic lfThree,
                          LightTraffic lfFour,
                          LightTraffic plfOneA,
                          LightTraffic plfOneB,
                          LightTraffic plfTwoA,
                          LightTraffic plfTwoB,
                          LightTraffic plfThreeA,
                          LightTraffic plfThreeB,
                          LightTraffic plfFourA,
                          LightTraffic plfFourB)
    {
        this.lfOne = lfOne;
        this.lfTwo = lfTwo;
        this.lfThree = lfThree;
        this.lfFour = lfFour;

        this.plfOneA = plfOneA;
        this.plfOneB = plfOneB;
        this.plfTwoA = plfTwoA;
        this.plfTwoB = plfTwoB;
        this.plfThreeA = plfThreeA;
        this.plfThreeB = plfThreeB;
        this.plfFourA = plfFourA;
        this.plfFourB = plfFourB;

        flagWorks = true;
    }

    @Override
    public void run()
    {
            while(flagWorks)
            {
               modeOneOfTrafick();
            }
    }

    public void stopThread()
    {
        flagWorks = false;
    }

    private void delay(int secons)
    {
        try {
            Thread.sleep(secons*1000);
        }catch (Exception error)
        {
            error.printStackTrace();
        }
    }

    private void modeOneOfTrafick()
    {
        firstRoad(2);
        firstRoadPeopleLine(1);
        secondRoad(0);
        secondRoadPeopleLine(0);
        delay(10);
        firstRoadPeopleLine(0);
        delay(2);
        firstRoad(1);
        delay(2);
        firstRoad(0);
        secondRoad(1);
        delay(2);
        secondRoad(2);
        secondRoadPeopleLine(1);
        delay(10);
        secondRoadPeopleLine(0);
        secondRoad(1);
        delay(2);
        secondRoad(0);
        delay(2);
    }

    private void secondRoadPeopleLine(int state)
    {
        plfThreeB.setTrafficP(state);
        plfThreeA.setTrafficP(state);
        plfFourA.setTrafficP(state);
        plfFourB.setTrafficP(state);
    }
    private void firstRoadPeopleLine(int state)
    {
        plfOneB.setTrafficP(state);
        plfOneA.setTrafficP(state);
        plfTwoA.setTrafficP(state);
        plfTwoB.setTrafficP(state);
    }

    private void firstRoad(int state)
    {
        lfOne.setTraffic(state);
        lfTwo.setTraffic(state);
    }
    private void secondRoad(int state)
    {
        lfThree.setTraffic(state);
        lfFour.setTraffic(state);
    }
}
