import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Integer> cityPeople = new LinkedHashMap<>();
        Map<String, Integer> cityGold = new LinkedHashMap<>();

        while (!command.equals("Sail")) {
            String[] commandToArray = command.split("\\|\\|");

            String city = commandToArray[0];
            int people = Integer.parseInt(commandToArray[1]);
            int gold = Integer.parseInt(commandToArray[2]);

            if (!cityPeople.containsKey(city)) {
                cityPeople.put(city, people);
                cityGold.put(city, gold);
            } else {
                cityPeople.put(city, cityPeople.get(city) + people);
                cityGold.put(city, cityGold.get(city) + gold);
            }

            command = scanner.nextLine();
        }

        String event = scanner.nextLine();

        while (!event.equals("End")){

            String[] eventToArray = event.split("=>");

            String eventType = eventToArray[0];

            String town = eventToArray[1];

            switch (eventType){
                case "Plunder":
                    int people = Integer.parseInt(eventToArray[2]);
                    int gold = Integer.parseInt(eventToArray[3]);

                    cityPeople.put(town,cityPeople.get(town) - people);
                    cityGold.put(town,cityGold.get(town) - gold);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n",town,gold,people);

                    if(cityPeople.get(town)<=0 || cityGold.get(town) <= 0){
                        System.out.printf("%s has been wiped off the map!\n",town);
                        cityPeople.remove(town);
                        cityGold.remove(town);
                    }

                    break;

                case "Prosper":
                    if(Integer.parseInt(eventToArray[2])<0){
                        System.out.println("Gold added cannot be a negative number!");
                    }else{
                        cityGold.put(town,cityGold.get(town)+Integer.parseInt(eventToArray[2]));
                        int goldAtTheMoment = cityGold.get(town);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.\n",Integer.parseInt(eventToArray[2]),town, goldAtTheMoment);
                    }
                    break;
            }

            event = scanner.nextLine();
        }

        if(!cityPeople.isEmpty()) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n",cityPeople.size());
            for (Map.Entry<String, Integer> e1 : cityPeople.entrySet()) {
                for (Map.Entry<String, Integer> e2 : cityGold.entrySet()) {
                    if (e1.getKey().equals(e2.getKey())) {
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n", e1.getKey(), e1.getValue(), e2.getValue());
                    }
                }
            }
        }else{
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }
}
