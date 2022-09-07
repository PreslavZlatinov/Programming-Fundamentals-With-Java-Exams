import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int numberOfLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = Double.MIN_VALUE;
        int maxBonusAttendance = 0;
        for (int i = 1; i <= numberOfStudents; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());
            double totalBonus = (1.0*attendance/numberOfLectures)*(5+additionalBonus);
            if(totalBonus>maxBonus){
                maxBonus = totalBonus;
                maxBonusAttendance = attendance;
            }
        }

        System.out.printf("Max Bonus: %d.\n",Math.round(maxBonus));
        System.out.printf("The student has attended %d lectures.",maxBonusAttendance);
    }
}
