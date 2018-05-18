package Main;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class BasaControl
{
    private ArrayList<Peson> ArrayDataPerson = new ArrayList<Peson>();
    private String nameFile = "Basa.ser";

    public void WriteInformation(Peson obj)
    {
        ArrayDataPerson = (ArrayList<Peson>) deSerData();
        ArrayDataPerson.add(obj);
        serData();
        Print();
    }

    private Object deSerData()
    {
        Object Array = null;
        try {
            FileInputStream fileInp = new FileInputStream(nameFile);
            ObjectInputStream objectFileIn = new ObjectInputStream(fileInp);
            Array = objectFileIn.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return Array;
    }

    private void serData()
    {
        try {
            FileOutputStream file = new FileOutputStream(nameFile);
            ObjectOutputStream objectFile = new ObjectOutputStream(file);
            objectFile.writeObject(ArrayDataPerson);
            objectFile.close();
            file.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Error! Not fond the file!");
            System.exit(23);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Error! Output file!");
            System.exit(22);
        }
    }

    private void Print()
    {
        System.out.println("-------------------------------");
        for(Peson p : ArrayDataPerson)
        {
            System.out.println(p.getName()+" "+p.getSerName()+" "+p.getID());
        }
    }


}
