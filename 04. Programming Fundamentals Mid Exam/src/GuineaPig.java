import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double food = Double.parseDouble(scanner.nextLine());
        double hay = Double.parseDouble(scanner.nextLine());
        double cover = Double.parseDouble(scanner.nextLine());
        double weight = Double.parseDouble(scanner.nextLine());

        double foodToGrams = food*1000;
        double hayToGrams = hay*1000;
        double coverToGrams = cover*1000;
        double weightToGrams = weight*1000;

        //double weightOneThird = Math.round((weightToGrams/3)*100.0)/100.0;

        for (int i = 1; i <= 30; i++) {
            foodToGrams -= 300;
            if(i%3==0){
                coverToGrams -= weightToGrams * 1/3;
            }
            if(i%2==0){
                hayToGrams -= foodToGrams * 0.05;
            }
            if(foodToGrams <=0 || hayToGrams <= 0 || coverToGrams<=0){
                System.out.println("Merry must go to the pet store!");
                break;
            }
        }

        if(foodToGrams >= 0 && hayToGrams >= 0 && coverToGrams>= 0){
            double finalFood = foodToGrams/1000;
            double finalHay = hayToGrams/1000;
            double finalCover = coverToGrams/1000;
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",finalFood,finalHay,finalCover);
        }
    }
}
