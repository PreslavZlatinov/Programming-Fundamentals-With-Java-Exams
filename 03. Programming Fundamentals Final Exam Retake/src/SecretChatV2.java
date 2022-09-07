import java.util.Scanner;

public class SecretChatV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Reveal")){

            String[] commandToArray = command.split(":\\|:");

            String commandType = commandToArray[0];

            switch (commandType){
                case "InsertSpace":
                    int index = Integer.parseInt(commandToArray[1]);
                    message.insert(index," ");
                    System.out.println(message);
                    break;

                case "Reverse":
                    String substring = commandToArray[1];
                    if(message.toString().contains(substring)){
                      int firstIndex = message.indexOf(substring);
                      int lastIndex = firstIndex + substring.length();
                      message.delete(firstIndex,lastIndex);
                      StringBuilder stringToAdd = new StringBuilder();
                        for (int i = substring.length()-1; i >= 0 ; i--) {
                            stringToAdd.append(substring.charAt(i));
                        }
                        message.append(stringToAdd);
                        System.out.println(message);
                    }else{
                        System.out.println("error");
                    }
                    break;

                case "ChangeAll":
                    String stringToReplace = commandToArray[1];
                    String replacement = commandToArray[2];
                    message = new StringBuilder(message.toString().replace(stringToReplace, replacement));
                    System.out.println(message);
                    break;
            }


            command = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s",message);
    }
}
