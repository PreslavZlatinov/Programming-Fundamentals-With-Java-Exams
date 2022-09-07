import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!(command.equals("End"))) {

            String[] commandArray = command.split("\\s+");
            int index = Integer.parseInt(commandArray[1]);
            if (command.contains("Shoot")) {
                if (index <= targets.size() - 1 && index >= 0) {
                    int newValue = targets.get(index) - Integer.parseInt(commandArray[2]);
                    if (newValue > 0) {
                        targets.set(index, newValue);
                    } else {
                        targets.remove(index);
                    }
                }
            } else if (command.contains("Add")) {
                if (index <= targets.size() - 1 && index >= 0) {
                    int valueToInsert = Integer.parseInt(commandArray[2]);
                    targets.add(index, valueToInsert);
                } else {
                    System.out.println("Invalid placement!");
                }
            } else if (command.contains("Strike")) {
                if (index < targets.size() - 1 && index > 0) {
                    int start = index - Integer.parseInt(commandArray[2]);
                    int end = index + Integer.parseInt(commandArray[2]);

                    if (start < 0 || end > targets.size() - 1) {
                        System.out.println("Strike missed!");
                    } else {
                        for (int i = start; i <= end; i++) {
                            targets.remove(start);
                        }
                    }
                } else {
                    System.out.println("Strike missed!");
                }
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < targets.size(); i++) {
            if (i == targets.size() - 1) {
                System.out.print(targets.get(i));
            } else {
                System.out.print(targets.get(i) + "|");
            }
        }

    }
}
