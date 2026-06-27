import java.util.Scanner;

public class financialforecasting{

    // Recursive method to calculate future value
    static double futureValue(double amount, double rate, int years) {

        // Base case
        if (years == 0)
            return amount;

        // Recursive case
        return futureValue(amount * (1 + rate), rate, years - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Initial Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Annual Growth Rate (%): ");
        double rate = sc.nextDouble() / 100;

        System.out.print("Enter Number of Years: ");
        int years = sc.nextInt();

        double result = futureValue(amount, rate, years);

        System.out.printf("\nFuture Value = %.2f", result);

        sc.close();
    }
}