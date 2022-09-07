import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());

        String distance = scanner.nextLine();

        int winCount = 0;

        while (!(distance.equals("End of battle"))){

            int distanceValue = Integer.parseInt(distance);

            if(initialEnergy>=distanceValue){
                initialEnergy -= distanceValue;
                winCount++;
                if(winCount%3==0){
                    initialEnergy += winCount;
                }
            }
            else{
                break;
            }

            distance = scanner.nextLine();
        }

        if(distance.equals("End of battle")){
            System.out.printf("Won battles: %d. Energy left: %d",winCount,initialEnergy);
        }
        else{
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy",winCount,initialEnergy);
        }
    }
}
