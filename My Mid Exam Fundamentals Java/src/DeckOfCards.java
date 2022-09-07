import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeckOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> cards = Arrays.stream(scanner.nextLine().split(", ")).map(String::toString).collect(Collectors.toList());
        int commandCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandCount; i++) {
            String command = scanner.nextLine();
            String [] commandArray = command.split(", ");

            if(command.contains("Add")){
                String cardType = commandArray[1];
                if(!(cards.contains(cardType))){
                    cards.add(cardType);
                    System.out.println("Card successfully added");
                }
                else{
                    System.out.println("Card is already in the deck");
                }
            }
            else if(command.contains("Remove")){
                if(command.contains("At")){
                    int index = Integer.parseInt(commandArray[1]);
                    if(index>=0 && index<=cards.size()-1){
                        cards.remove(index);
                        System.out.println("Card successfully removed");
                    }
                    else{
                        System.out.println("Index out of range");
                    }
                }
                else {
                    String cardType = commandArray[1];
                    if (cards.contains(cardType)) {
                        cards.remove(cardType);
                        System.out.println("Card successfully removed");
                    } else {
                        System.out.println("Card not found");
                    }
                }
            }
            else if(command.contains("Insert")){
                int index = Integer.parseInt(commandArray[1]);
                String cardType = commandArray[2];

                if(index>=0 && index<=cards.size()-1 && cards.contains(cardType)){
                    System.out.println("Card is already added");
                }
                else if(index>=0 && index<=cards.size()-1 && !(cards.contains(cardType))){
                    cards.add(index,cardType);
                    System.out.println("Card successfully added");
                }
                else{
                    System.out.println("Index out of range");
                }
            }
        }

        for (int i = 0; i < cards.size(); i++) {
            if(i== cards.size()-1){
                System.out.print(cards.get(i));
            }
            else{
                System.out.print(cards.get(i)+", ");
            }
        }
    }
}
