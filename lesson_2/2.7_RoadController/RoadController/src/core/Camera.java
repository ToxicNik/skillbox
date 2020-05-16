package core;

public class Camera
{
    public static Car getNextCar()
    {
        String randomNumber = Double.toString(Math.random()).substring(2, 5);   // Объявлена переменная типа String
        int randomHeight = (int) (1000 + 3500. * Math.random());                // Объявлена переменная типа int
        double randomWeight = 600 + 10000 * Math.random();                      // Объявлена переменная типа double

        Car car = new Car();                                                    // Объявлена переменная типа Car
        car.number = randomNumber;
        car.height = randomHeight;
        car.weight = randomWeight;
        car.hasVehicle = Math.random() > 0.5;
        car.isSpecial = Math.random() < 0.15;

        return car;
    }
}