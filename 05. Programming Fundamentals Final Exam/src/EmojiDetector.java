import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern regLetters = Pattern.compile("([:]{2}|[*]{2})([A-Z][a-z]{2,})\\1");
        Pattern regNumbers = Pattern.compile("(?<threshold>\\d)");

        Matcher matcherLetters = regLetters.matcher(input);
        Matcher matcherNumbers = regNumbers.matcher(input);

        String numbersAsString = "";

        while (matcherNumbers.find()){
            numbersAsString += matcherNumbers.group();
        }

        long coolThreshold = 1;

        for (int i = 0; i < numbersAsString.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(numbersAsString.charAt(i)));
            coolThreshold *= digit;
        }

        int countCoolEmojis = 0;

        List<String> coolEmojis = new ArrayList<>();

        while (matcherLetters.find()){
            String emojiToCheck = matcherLetters.group();
            int charValueSum = 0;
            for (int i = 2; i < emojiToCheck.length()-2; i++) {
                charValueSum += emojiToCheck.charAt(i);
            }
            if(charValueSum>=coolThreshold){
                coolEmojis.add(matcherLetters.group());
            }
            countCoolEmojis++;
        }

        System.out.println("Cool threshold: " + coolThreshold);

        System.out.println(countCoolEmojis + " emojis found in the text. The cool ones are:");

        for (String coolEmoji : coolEmojis) {
            System.out.println(coolEmoji);
        }

    }
}
