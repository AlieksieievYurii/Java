package main;

public class Weather
{
    private static DataFromInternet data;
    private static PrintingConsoleInformation print;
    private static Grafica display;

    Weather()
    {
        data = new DataFromInternet();
        print = new PrintingConsoleInformation();
        display = new Grafica(data.getNowDay(),data.getNowDate(),data.getTemperatyreNow(),data.getNowMinMax());
    }

   public static void main(String[] args)
   {
        new Weather();

        print.printNowDay(data.getNowDay(),data.getNowDate());
        print.printMinMaxNowTemperatyreToday(data.getNowMinMax(),data.getTemperatyreNow());
        print.printFutureInformation(data.getInfOnFucture());

        display.setVisible(true);
   }
}
