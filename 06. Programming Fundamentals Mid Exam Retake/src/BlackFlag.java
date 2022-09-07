import java.util.Scanner;

public class BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfPlunder = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double targetPlunder = Double.parseDouble(scanner.nextLine());
        double gatheredPlunder = 0;
        for (int i = 1; i <= daysOfPlunder ; i++) {
            gatheredPlunder += dailyPlunder;
            if(i%3==0){
                gatheredPlunder += 1.0*dailyPlunder/2;
            }

            if(i%5==0){
                gatheredPlunder -= gatheredPlunder*0.3;
            }
        }

        if(gatheredPlunder>=targetPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.",gatheredPlunder);
        }
        else{
            double percentageLeft = (gatheredPlunder/targetPlunder)*100;
            System.out.printf("Collected only %.2f%% of the plunder.",percentageLeft);
        }
    }
}
