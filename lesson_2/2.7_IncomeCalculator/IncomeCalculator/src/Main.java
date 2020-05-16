import java.util.Scanner;

public class Main
{
    private static int minIncome = 200000; // определение переменных
    private static int maxIncome = 900000;

    private static int officeRentCharge = 140000;
    private static int telephonyCharge = 12000;
    private static int internetAccessCharge = 7200;

    private static int assistantSalary = 45000;
    private static int financeManagerSalary = 90000;

    private static double mainTaxPercent = 0.24;
    private static double managerPercent = 0.15;

    private static double minInvestmentsAmount = 100000;

    public static void main(String[] args)
    {
        // задание со *
        double minimalIncomeForInvestments = Math.ceil(((minInvestmentsAmount / (1 - mainTaxPercent)) + calculateFixedCharges()) / (1 - managerPercent));
        System.out.println("Минимальный доход, чтобы можно было инвестировать -- " + minimalIncomeForInvestments);

        // ==========================================================================================

        while(true) //бесконечный цикл, программа не закончится сама!
        {
            System.out.println("Введите сумму доходов компании за месяц " +
                "(от 200 до 900 тысяч рублей): ");
            int income = (new Scanner(System.in)).nextInt(); //считывание ввода с консоли

            if(!checkIncomeRange(income)) { //проверка на дурака юзера
                continue;
            }

            double managerSalary = income * managerPercent;
            double pureIncome = income - managerSalary - calculateFixedCharges(); // выдать менеджеру деньги самым первым - милое дело, а потом можно и на обязательные расходы потратиться, например аренда
            double taxAmount = mainTaxPercent * pureIncome; // считаем налог на "чистый" доход
            double pureIncomeAfterTax = pureIncome - taxAmount; // вычитаем этот налог

            boolean canMakeInvestments = pureIncomeAfterTax >= minInvestmentsAmount; // достаточно ли денег для инвестирования

            System.out.println("Зарплата менеджера: " + managerSalary); //куча выводов логирования
            System.out.println("Общая сумма налогов: " +
                (taxAmount > 0 ? taxAmount : 0));
            System.out.println("Компания может инвестировать: " +
                (canMakeInvestments ? "да" : "нет"));
            System.out.println("fixed charges: " + calculateFixedCharges());
            System.out.println("pure income: " + pureIncome);
            System.out.println("pure income after tax: " + pureIncomeAfterTax);
            if(pureIncome < 0) {
                System.out.println("Бюджет в минусе! Нужно срочно зарабатывать!"); // предупреждение если все совсем плохо
            }
        }
    }

    private static boolean checkIncomeRange(int income) //юзвер ввел верное значение ? молодец : не очень молодец
    {
        if(income < minIncome)
        {
            System.out.println("Доход меньше нижней границы");
            return false;
        }
        if(income > maxIncome)
        {
            System.out.println("Доход выше верхней границы");
            return false;
        }
        return true;
    }

    private static int calculateFixedCharges() // суммируем все обязательные расходы
    {
        return officeRentCharge +
                telephonyCharge +
                internetAccessCharge +
                assistantSalary +
                financeManagerSalary;
    }
}
