import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String,Integer> townPopulation = new LinkedHashMap<>();
        Map<String,Integer> townGold = new LinkedHashMap<>();

        while(!input.equals("Sail")){

            String[] inputToArray = input.split("\\|\\|");
            String town = inputToArray[0];
            int population = Integer.parseInt(inputToArray[1]);
            int gold = Integer.parseInt(inputToArray[2]);

            if(!townPopulation.containsKey(town)){
                townPopulation.put(town,population);
            }
            else{
                townPopulation.put(town,townPopulation.get(town)+population);
            }

            if(!townGold.containsKey(town)){
                townGold.put(town,gold);
            }
            else{
                townGold.put(town,townGold.get(town)+gold);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("End")){
            String[] inputToArray = input.split("=>");

            String commandType = inputToArray[0];
            String town = inputToArray[1];
            switch (commandType){
                case "Plunder":

                    int gold = Integer.parseInt(inputToArray[3]);
                    int people = Integer.parseInt(inputToArray[2]);

                    if(townGold.get(town)>=gold && townPopulation.get(town)>=people){
                        townGold.put(town,townGold.get(town)-gold);
                        townPopulation.put(town,townPopulation.get(town)-people);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n",town,gold,people);
                    }

                    if(townGold.get(town)==0 || townPopulation.get(town)==0){
                        System.out.println(town + " has been wiped off the map!");
                        townGold.remove(town);
                        townPopulation.remove(town);
                    }

                    break;

                case "Prosper":
                    int goldToAdd = Integer.parseInt(inputToArray[2]);
                    if(goldToAdd>0){
                        townGold.put(town,townGold.get(town)+goldToAdd);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",goldToAdd,town,townGold.get(town));
                    }
                    else{
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        if(!townGold.isEmpty()){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n",townGold.size());
            for (Map.Entry<String, Integer> e1 : townPopulation.entrySet()) {
                for (Map.Entry<String, Integer> e2 : townGold.entrySet()) {
                    if(e1.getKey().equals(e2.getKey())) {
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n", e1.getKey(), e1.getValue(), e2.getValue());
                    }
                }
            }
        }
        else{
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }
}
