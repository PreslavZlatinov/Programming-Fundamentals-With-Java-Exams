import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIIIV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Integer> carMiles = new LinkedHashMap<>();
        Map<String,Integer> carFuel = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] carInfo = scanner.nextLine().split("\\|");
            carMiles.put(carInfo[0], Integer.parseInt(carInfo[1]));
            carFuel.put(carInfo[0], Integer.parseInt(carInfo[2]));
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")){

            String[] commandToArray = command.split(" : ");
            String commandType = commandToArray[0];
            String car = commandToArray[1];

            switch (commandType){
                case "Drive":
                    int distanceToDrive = Integer.parseInt(commandToArray[2]);
                    int fuelNeeded = Integer.parseInt(commandToArray[3]);
                    if(carFuel.get(car)<fuelNeeded){
                        System.out.println("Not enough fuel to make that ride");
                    } else{
                        carMiles.put(car,carMiles.get(car) + distanceToDrive);
                        carFuel.put(car,carFuel.get(car) - fuelNeeded);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n",car,distanceToDrive,fuelNeeded);
                    }

                    if(carMiles.get(car)>=100000){
                        System.out.printf("Time to sell the %s!\n",car);
                        carMiles.remove(car);
                        carFuel.remove(car);
                    }

                    break;

                case "Refuel":
                    int refuel = Integer.parseInt(commandToArray[2]);
                    int currentFuel = carFuel.get(car);
                    carFuel.put(car,carFuel.get(car) + refuel);
                    if(carFuel.get(car)>75){
                        carFuel.put(car,75);
                        System.out.printf("%s refueled with %d liters\n",car,75-currentFuel);
                    } else{
                        System.out.printf("%s refueled with %d liters\n",car,refuel);
                    }
                    break;

                case "Revert":
                    int kmDecrease = Integer.parseInt(commandToArray[2]);
                    carMiles.put(car,carMiles.get(car) - kmDecrease);
                    if(carMiles.get(car) >= 10000){
                        System.out.printf("%s mileage decreased by %d kilometers\n",car,kmDecrease);
                    } else{
                        carMiles.put(car,10000);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> e1 : carMiles.entrySet()) {
            for (Map.Entry<String, Integer> e2 : carFuel.entrySet()) {
                if(e1.getKey().equals(e2.getKey())){
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",e1.getKey(),e1.getValue(),e2.getValue());
                }
            }

        }

    }
}
