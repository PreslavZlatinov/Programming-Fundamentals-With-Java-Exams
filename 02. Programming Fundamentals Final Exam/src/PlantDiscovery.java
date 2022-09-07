import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantRarity = new LinkedHashMap<>();
        Map<String, List<Double>> plantRating = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] plantInfo = scanner.nextLine().split("<->");

            String plant = plantInfo[0];
            int rarity = Integer.parseInt(plantInfo[1]);

            if (!plantRarity.containsKey(plant)) {
                plantRarity.put(plant, rarity);
                plantRating.put(plant, new ArrayList<>());

            } else {
                plantRarity.put(plant, rarity);
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("Exhibition")) {

            String[] commandToArray = command.split("[: | \\- ]+");

            String commandType = commandToArray[0];
            String plantName = commandToArray[1];

            switch (commandType) {
                case "Rate":
                    double ratingToAdd = Double.parseDouble(commandToArray[2]);
                    if (plantRating.containsKey(plantName)) {
                        plantRating.get(plantName).add(ratingToAdd);
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "Update":
                    int newRarity = Integer.parseInt(commandToArray[2]);
                    if (plantRarity.containsKey(plantName)) {
                        plantRarity.put(plantName, newRarity);
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "Reset":
                    if (plantRating.containsKey(plantName)) {
                        plantRating.get(plantName).clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> e1 : plantRarity.entrySet()) {
            for (Map.Entry<String, List<Double>> e2 : plantRating.entrySet()) {
                if (e1.getKey().equals(e2.getKey())) {
                    double ratingSum = 0.0;
                    for (int i = 0; i < e2.getValue().size(); i++) {
                        ratingSum += e2.getValue().get(i);
                    }

                    if (ratingSum > 0) {
                        double averageRating = ratingSum / e2.getValue().size();

                        System.out.printf("- %s; Rarity: %d; Rating: %.2f\n", e1.getKey(), e1.getValue(), averageRating);
                    } else {
                        System.out.printf("- %s; Rarity: %d; Rating: 0.00\n", e1.getKey(), e1.getValue());
                    }
                }
            }

        }


    }
}
