import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] inputLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(value -> Integer.parseInt(value)).toArray();

        String command = scanner.nextLine();

        while(!(command.equals("end"))){
            String [] commandArray = command.split("\\s+");

            if(command.contains("swap")){
                int firstValue = Integer.parseInt(commandArray[1]);
                int secondValue = Integer.parseInt(commandArray[2]);
                int oldFirstValue = inputLine[firstValue];

                inputLine[firstValue] = inputLine[secondValue];
                inputLine[secondValue] = oldFirstValue;
            }
            else if(command.contains("multiply")){
                int firstValue = Integer.parseInt(commandArray[1]);
                int secondValue = Integer.parseInt(commandArray[2]);
                int newValue = inputLine[firstValue] * inputLine[secondValue];

                inputLine[firstValue] = newValue;
            }
            else if(command.contains("decrease")){
                for (int i = 0; i < inputLine.length; i++) {
                    inputLine[i] = inputLine[i] - 1;
                }
            }
            command = scanner.nextLine();
        }

        for (int i = 0; i < inputLine.length; i++) {
            if(i==inputLine.length-1){
                System.out.print(inputLine[i]);
            }
            else{
                System.out.print(inputLine[i] + ", ");
            }
        }

    }
}
