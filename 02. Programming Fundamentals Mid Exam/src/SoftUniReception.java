import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());

       int studentsCount = Integer.parseInt(scanner.nextLine());
       int hoursCount = 0;
       int studentsPerHour = firstEmployee + secondEmployee + thirdEmployee;

       while(studentsCount>0){
            studentsCount -= studentsPerHour;
            hoursCount++;
            if(hoursCount%4==0){
                hoursCount++;

            }
        }
        System.out.printf("Time needed: %dh.",hoursCount);
    }
}
