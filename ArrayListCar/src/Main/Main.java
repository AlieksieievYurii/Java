package Main;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main
{
    private static String[] Models = {"Toyota","Porsze","Tesla","Moskwa"};
    private static String[] Colors = {"Red","Green","Yellow","Navy","White"};

    public static void main(String[] args)
    {
        ArrayList<Car> Cars;

        Cars = (ArrayList<Car>) desSerObject("Data");
        Random r = new Random();
        int numCars = $numCars();

        for(int i = 0; i < numCars; i++)
        {
            Car car = new Car();
            car.setNumberCar(r.nextInt(9999) + 1000);
            car.setModelCar(Models[r.nextInt(Models.length)]);
            car.setColorCar(Colors[r.nextInt(Colors.length)]);

            Cars.add(car);
        }

        for(Car c : Cars)
        {
            System.out.println(c.getModelCar()+" " + c.getNumberCar() + " " + c.getColorCar());
        }

        serObject("Data",Cars);

    }

    private static void serObject(String NameFile, Object obj)
    {
        try {
            FileOutputStream out = new FileOutputStream(NameFile+".ser");
            ObjectOutputStream o = new ObjectOutputStream(out);
            o.writeObject(obj);
            o.close();
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("Not found file!");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Error out/in file!");
            System.exit(2);
        }
    }

    private static Object desSerObject(String nameFile)
    {
        Object returnObject = null;
        try
        {
            FileInputStream in = new FileInputStream(nameFile + ".ser");
            ObjectInputStream f = new ObjectInputStream(in);

            returnObject = f.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(3);
        } catch (IOException e) {
            System.out.println("Error of INPUT file!");
            System.exit(5);
        } catch (ClassNotFoundException e) {
            System.out.println("Error of reading file!");
            System.exit(6);
        }
        return returnObject;
    }

    private static int $numCars()
    {
        int numberOfCars = 0;
        try {
            String text = JOptionPane.showInputDialog("Enter number of cars");
            numberOfCars = Integer.parseInt(text);
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Enter only number!");
            System.exit(1);
        }
        return numberOfCars;
    }

}
