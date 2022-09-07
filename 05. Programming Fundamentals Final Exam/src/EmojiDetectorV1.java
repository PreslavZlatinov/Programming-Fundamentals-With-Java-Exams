import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetectorV1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern regLetters = Pattern.compile("([:]{2}|[*]{2})([A-Z][a-z]{2,})\\1");
        Pattern regNumbers = Pattern.compile("(?<threshold>\\d)");

        Matcher letterMatcher = regLetters.matcher(input);
        Matcher numberMatcher = regNumbers.matcher(input);

        String allNumbers = "";

        while (numberMatcher.find()){
            allNumbers += numberMatcher.group("threshold");
        }

        int coolThreshold = 1;

        for (int i = 0; i < allNumbers.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(allNumbers.charAt(i)));
            coolThreshold *= digit;
        }

        List<String> coolEmojis = new ArrayList<>();
        int found = 0;
        while (letterMatcher.find()){
            found++;
            String emoji = letterMatcher.group();
            int coolness = 0;
            for (int i = 2; i < emoji.length()-1; i++) {
                coolness += emoji.charAt(i);
            }

            if(coolness>= coolThreshold){
                coolEmojis.add(emoji);
            }
        }

        System.out.printf("Cool threshold: %d\n",coolThreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:\n",found);
        for (String s : coolEmojis) {
            System.out.println(s);
        }

    }
}
