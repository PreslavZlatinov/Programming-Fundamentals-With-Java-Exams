import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCars = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> carMiles = new LinkedHashMap<>();
        Map<String, Integer> carFuel = new LinkedHashMap<>();

        for (int i = 0; i < numberCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\|");

            String car = carInfo[0];
            int mileage = Integer.parseInt(carInfo[1]);
            int fuel = Integer.parseInt(carInfo[2]);

            carMiles.put(car, mileage);
            carFuel.put(car, fuel);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")) {

            String[] commandToArray = command.split(" : ");

            String commandType = commandToArray[0];
            String car = commandToArray[1];

            switch (commandType) {
                case "Drive":
                    int fuelAvailable = Integer.parseInt(String.valueOf(carFuel.get(car)));
                    int fuelNeeded = Integer.parseInt(commandToArray[3]);
                    int distance = Integer.parseInt(commandToArray[2]);
                    if (fuelAvailable >= fuelNeeded) {
                        carMiles.put(car, carMiles.get(car) + distance);
                        fuelAvailable = fuelAvailable - fuelNeeded;
                        carFuel.put(car, fuelAvailable);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n", car, distance, fuelNeeded);
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }

                    if (carMiles.get(car) >= 100000) {
                        System.out.printf("Time to sell the %s!\n", car);
                        carMiles.remove(car);
                        carFuel.remove(car);
                    }
                    break;
                case "Refuel":
                    int fuelToAdd = Integer.parseInt(commandToArray[2]);
                    int currentFuel = Integer.parseInt(String.valueOf(carFuel.get(car)));
                    carFuel.put(car, carFuel.get(car) + fuelToAdd);
                    int newFuel = Integer.parseInt(String.valueOf(carFuel.get(car)));
                    if (newFuel > 75) {
                        carFuel.put(car, 75);
                        System.out.printf("%s refueled with %d liters\n", car, 75 - currentFuel);
                    } else {
                        System.out.printf("%s refueled with %d liters\n", car, newFuel - currentFuel);
                    }
                    break;
                case "Revert":
                    int currentKm = Integer.parseInt(String.valueOf(carMiles.get(car)));
                    int kmDecrease = Integer.parseInt(commandToArray[2]);

                    if ((currentKm - kmDecrease) < 10000) {
                        carMiles.put(car, 10000);
                    } else {
                        carMiles.put(car, currentKm - kmDecrease);
                        System.out.printf("%s mileage decreased by %d kilometers\n", car, kmDecrease);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> e1 : carMiles.entrySet()) {
            for (Map.Entry<String, Integer> e2 : carFuel.entrySet()) {
                if (e1.getKey().equals(e2.getKey())) {
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n", e1.getKey(), e1.getValue(), e2.getValue());
                }
            }

        }

    }
}
