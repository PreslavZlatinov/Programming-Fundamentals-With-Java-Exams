import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShipStatus = Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warshipStatus = Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        int maximumHealth = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();

        boolean isWinner = false;
        while (!(command.equals("Retire"))) {

            String[] commandArray = command.split("\\s+");

            if (command.contains("Fire")) {
                int index = Integer.parseInt(commandArray[1]);
                int damage = Integer.parseInt(commandArray[2]);
                if (index <= warshipStatus.size() - 1 && index>=0) {
                    int warshipHealth = warshipStatus.get(index);
                    warshipStatus.set(index, warshipHealth - damage);

                    if (warshipStatus.get(index) <= 0) {
                        System.out.println("You won! The enemy ship has sunken.");
                        isWinner = true;
                        break;
                    }
                }
            } else if (command.contains("Defend")) {
                int start = Integer.parseInt(commandArray[1]);
                int end = Integer.parseInt(commandArray[2]);
                int damage = Integer.parseInt(commandArray[3]);

                if (start >= 0 && start < pirateShipStatus.size() - 1 && end > 0 && end <= pirateShipStatus.size() - 1) {
                    for (int i = start; i <= end; i++) {
                        int pirateShipHealth = pirateShipStatus.get(i);
                        pirateShipStatus.set(i, pirateShipHealth - damage);

                        if (pirateShipStatus.get(i) <= 0) {
                            System.out.println("You lost! The pirate ship has sunken.");
                            isWinner = true;
                            break;
                        }
                    }
                }
            } else if (command.contains("Repair")) {
                int index = Integer.parseInt(commandArray[1]);
                int health = Integer.parseInt(commandArray[2]);

                if (index >= 0 && index <= pirateShipStatus.size() - 1) {
                    int pirateShipHealth = pirateShipStatus.get(index);
                    pirateShipStatus.set(index,pirateShipHealth+health);
                    if (pirateShipStatus.get(index) > maximumHealth) {
                        pirateShipStatus.set(index,maximumHealth);
                    }
                }
            } else if (command.contains("Status")) {
                int count = 0;
                double healthThatNeedsRepair = maximumHealth * 0.2;
                for (int i = 0; i < pirateShipStatus.size(); i++) {
                    if (pirateShipStatus.get(i) < healthThatNeedsRepair) {
                        count++;
                    }
                }
                System.out.printf("%d sections need repair.\n", count);
            }

            command = scanner.nextLine();
        }

        if (!isWinner) {
            int pirateShip = 0;
            int warship = 0;

            for (Integer shipStatus : pirateShipStatus) {
                pirateShip += shipStatus;
            }
            System.out.printf("Pirate ship status: %d\n", pirateShip);

            for (Integer status : warshipStatus) {
                warship += status;
            }
            System.out.printf("Warship status: %d", warship);
        }


    }
}
