import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(value -> Integer.parseInt(value)).toArray();

        String inputString = scanner.nextLine();
        while (!(inputString.equals("end"))) {
            String[] inputToArray = inputString.split(" ");

            if (inputToArray[0].equals("swap")) {
                int firstValue = Integer.parseInt(inputToArray[1]);
                int secondValue = Integer.parseInt(inputToArray[2]);
                int oldValue = inputLine[firstValue];
                inputLine[firstValue] = inputLine[secondValue];
                inputLine[secondValue] = oldValue;
            } else if (inputToArray[0].equals("multiply")) {
                int firstValue = Integer.parseInt(inputToArray[1]);
                int secondValue = Integer.parseInt(inputToArray[2]);
                inputLine[firstValue] = inputLine[firstValue] * inputLine[secondValue];
            } else if (inputToArray[0].equals("decrease")) {
                for (int i = 0; i < inputLine.length; i++) {
                    inputLine[i]--;
                }
            }

            inputString = scanner.nextLine();
        }

        for (int i = 0; i < inputLine.length; i++) {
            if (i == inputLine.length - 1) {
                System.out.print(inputLine[i]);
            } else {
                System.out.print(inputLine[i] + ", ");
            }
        }
    }
}
