package core;

public class Car
{
    public String number;                                       // Объявлена переменная типа String
    public int height;                                          // Объявлена переменная типа int
    public double weight;                                       // Объявлена переменная типа double
    public boolean hasVehicle;                                  // Объявлена переменная типа boolean
    public boolean isSpecial;                                   // Объявлена переменная типа boolean

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";     // Объявлена переменная типа String
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}