import java.util.Scanner;

public class WorldTourV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Travel")) {

            String[] commandToArray = command.split(":");

            String commandType = commandToArray[0];

            switch (commandType) {
                case "Add Stop":
                    int index = Integer.parseInt(commandToArray[1]);
                    if (index >= 0 && index <= stops.length() - 1) {
                        stops.insert(index, commandToArray[2]);
                    }

                    System.out.println(stops);
                    break;

                case "Remove Stop":
                    int startIndex = Integer.parseInt(commandToArray[1]);
                    int lastIndex = Integer.parseInt(commandToArray[2]);

                    if (startIndex >= 0 && startIndex <= stops.length() - 1 && lastIndex >= 0 && lastIndex <= stops.length() - 1){
                        stops.replace(startIndex,lastIndex+1,"");
                    }
                    System.out.println(stops);
                        break;

                case "Switch":
                    if(stops.toString().contains(commandToArray[1])){
                       stops = new StringBuilder(stops.toString().replace(commandToArray[1], commandToArray[2]));
                    }

                    System.out.println(stops);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s",stops);
    }
}
