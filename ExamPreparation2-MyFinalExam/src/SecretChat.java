import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder message = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Reveal")){

            String[] commandToArray = command.split(":\\|:");

            String commandType = commandToArray[0];

            switch (commandType){
                case "InsertSpace":
                    message.insert(Integer.parseInt(commandToArray[1])," ");
                    System.out.println(message);
                    break;

                case "Reverse":
                    if(message.toString().contains(commandToArray[1])){
                        int firstIndex = message.indexOf(commandToArray[1]);
                        int lastIndex = firstIndex + commandToArray[1].length();
                        message.delete(firstIndex,lastIndex);
                        StringBuilder reversed = new StringBuilder();
                        for (int i = commandToArray[1].length()-1; i >= 0; i--) {
                            reversed.append(commandToArray[1].charAt(i));
                        }
                        message.append(reversed);
                        System.out.println(message);
                    }else{
                        System.out.println("error");
                    }
                    break;

                case "ChangeAll":
                    message = new StringBuilder(message.toString().replace(commandToArray[1], commandToArray[2]));
                    System.out.println(message);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("You have a new text message: %s", message);
    }
}
