import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> groceries = Arrays.stream(scanner.nextLine().split("!")).map(String::toString).collect(Collectors.toList());

        String command = scanner.nextLine();
        boolean exists = false;
        String itemName = "";
        while (!(command.equals("Go Shopping!"))) {

            String[] commandArray = command.split("\\s+");

            if (command.contains("Urgent")) {
                itemName = commandArray[1];
                for (int i = 0; i < groceries.size(); i++) {
                    if (groceries.get(i).equals(itemName)) {
                        exists = true;
                    }
                }
                if (!exists) {
                    groceries.add(0, itemName);
                }
                exists = false;
            } else if (command.contains("Unnecessary")) {
                itemName = commandArray[1];
                for (int i = 0; i < groceries.size(); i++) {
                    if (groceries.get(i).equals(itemName)) {
                        exists = true;
                    }
                }

                if (exists) {
                    groceries.remove(itemName);
                }
                exists = false;
            } else if (command.contains("Correct")) {
                itemName = commandArray[1];
                for (int i = 0; i < groceries.size(); i++) {
                    if (groceries.get(i).equals(itemName)) {
                        exists = true;
                    }
                }

                if (exists) {
                    groceries.set(groceries.indexOf(itemName), commandArray[2]);
                }
                exists = false;
            } else if (command.contains("Rearrange")) {
                itemName = commandArray[1];
                for (int i = 0; i < groceries.size(); i++) {
                    if (groceries.get(i).equals(itemName)) {
                        exists = true;
                    }
                }
                if (exists) {
                    groceries.remove(itemName);
                    groceries.add(itemName);
                }
                exists = false;
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < groceries.size(); i++) {
            if (i == groceries.size() - 1) {
                System.out.print(groceries.get(i));
            } else {
                System.out.print(groceries.get(i) + ", ");
            }
        }
    }
}
