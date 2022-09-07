import java.util.*;

public class PlantDiscoveryV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantRarity = new LinkedHashMap<>();
        Map<String, List<Double>> plantRating = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] plantInfo = scanner.nextLine().split("<->");
            if (!plantRarity.containsKey(plantInfo[0])) {
                plantRarity.put(plantInfo[0], Integer.parseInt(plantInfo[1]));
                plantRating.put(plantInfo[0], new ArrayList<>());
            } else {
                plantRarity.put(plantInfo[0], Integer.parseInt(plantInfo[1]));
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Exhibition")) {

            String[] commandArray = command.split("[: -]+");

            String commandType = commandArray[0];
            String plant = commandArray[1];

            switch (commandType) {
                case "Rate":
                    if (plantRating.containsKey(plant)) {
                        plantRating.get(plant).add(Double.parseDouble(commandArray[2]));
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "Update":
                    if (plantRating.containsKey(plant)) {
                        plantRarity.put(plant, Integer.parseInt(commandArray[2]));
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "Reset":
                    if (plantRating.containsKey(plant)) {
                        plantRating.get(plant).clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> e1 : plantRarity.entrySet()) {
            double ratingSum = 0.0;
            for (Map.Entry<String, List<Double>> e2 : plantRating.entrySet()) {
                if (e1.getKey().equals(e2.getKey())) {
                    for (int i = 0; i < e2.getValue().size(); i++) {
                        ratingSum += e2.getValue().get(i);
                    }

                    if(ratingSum>0) {
                        System.out.printf("- %s; Rarity: %d; Rating: %.2f\n", e1.getKey(), e1.getValue(), ratingSum / e2.getValue().size());
                    }else{
                        System.out.printf("- %s; Rarity: %d; Rating: 0.00\n", e1.getKey(), e1.getValue());
                    }
                }
            }
        }

    }
}
