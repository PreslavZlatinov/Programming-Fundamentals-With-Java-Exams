import java.util.Scanner;

public class BurgerBus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cities = Integer.parseInt(scanner.nextLine());
        double totalProfit = 0;
        for (int i = 1; i <= cities ; i++) {
            String cityName = scanner.nextLine();
            double income = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());

            if(i%5==0){
                income -= income*0.1;
                double earnings = income - expenses;
                totalProfit += earnings;
                System.out.printf("In %s Burger Bus earned %.2f leva.\n",cityName,earnings);
            }
            else if(i%3==0){
                expenses += expenses/2;
                double earnings = income - expenses;
                totalProfit += earnings;
                System.out.printf("In %s Burger Bus earned %.2f leva.\n",cityName,earnings);
            }
            else{
                double earnings = income - expenses;
                totalProfit += earnings;
                System.out.printf("In %s Burger Bus earned %.2f leva.\n",cityName,earnings);
            }

        }

        System.out.printf("Burger Bus total profit: %.2f leva.",totalProfit);
    }
}
