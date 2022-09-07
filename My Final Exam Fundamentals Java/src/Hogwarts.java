import java.util.Locale;
import java.util.Scanner;

public class Hogwarts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder spell = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Abracadabra")){

            String[] commandArray = command.split("\\s+");
            String commandType = commandArray[0];

            switch (commandType){
                case "Abjuration":
                    spell = new StringBuilder(spell.toString().toUpperCase());
                    System.out.println(spell);
                    break;

                case "Necromancy":
                    spell = new StringBuilder(spell.toString().toLowerCase());
                    System.out.println(spell);
                    break;

                case "Illusion":
                    int index = Integer.parseInt(commandArray[1]);
                    if(index>=0 && index <= spell.length()-1){
                        String letter = commandArray[2];
                        spell.replace(index,index+1,letter);
                        System.out.println("Done!");
                    }else{
                        System.out.println("The spell was too weak.");
                    }
                    break;

                case "Divination":
                    String stringToReplace = commandArray[1];
                    String replacement = commandArray[2];

                    if(spell.toString().contains(stringToReplace)){
                      spell = new StringBuilder(spell.toString().replace(stringToReplace, replacement));
                        System.out.println(spell);
                    }
                    break;

                case "Alteration":
                    String stringToRemove = commandArray[1];
                    if(spell.toString().contains(stringToRemove)){
                       spell = new StringBuilder(spell.toString().replace(stringToRemove, ""));
                        System.out.println(spell);
                    }
                    break;

                default:
                    System.out.println("The spell did not work!");
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
