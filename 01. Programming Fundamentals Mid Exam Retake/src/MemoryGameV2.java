import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGameV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+")).map(String::toString).collect(Collectors.toList());
        String command = scanner.nextLine();

        int movesCount = 0;

        while(!(command.equals("end"))){
            movesCount++;
            String [] commandArray = command.split("\\s+");
            int firstIndex = Integer.parseInt(commandArray[0]);
            int secondIndex = Integer.parseInt(commandArray[1]);

            if(firstIndex<0 || firstIndex>elements.size()-1 || secondIndex<0 || secondIndex>elements.size()-1 || firstIndex==secondIndex){
                int indexToAdd = elements.size()/2;
                String valueToAdd = "-"+movesCount+"a";
                elements.add(indexToAdd, valueToAdd);
                elements.add(indexToAdd, valueToAdd);
                System.out.println("Invalid input! Adding additional elements to the board");
            }
           else if(elements.get(firstIndex).equals(elements.get(secondIndex))){
                String element = elements.get(firstIndex);
                int removeCount = 0;
                for (int i = 0; i < elements.size(); i++) {
                    if(elements.get(i).equals(element)){
                        elements.remove(i);
                        removeCount++;
                        i--;
                        if(removeCount==2){
                            break;
                        }
                    }
                }
                System.out.printf("Congrats! You have found matching elements - %s!\n",element);

                if(elements.isEmpty()){
                    System.out.printf("You have won in %d turns!",movesCount);
                    break;
                }
            }
            else {
                System.out.println("Try again!");
            }

            command = scanner.nextLine();
        }

        if(command.equals("end")){
            System.out.println("Sorry you lose :(");
            for (String s : elements) {
                System.out.print(s + " ");
            }

        }
    }
}
