import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder inputLine = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Travel")) {

            String[] commandToArray = command.split(":");

            String commandType = commandToArray[0];

            switch (commandType) {
                case "Add Stop":
                    int indexToInsert = Integer.parseInt(commandToArray[1]);
                    if (indexToInsert >= 0 && indexToInsert <= inputLine.length() - 1) {
                        String stringToInsert = commandToArray[2];
                        inputLine.insert(indexToInsert,stringToInsert);
                    }
                    System.out.println(inputLine);
                    break;

                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandToArray[1]);
                    int endIndex = Integer.parseInt(commandToArray[2]);

                    if(startIndex >= 0 && startIndex <= inputLine.length() - 1 && endIndex >= 0 && endIndex <= inputLine.length() - 1){
                        inputLine.replace(startIndex,endIndex+1,"");
                    }
                    System.out.println(inputLine);
                    break;

                case "Switch":
                    String oldString = commandToArray[1];
                    if(inputLine.toString().contains(oldString)){
                        String newString = commandToArray[2];
                        inputLine = new StringBuilder(inputLine.toString().replaceAll(oldString, newString));
                    }
                    System.out.println(inputLine);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + inputLine);
    }
}
