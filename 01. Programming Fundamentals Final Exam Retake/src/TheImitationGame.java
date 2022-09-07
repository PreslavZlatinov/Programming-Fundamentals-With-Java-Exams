import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Decode")) {

            String[] commandToArray = command.split("\\|");

            String commandType = commandToArray[0];

            switch (commandType) {
                case "Move":
                    int subLength = Integer.parseInt(commandToArray[1]);
                    String subbedString = input.substring(0, subLength);
                    input.replace(0, subLength, "");
                    input.append(subbedString);
                    break;

                case "Insert":
                    int indexToInsert = Integer.parseInt(commandToArray[1]);
                    String valueToInsert = commandToArray[2];
                    input.insert(indexToInsert, valueToInsert);
                    break;

                case "ChangeAll":
                    String toReplace = commandToArray[1];
                    String replacement = commandToArray[2];
                    input = new StringBuilder(input.toString().replace(toReplace, replacement));
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + input);
    }
}
