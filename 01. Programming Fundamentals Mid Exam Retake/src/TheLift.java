import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());
        int[] wagons = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(value -> Integer.parseInt(value)).toArray();
        boolean isEmpty = false;


        for (int i = 0; i < wagons.length; i++) {
            if(peopleCount <= 0){
                break;
            }
            if(peopleCount>=4 && wagons[i]==0) {
                peopleCount -= 4;
                wagons[i] += 4;
            }
            else if(wagons[i]>0 && wagons[i]<4){
                if(peopleCount>=4){
                    peopleCount -= 4- wagons[i];
                    wagons[i] += 4 - wagons[i];}
                else{
                    wagons[i] += peopleCount;
                    peopleCount -= peopleCount;
                }
            }
            else{
                if (wagons[i]+peopleCount <= 4){
                    wagons[i] += peopleCount;
                    peopleCount -= peopleCount;}
            }
        }

        for (int i = 0; i < wagons.length; i++) {
            if(wagons[i]<4){
                isEmpty = true;
                break;
            }
        }

        if(peopleCount==0 && isEmpty){
            System.out.println("The lift has empty spots!");
            for (int i : wagons) {
                System.out.print(i + " ");
            }

        }
        else if(!isEmpty && peopleCount>0){
            System.out.printf("There isn't enough space! %d people in a queue!\n",peopleCount);
            for (int i : wagons) {
                System.out.print(i + " ");
            }
        }
        else{
            for (int i : wagons) {
                System.out.print(i + " ");
            }
        }
    }
}
