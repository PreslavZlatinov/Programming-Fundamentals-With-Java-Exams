import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while(!command.equals("Generate")){

            String[] commandToArray = command.split(">>>");

            String commandType = commandToArray[0];

            int firstIndex = 0;
            int secondIndex = 0;

            switch (commandType){
                case "Contains":
                    if(input.toString().contains(commandToArray[1])){
                        System.out.printf("%s contains %s\n",input,commandToArray[1]);
                    }
                    else{
                        System.out.println("Substring not found!");
                    }
                    break;

                case "Flip":
                    firstIndex = Integer.parseInt(commandToArray[2]);
                    secondIndex = Integer.parseInt(commandToArray[3]);

                    String toChange = input.substring(firstIndex,secondIndex);

                    if(commandToArray[1].equals("Upper")){
                        toChange = toChange.toUpperCase();
                        input.replace(firstIndex,secondIndex,toChange);
                    }
                    else if(commandToArray[1].equals("Lower")){
                        toChange = toChange.toLowerCase();
                        input.replace(firstIndex,secondIndex,toChange);
                    }
                    System.out.println(input);
                    break;

                case "Slice":
                    firstIndex = Integer.parseInt(commandToArray[1]);
                    secondIndex = Integer.parseInt(commandToArray[2]);

                    input.replace(firstIndex,secondIndex,"");

                    System.out.println(input);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s",input);
    }
}
