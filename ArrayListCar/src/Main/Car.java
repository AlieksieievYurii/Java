package Main;

import java.io.Serializable;

public class Car implements Serializable
{
   private String ModelCar;
   private int NumberCar;
   private String ColorCar;

   public String getModelCar() {
      return ModelCar;
   }

   public void setModelCar(String modelCar) {
      ModelCar = modelCar;
   }

   public int getNumberCar() {
      return NumberCar;
   }

   public void setNumberCar(int numberCar) {
      NumberCar = numberCar;
   }

   public String getColorCar() {
      return ColorCar;
   }

   public void setColorCar(String colorCar) {
      ColorCar = colorCar;
   }
}
