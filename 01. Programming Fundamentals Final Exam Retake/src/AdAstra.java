import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String foodInput = scanner.nextLine();

        List<Food> foodInfo = new LinkedList<>();

        Pattern pattern = Pattern.compile("([|#])(?<item>[A-Za-z ]+)\\1(?<date>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d{1,5})\\1");
        Matcher matcher = pattern.matcher(foodInput);

        int caloriesSum = 0;

        while (matcher.find()){
            String food = matcher.group("item");
            String date = matcher.group("date");
            int calories = Integer.parseInt(matcher.group("calories"));
            caloriesSum += calories;

            Food foodToAdd = new Food(food,date,calories);
            foodInfo.add(foodToAdd);
        }

        int days = caloriesSum / 2000;

        System.out.printf("You have food to last you for: %d days!\n",days);

        foodInfo.forEach(System.out::println);

    }

    static class Food{
        String food;
        String date;
        int calories;

        public Food(String food, String date, int calories) {
            this.food = food;
            this.date = date;
            this.calories = calories;
        }

        @Override
        public String toString() {
            return String.format("Item: %s, Best before: %s, Nutrition: %d",this.food,this.date,this.calories);
        }
    }
}


