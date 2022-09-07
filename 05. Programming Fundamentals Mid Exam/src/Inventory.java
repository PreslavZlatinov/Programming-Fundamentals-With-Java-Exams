import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> collectingItems = Arrays.stream(scanner.nextLine().split(", ")).map(String::toString).collect(Collectors.toList());

        String command = scanner.nextLine();

        while(!(command.equals("Craft!"))){

            String [] commandArray = command.split(" - ");

            if(command.contains("Collect")){
                if(!(collectingItems.contains(commandArray[1]))){
                    collectingItems.add(commandArray[1]);
                }
            }
            else if(command.contains("Drop")){
                if(collectingItems.contains(commandArray[1])){
                    collectingItems.remove(commandArray[1]);
                }
            }
            else if(command.contains("Combine Items")){
                String [] combineItemsSplit = commandArray[1].split(":");
                if(collectingItems.contains(combineItemsSplit[0])){
                    int index = collectingItems.indexOf(combineItemsSplit[0]);
                    collectingItems.add(index+1,combineItemsSplit[1]);
                }
            }
            else if(command.contains("Renew")){
                if(collectingItems.contains(commandArray[1])){
                    String item = commandArray[1];
                    collectingItems.remove(item);
                    collectingItems.add(item);
                }
            }

            command = scanner.nextLine();
        }

        for (int i = 0; i < collectingItems.size(); i++) {
            if(i== collectingItems.size()-1){
                System.out.print(collectingItems.get(i));
            }
            else{
                System.out.print(collectingItems.get(i) + ", ");
            }
        }
    }
}
