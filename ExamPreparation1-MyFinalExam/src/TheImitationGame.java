import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Decode")){

            String[] commandToArray = command.split("\\|");

            String commandType = commandToArray[0];

            switch (commandType){
                case "Move":
                    int numberOfLetters = Integer.parseInt(commandToArray[1]);
                    String stringToMove = message.substring(0,numberOfLetters);
                    message.delete(0,numberOfLetters);
                    message.append(stringToMove);
                    break;

                case "Insert":
                    int index = Integer.parseInt(commandToArray[1]);
                    String strToAdd = commandToArray[2];
                    message.insert(index,strToAdd);
                    break;

                case "ChangeAll":
                    String strToReplace = commandToArray[1];
                    String replacement = commandToArray[2];

                   message = new StringBuilder(message.toString().replace(strToReplace, replacement));
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + message);
    }
}
