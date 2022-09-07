import java.util.Scanner;

public class ActivationKeysV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder key = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Generate")){

            String[] commandToArray = command.split(">>>");

            switch (commandToArray[0]){
                case "Contains":
                    if(key.toString().contains(commandToArray[1])){
                        System.out.printf("%s contains %s\n", key,commandToArray[1]);
                    } else{
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    int startIndex = Integer.parseInt(commandToArray[2]);
                    int endIndex = Integer.parseInt(commandToArray[3]);
                    String substring = key.substring(startIndex, endIndex);
                    if(commandToArray[1].equals("Upper")){
                       substring = substring.toUpperCase();
                       key.replace(startIndex, endIndex, substring);
                    } else if(commandToArray[1].equals("Lower")){
                        substring = substring.toLowerCase();
                        key.replace(startIndex, endIndex, substring);
                }
                    System.out.println(key);
                    break;
                case "Slice":
                    int start = Integer.parseInt(commandToArray[1]);
                    int end = Integer.parseInt(commandToArray[2]);
                    key.replace(start,end,"");
                    System.out.println(key);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s", key);

    }
}
