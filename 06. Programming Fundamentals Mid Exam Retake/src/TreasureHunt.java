import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> loot = Arrays.stream(scanner.nextLine().split("\\|")).map(String::toString).collect(Collectors.toList());

        String command = scanner.nextLine();

        while(!(command.equals("Yohoho!"))){

            String [] commandArray = command.split("\\s+");

            if(command.contains("Loot")){
                for (int i = 1; i < commandArray.length; i++) {
                    if(!(loot.contains(commandArray[i]))){
                        loot.add(0,commandArray[i]);
                    }
                }
            }
            else if(command.contains("Drop")){
                int index = Integer.parseInt(commandArray[1]);
                if(index>=0 && index<=loot.size()-1){
                    String lootOnIndex = loot.get(index);
                    loot.remove(index);
                    loot.add(lootOnIndex);
                }
            }
            else if(command.contains("Steal")){
                int count = Integer.parseInt(commandArray[1]);
                List<String> stolenLoot = new ArrayList<>();

                if(count>loot.size()){
                    stolenLoot.addAll(loot);
                    loot.removeAll(loot);
                }
                else{
                    for (int i = 1; i <= count ; i++) {
                        int indexOfLast = loot.size()-1;
                        stolenLoot.add(0,loot.get(indexOfLast));
                        loot.remove(indexOfLast);
                    }
                }

                for (int i = 0; i < stolenLoot.size(); i++) {
                    if(i== stolenLoot.size()-1){
                        System.out.print(stolenLoot.get(i));
                        System.out.println();
                    }
                    else{
                        System.out.print(stolenLoot.get(i)+", ");
                    }
                }

            }
            command = scanner.nextLine();
        }

        if(loot.isEmpty()){
            System.out.println("Failed treasure hunt.");
        }
        else{
            double sumOfAll = 0;
            for (int i = 0; i < loot.size(); i++) {
                sumOfAll += loot.get(i).length();
            }

            double averageTreasureGain = sumOfAll / loot.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.",averageTreasureGain);
        }
    }
}
