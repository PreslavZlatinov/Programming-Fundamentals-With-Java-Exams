import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> rooms = Arrays.stream(scanner.nextLine().split("\\|")).map(String::toString).collect(Collectors.toList());

        int health = 100;
        int bitcoins = 0;
        int roomsCount = 0;

            for (int i = 0; i < rooms.size(); i++) {
                String [] commandSplit;
                if(rooms.get(i).contains("potion")){
                    roomsCount++;
                    int oldHealthValue = health;
                    commandSplit = rooms.get(i).split("\\s+");
                    health += Integer.parseInt(commandSplit[1]);

                    if(health>100 && oldHealthValue==100){
                        health = 100;
                        System.out.println("You healed for 0 hp.");
                        System.out.println("Current health: 100 hp.");
                    }
                    else if(health>100){
                        int healedValue = 0;
                        healedValue =Integer.parseInt(commandSplit[1]) - (health - 100);
                        health=100;
                        System.out.printf("You healed for %d hp.\n",healedValue);
                        System.out.printf("Current health: %d hp.\n",health);
                    }
                    else{
                        System.out.printf("You healed for %d hp.\n",Integer.parseInt(commandSplit[1]));
                        System.out.printf("Current health: %d hp.\n",health);
                    }
                }
                else if(rooms.get(i).contains("chest")){
                    roomsCount++;
                    commandSplit = rooms.get(i).split("\\s+");
                    bitcoins += Integer.parseInt(commandSplit[1]);
                    System.out.printf("You found %d bitcoins.\n",Integer.parseInt(commandSplit[1]));
                }
                else{
                    roomsCount++;
                    commandSplit = rooms.get(i).split("\\s+");
                    health -= Integer.parseInt(commandSplit[1]);
                    if(health>0){
                        System.out.printf("You slayed %s.\n",commandSplit[0]);
                    }
                    else{
                        System.out.printf("You died! Killed by %s.\n",commandSplit[0]);
                        break;
                    }
                }
            }

        if(health>0){
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d\n",bitcoins);
            System.out.printf("Health: %d",health);
        }
        else{
            System.out.printf("Best room: %d",roomsCount);
        }
    }
}
