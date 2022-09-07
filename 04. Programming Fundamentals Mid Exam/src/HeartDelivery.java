import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> neighborhood = Arrays.stream(scanner.nextLine().split("@")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        int lastPosition = 0;
        boolean hasValentine = true;
        int jumpLength = 0;
        while(!(command.equals("Love!"))){

            String [] commandArray = command.split("\\s+");
            jumpLength += Integer.parseInt(commandArray[1]);

            if(jumpLength<0 || jumpLength>neighborhood.size()-1){
                jumpLength = 0;
            }

            if(neighborhood.get(jumpLength)!=0){
                int oldValue = neighborhood.get(jumpLength);
                neighborhood.set(jumpLength,oldValue-2);
                if(neighborhood.get(jumpLength)==0){
                    System.out.printf("Place %d has Valentine's day.\n",jumpLength);
                }
            }
            else{
                System.out.printf("Place %d already had Valentine's day.\n",jumpLength);
            }

            lastPosition = jumpLength;
            command = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.\n",lastPosition);

        int failedHouses = 0;
        for (int i = 0; i < neighborhood.size(); i++) {
            if(neighborhood.get(i)!=0){
                hasValentine = false;
                failedHouses++;
            }
        }

        if(hasValentine){
            System.out.println("Mission was successful.");
        }
        else{
            System.out.printf("Cupid has failed %d places.",failedHouses);
        }
    }
}
