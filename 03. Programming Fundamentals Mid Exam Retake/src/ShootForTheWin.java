import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] targets = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(value -> Integer.parseInt(value)).toArray();

        String targetIndex = scanner.nextLine();

        int countHits = 0;

        while (!(targetIndex.equals("End"))){
                int index = Integer.parseInt(targetIndex);
                if(index<=targets.length-1) {
                    countHits++;
                    int lastValue = targets[index];
                    targets[index] = -1;
                    for (int i = 0; i <= targets.length-1; i++) {
                        if(targets[i]==-1){
                            continue;
                        }
                        if(targets[i]>lastValue){
                            targets[i] -= lastValue;
                        }
                        else if(targets[i]<=lastValue){
                            targets[i] += lastValue;
                        }
                    }
                }



            targetIndex = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ",countHits);
        for (int target : targets) {
            System.out.print(target + " ");
        }

    }
}
