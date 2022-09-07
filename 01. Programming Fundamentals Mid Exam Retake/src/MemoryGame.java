import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String values = scanner.nextLine();

        List<String> valuesList = Arrays.stream(values.split("\\s+")).map(String::toString).collect(Collectors.toList());

        String guessCommand = scanner.nextLine();

        int turnsCount = 0;
        int movesCount = 1;
        while (!guessCommand.equals("end")) {

            int matchCount = 0;
            String[] commandToArray = guessCommand.split("\\s+");
            int firstIndex = Integer.parseInt(commandToArray[0]);
            int secondIndex = Integer.parseInt(commandToArray[1]);

            System.out.println(valuesList.size());

            if (firstIndex == secondIndex || firstIndex < 0 || secondIndex < 0 || firstIndex >= valuesList.size() || secondIndex >= valuesList.size()) {
                int middleIndex = valuesList.size() / 2;
                String toInput = "-" + movesCount + "a";
                valuesList.add(middleIndex, toInput);
                valuesList.add(middleIndex, toInput);
                System.out.println("Invalid input! Adding additional elements to the board");
            } else if (Objects.equals(valuesList.get(firstIndex), valuesList.get(secondIndex))) {
                System.out.printf("Congrats! You have found matching elements - %s!\n", valuesList.get(firstIndex));
                String currentValue = valuesList.get(firstIndex);
                for (int i = 0; i < valuesList.size(); i++) {
                    if (valuesList.get(i).equals(currentValue)) {
                        valuesList.remove(i);
                        matchCount++;
                        i--;
                        if (matchCount == 2) {
                            break;
                        }
                    }
                }
                turnsCount++;
                if (valuesList.size() == 0) {
                    System.out.printf("You have won in %d turns!", turnsCount);
                    return;
                }
            } else {
                System.out.println("Try again!");
                turnsCount++;
            }

            guessCommand = scanner.nextLine();
            movesCount++;
        }

        System.out.println("Sorry you lose :(");
        for (String s : valuesList) {
            System.out.print(s+ " ");
        }
    }
}
