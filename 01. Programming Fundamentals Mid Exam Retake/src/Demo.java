import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    //The Lift

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleWaiting = Integer.parseInt(scanner.nextLine());
        int[] currentState = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(value -> Integer.parseInt(value)).toArray();

        for (int i = 0; i < currentState.length; i++) {
            if (peopleWaiting <= 0) {
                break;
            }
            if (currentState[i] == 0 && peopleWaiting>=4) {
                currentState[i] += 4;
                peopleWaiting -= 4;
            }
            else if(currentState[i]>0 && currentState[i]<4){
                if(peopleWaiting>=4){
                    peopleWaiting -= 4 - currentState[i];
                    currentState[i] += 4 - currentState[i];
                }
                else{
                    currentState[i] += peopleWaiting;
                    peopleWaiting -= peopleWaiting;
                }
            }
            else {
                if(currentState[i] + peopleWaiting <=4){
                    currentState[i] += peopleWaiting;
                    peopleWaiting -= peopleWaiting;
                }
            }
        }

        boolean isEmpty = false;

        for (int i : currentState) {
            if (i < 4) {
                isEmpty = true;
                break;
            }
        }

        if (peopleWaiting == 0 && isEmpty) {
            System.out.println("The lift has empty spots!");
            for (int i : currentState) {
                System.out.print(i + " ");
            }
        } else if (peopleWaiting > 0 && !isEmpty) {
            System.out.printf("There isn't enough space! %d people in a queue!\n", peopleWaiting);
            for (int i : currentState) {
                System.out.print(i + " ");
            }
        } else {
            for (int i : currentState) {
                System.out.print(i + " ");
            }

        }
    }
}
