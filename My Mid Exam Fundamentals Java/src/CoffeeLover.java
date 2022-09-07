import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CoffeeLover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> coffeeTypes = Arrays.stream(scanner.nextLine().split("\\s+")).map(String::toString).collect(Collectors.toList());
        int commandCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandCount; i++) {
            String command = scanner.nextLine();
            String [] commandToArray = command.split("\\s+");

            if(command.contains("Include")){
                coffeeTypes.add(commandToArray[1]);
            }
            else if(command.contains("Remove")){
                int numberOfCoffees = Integer.parseInt(commandToArray[2]);
                if(commandToArray[1].equals("first")&&numberOfCoffees<=coffeeTypes.size()){
                    for (int j = 0; j < numberOfCoffees; j++) {
                        coffeeTypes.remove(0);
                    }
                }
                else if(commandToArray[1].equals("last")&&numberOfCoffees<=coffeeTypes.size()){
                    for (int j = 0; j < numberOfCoffees; j++) {
                        coffeeTypes.remove(coffeeTypes.size()-1);
                    }
                }
            }
            else if(command.contains("Prefer")){
                int firstIndex = Integer.parseInt(commandToArray[1]);
                int secondIndex = Integer.parseInt(commandToArray[2]);
                if(firstIndex>=0 && firstIndex <=coffeeTypes.size()-1 && secondIndex>=0 && secondIndex<=coffeeTypes.size()-1){
                    String firstType = coffeeTypes.get(firstIndex);
                    String secondType = coffeeTypes.get(secondIndex);
                    coffeeTypes.set(firstIndex,secondType);
                    coffeeTypes.set(secondIndex,firstType);
                }
            }
            else if(command.contains("Reverse")){
                Collections.reverse(coffeeTypes);
            }
        }

        System.out.println("Coffees:");
        for (String coffee : coffeeTypes) {
            System.out.print(coffee + " ");
        }

    }
}
