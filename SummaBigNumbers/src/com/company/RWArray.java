package com.company;

import java.util.Scanner;
import java.io.*;

public final class RWArray
{
  private File file;
  public int SizeX = 0;
  public int SizeY = 0;
  private String nameFile = null;

  public RWArray(String nameFile)
  {
        this.nameFile = nameFile;
  }

  public int checkFile()
  {
      try
      {
        file = new File(nameFile);
        Scanner scn = new Scanner(file);
        scn.close();
      }catch(IOException error){return 1;}
      readSizeFile();
      return 0;
  }

  private void readSizeFile()
  {
    try
    {
        String Line;
        Scanner scn = new Scanner(file);
        while(scn.hasNextLine())
        {
            Line = scn.nextLine();
            if(SizeY == 0)SizeX = Line.length();
            SizeY++;
        }
        scn.close();
    }catch(IOException e){System.exit(2);}
  }

  public int[][] FullArrays()
  {
    String[] numbersString = new String[SizeX];
    int[][] ArrayNumbers = new int[SizeY][SizeX];
    int Y  = 0;

    try
    {
      Scanner scn = new Scanner(file);

      while(scn.hasNextLine())
      {
        numbersString = scn.nextLine().split("");
        for(int x = 0; x < SizeX; x++)
          ArrayNumbers[Y][x] = Integer.parseInt(numbersString[x]);
        Y++;
      }

      if(Y != (SizeY )) System.out.println("Error in size Array!");

    }catch (IOException e){System.exit(4);}

    return ArrayNumbers;
  }
}
