import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PiratesV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> cityPopulation = new LinkedHashMap<>();
        Map<String, Integer> cityGold = new LinkedHashMap<>();

        String command = scanner.nextLine();

        while(!command.equals("Sail")){

            String[] cityInfo = command.split("\\|\\|");

            String city = cityInfo[0];
            int people = Integer.parseInt(cityInfo[1]);
            int gold = Integer.parseInt(cityInfo[2]);

            if(!cityPopulation.containsKey(city)){
                cityPopulation.put(city,people);
            }else{
                cityPopulation.put(city,cityPopulation.get(city)+people);
            }

            if(!cityGold.containsKey(city)){
                cityGold.put(city,gold);
            }else{
                cityGold.put(city,cityGold.get(city)+gold);
            }

            command = scanner.nextLine();
        }

        String event = scanner.nextLine();

        while (!event.equals("End")){
            String[] eventToArray = event.split("=>");

            String eventType = eventToArray[0];
            String town = eventToArray[1];

            if(eventType.equals("Plunder")){
                int peopleToKill = Integer.parseInt(eventToArray[2]);
                int goldToSteal = Integer.parseInt(eventToArray[3]);
                cityPopulation.put(town,cityPopulation.get(town)-peopleToKill);
                cityGold.put(town,cityGold.get(town)-goldToSteal);

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n",town,goldToSteal,peopleToKill);

                if(cityPopulation.get(town) <= 0 || cityGold.get(town) <= 0){
                    System.out.printf("%s has been wiped off the map!\n",town);
                    cityGold.remove(town);
                    cityPopulation.remove(town);
                }
            } else if(eventType.equals("Prosper")){
                int goldIncrease = Integer.parseInt(eventToArray[2]);
                if(goldIncrease > 0){
                    cityGold.put(town,cityGold.get(town)+goldIncrease);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",goldIncrease,town, cityGold.get(town));
                } else{
                    System.out.println("Gold added cannot be a negative number!");
                }
            }

            event = scanner.nextLine();
        }

        if(!cityPopulation.isEmpty()){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", cityPopulation.size());
            for (Map.Entry<String, Integer> e1 : cityPopulation.entrySet()) {
                for (Map.Entry<String, Integer> e2 : cityGold.entrySet()) {
                    if(e1.getKey().equals(e2.getKey())){
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n",e1.getKey(),e1.getValue(),e2.getValue());
                    }
                }

            }
        } else{
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
