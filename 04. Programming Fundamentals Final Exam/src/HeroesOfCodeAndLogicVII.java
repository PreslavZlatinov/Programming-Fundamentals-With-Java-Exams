import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Integer> nameHealth = new LinkedHashMap<>();
        Map<String,Integer> nameMana = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] heroInfo = scanner.nextLine().split("\\s+");

            String name = heroInfo[0];
            int hp = Integer.parseInt(heroInfo[1]);
            int mana = Integer.parseInt(heroInfo[2]);

            nameHealth.put(name,hp);
            nameMana.put(name,mana);
        }

        String command = scanner.nextLine();

        while(!command.equals("End")){

            String[] commandToArray = command.split(" - ");
            String commandType = commandToArray[0];
            String heroName = commandToArray[1];

            switch (commandType){
                case "CastSpell":
                    int manaNeeded = Integer.parseInt(commandToArray[2]);
                    String spell = commandToArray[3];
                    if(manaNeeded<=nameMana.get(heroName)){
                        nameMana.put(heroName,nameMana.get(heroName)-manaNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n",heroName,spell,nameMana.get(heroName));
                    }
                    else{
                        System.out.printf("%s does not have enough MP to cast %s!\n",heroName,spell);
                    }
                    break;

                case "TakeDamage":
                    int dmg = Integer.parseInt(commandToArray[2]);
                    String enemy = commandToArray[3];
                    nameHealth.put(heroName,nameHealth.get(heroName)-dmg);
                    if(nameHealth.get(heroName)>0){
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",heroName,dmg,enemy,nameHealth.get(heroName));
                    }
                    else{
                        System.out.printf("%s has been killed by %s!\n",heroName,enemy);
                        nameHealth.remove(heroName);
                        nameMana.remove(heroName);
                    }
                    break;

                case "Recharge":
                    int manaRecharge = Integer.parseInt(commandToArray[2]);
                    int currentMana = nameMana.get(heroName);
                    nameMana.put(heroName,nameMana.get(heroName)+manaRecharge);
                    if(nameMana.get(heroName)>200){
                        nameMana.put(heroName,200);
                        System.out.printf("%s recharged for %d MP!\n",heroName,200-currentMana);
                    }
                    else{
                        System.out.printf("%s recharged for %d MP!\n",heroName,nameMana.get(heroName)-currentMana);
                    }
                    break;

                case "Heal":
                    int healthRecharge = Integer.parseInt(commandToArray[2]);
                    int currentHealth = nameHealth.get(heroName);
                    nameHealth.put(heroName,nameHealth.get(heroName)+healthRecharge);
                    if(nameHealth.get(heroName)>100){
                        nameHealth.put(heroName,100);
                        System.out.printf("%s healed for %d HP!\n",heroName,100-currentHealth);
                    }
                    else{
                        System.out.printf("%s healed for %d HP!\n",heroName,nameHealth.get(heroName)-currentHealth);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> e1 : nameHealth.entrySet()) {
            System.out.println(e1.getKey());
            System.out.println("  HP: " + e1.getValue());
            for (Map.Entry<String, Integer> e2 : nameMana.entrySet()) {
                if(e1.getKey().equals(e2.getKey())){
                    System.out.println("  MP: " + e2.getValue());
                    break;
                }
            }

        }

    }
}
