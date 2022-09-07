import java.util.*;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Integer> heroHealth = new LinkedHashMap<>();
        Map<String,Integer> heroMana = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] heroInfo = scanner.nextLine().split("\\s+");
            heroHealth.put(heroInfo[0],Integer.parseInt(heroInfo[1]));
            heroMana.put(heroInfo[0],Integer.parseInt(heroInfo[2]));
        }

        String command = scanner.nextLine();

        while (!command.equals("End")){

            String[] commandToArray = command.split(" - ");

            String commandType = commandToArray[0];
            String heroName = commandToArray[1];

            switch (commandType){
                case "CastSpell":
                    int manaNeeded = Integer.parseInt(commandToArray[2]);
                    String spell = commandToArray[3];
                    if(heroMana.get(heroName)>=manaNeeded){
                        heroMana.put(heroName,heroMana.get(heroName)-manaNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n",heroName,spell,heroMana.get(heroName));
                    }else{
                        System.out.printf("%s does not have enough MP to cast %s!\n",heroName,spell);
                    }
                    break;

                case "TakeDamage":
                    int damage = Integer.parseInt(commandToArray[2]);
                    String attacker = commandToArray[3];
                    heroHealth.put(heroName,heroHealth.get(heroName)-damage);
                    if(heroHealth.get(heroName)>0){
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n",heroName,damage,attacker,heroHealth.get(heroName));
                    }else{
                        heroHealth.remove(heroName);
                        heroMana.remove(heroName);
                        System.out.printf("%s has been killed by %s!\n",heroName,attacker);
                    }
                    break;

                case "Recharge":
                    int amountMana = Integer.parseInt(commandToArray[2]);
                    int currentMana = heroMana.get(heroName);
                    heroMana.put(heroName,heroMana.get(heroName)+amountMana);
                    if(heroMana.get(heroName)>200){
                        heroMana.put(heroName,200);
                        System.out.printf("%s recharged for %d MP!\n",heroName,200-currentMana);
                    }else{
                        System.out.printf("%s recharged for %d MP!\n",heroName,heroMana.get(heroName)-currentMana);
                    }
                    break;

                case "Heal":
                    int amountHealth = Integer.parseInt(commandToArray[2]);
                    int currentHealth = heroHealth.get(heroName);
                    heroHealth.put(heroName,heroHealth.get(heroName)+amountHealth);
                    if(heroHealth.get(heroName)>100){
                        heroHealth.put(heroName,100);
                        System.out.printf("%s healed for %d HP!\n",heroName,100-currentHealth);
                    }else{
                        System.out.printf("%s healed for %d HP!\n",heroName,heroHealth.get(heroName)-currentHealth);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> e1 : heroHealth.entrySet()) {
            for (Map.Entry<String, Integer> e2 : heroMana.entrySet()) {
                if(e1.getKey().equals(e2.getKey())){
                    System.out.println(e1.getKey() + "\n  HP: " + e1.getValue() + "\n  MP: " + e2.getValue());
                }
            }

        }

    }
}
