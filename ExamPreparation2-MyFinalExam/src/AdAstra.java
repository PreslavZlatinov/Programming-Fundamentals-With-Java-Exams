import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([|#])(?<product>[A-Za-z ]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> foods = new LinkedList<>();

        int totalCalories = 0;

        while (matcher.find()){
            foods.add("Item: " + matcher.group("product") + ", Best before: " + matcher.group("date") + ", Nutrition: " + matcher.group("calories"));
            totalCalories += Integer.parseInt(matcher.group("calories"));
        }

        System.out.printf("You have food to last you for: %d days!\n", totalCalories/2000);

        foods.forEach(System.out::println);

    }

    static class Food{
        String product;
        String date;
        int calories;

        public Food(String product, String date, int calories) {
            this.product = product;
            this.date = date;
            this.calories = calories;
        }

        @Override
        public String toString() {
            return String.format("Item: %s, Best before: %s, Nutrition: %d",this.product,this.date,this.calories);
        }
    }
}
