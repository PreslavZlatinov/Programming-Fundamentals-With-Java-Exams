import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder concealed = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Reveal")) {

            String[] commandToArray = command.split(":\\|:");

            String commandType = commandToArray[0];

            switch (commandType) {
                case "InsertSpace":
                    int index = Integer.parseInt(commandToArray[1]);
                    concealed.insert(index, " ");
                    System.out.println(concealed);
                    break;

                case "Reverse":
                    String substring = commandToArray[1];
                    int indexOfSubString = concealed.indexOf(substring);
                    int lastIndex = indexOfSubString + substring.length();
                    if (concealed.toString().contains(substring)) {
                        concealed.delete(indexOfSubString, lastIndex);
                        StringBuilder reversed = new StringBuilder();
                        for (int i = substring.length() - 1; i >= 0; i--) {
                            reversed.append(substring.charAt(i));
                        }

                        concealed.append(reversed);
                        System.out.println(concealed);
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "ChangeAll":
                    String toReplace = commandToArray[1];
                    String replacement = commandToArray[2];
                    if(concealed.toString().contains(toReplace)){
                        concealed = new StringBuilder(concealed.toString().replaceAll(toReplace, replacement));
                    }
                    System.out.println(concealed);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("You have a new text message: " + concealed);
    }
}
