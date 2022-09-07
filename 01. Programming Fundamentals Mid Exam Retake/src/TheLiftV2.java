import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheLiftV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        List<Integer> liftState = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = 0; i < liftState.size(); i++) {
            if (peopleCount <= 0) {
                break;
            }
            if (liftState.get(i) < 4 && liftState.get(i) >= 0) {
                if (peopleCount >= 4) {
                    int currentValue = liftState.get(i);
                    int valueToAdd = 4 - currentValue;
                    liftState.set(i, currentValue + valueToAdd);
                    peopleCount -= valueToAdd;
                } else {
                    liftState.set(i, liftState.get(i) + peopleCount);
                    peopleCount = 0;
                }
            }
        }

        boolean isEmpty = false;
        for (Integer n : liftState) {
            if (n < 4) {
                isEmpty = true;
                break;
            }
        }

        if (isEmpty && peopleCount == 0) {
            System.out.println("The lift has empty spots!");
            for (Integer n : liftState) {
                System.out.print(n + " ");
            }
        } else if (!isEmpty && peopleCount > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", peopleCount);
            for (Integer n : liftState) {
                System.out.print(n + " ");
            }
        } else if (!isEmpty && peopleCount == 0) {
            for (Integer n : liftState) {
                System.out.print(n + " ");
            }
        }

    }
}
