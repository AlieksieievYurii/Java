package com.company;

public final class RunTask
{

    private int[][] Numbers;

    public RunTask(int[][] Numbers)
    {
        this.Numbers = Numbers;
    }

    public String run(int Nprint)
    {
        long buffer = 0;
        int EndLineElements =  Numbers.length - 1;
        String finishNumber="";

        for(int ansIndex = Numbers[0].length - 1; ansIndex >= 0; ansIndex--)
        {
            for(int i = 0; i < Numbers.length; i++)
            {
                buffer += Numbers[i][ansIndex];
            }
            Numbers[EndLineElements][ansIndex] = (int)buffer%10;
            buffer /= 10;
        }

        if(buffer > 0)
        {
            finishNumber += buffer;
            for(int i = 0; i < Nprint-Math.ceil(Math.log10(buffer)); i++)
                finishNumber += Numbers[EndLineElements][i];
        }else
        {
            for(int i = 0; i < Nprint; i++)
                finishNumber += Numbers[EndLineElements][i];
        }

        return finishNumber;
    }
}
