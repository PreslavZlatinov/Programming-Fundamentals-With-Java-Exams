import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(value -> Integer.parseInt(value)).toArray();

        String shootTarget = scanner.nextLine();
        int shotTargetCount = 0;

        while (!(shootTarget.equals("End"))) {

            int shootValue = Integer.parseInt(shootTarget);

            if(shootValue<=targets.length-1){
                int oldValue = targets[shootValue];
                if(targets[shootValue]!=-1){
                    targets[shootValue] = -1;
                    shotTargetCount++;
                    for (int i = 0; i < targets.length; i++) {
                        if(targets[i]>oldValue && targets[i]!=-1){
                            targets[i] -= oldValue;
                        }
                        else{
                            if(targets[i]!=-1) {
                                targets[i] += oldValue;
                            }
                        }
                    }
                }
            }

            shootTarget = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ",shotTargetCount);
        for (int i : targets) {
            System.out.print(i + " ");
        }

    }
}
