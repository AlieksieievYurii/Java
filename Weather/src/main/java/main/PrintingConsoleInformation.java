package main;

import java.util.logging.SocketHandler;

public class PrintingConsoleInformation
{
    PrintingConsoleInformation()
    {
        System.out.println("------------------------------------------");
        System.out.println("----------------Weather today-------------");
        System.out.println("------------------------------------------");
    }

    public void printNowDay(String day, String date)
    {
        System.out.print("# DAY: "+day);
        System.out.println(" || DATE: " + date);
        System.out.println("------------------------------------------");
    }

    public void printMinMaxNowTemperatyreToday(String[] minMax,String temp)
    {
        System.out.println("# Teamperatyra: "+ temp);
        System.out.println("# Min: " + minMax[0] + " || Max: "+minMax[1]);
        System.out.println("------------------------------------------");
    }

    public void printFutureInformation(String[][] list)
    {
        System.out.println("===========Temperatyra on future==========");
       for(int i = 0; i < list.length; i++)
       {
           System.out.print("| "+list[i][0]+" ");
       }
        System.out.println("|");

       for(int i = 0; i < list.length; i++)
       {
           System.out.print("| "+list[i][1]+" ");
       }
        System.out.println("|");
        for(int i = 0; i < list.length; i++)
        {
            System.out.print("|Min:"+list[i][2]+" ");
        }
        System.out.println("|");
        for(int i = 0; i < list.length; i++)
        {
            System.out.print("|Max:"+list[i][3]+" ");
        }
        System.out.println("|");
    }


}
