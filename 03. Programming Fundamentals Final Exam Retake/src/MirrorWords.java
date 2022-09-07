import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([@#])(?<first>[A-Za-z]{3,})\\1{2}(?<second>[A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);

        Map<String, String> mirrorWords = new LinkedHashMap<>();

        int matchCount = 0;

        while (matcher.find()) {
            matchCount++;

            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");

            StringBuilder secondWordBackwards = new StringBuilder();

            for (int i = secondWord.length() - 1; i >= 0; i--) {
                secondWordBackwards.append(secondWord.charAt(i));
            }

            StringBuilder firstWordBackwards = new StringBuilder();

            for (int i = firstWord.length() - 1; i >= 0; i--) {
                firstWordBackwards.append(firstWord.charAt(i));
            }

            if (firstWordBackwards.toString().equals(secondWord) && secondWordBackwards.toString().equals(firstWord)) {
                mirrorWords.put(firstWord, secondWord);
            }
        }

        if (matchCount > 0) {
            System.out.println(matchCount + " word pairs found!");
            if (!mirrorWords.isEmpty()) {
                System.out.println("The mirror words are:");
                int i = 0;
                for (Map.Entry<String, String> entry : mirrorWords.entrySet()) {
                    if (i++ == mirrorWords.size() - 1) {
                        System.out.printf("%s <=> %s", entry.getKey(), entry.getValue());
                    } else {
                        System.out.printf("%s <=> %s, ", entry.getKey(), entry.getValue());
                    }
                }
            } else {
                System.out.println("No mirror words!");
            }
        } else {
            System.out.println("No word pairs found!");
            if(mirrorWords.isEmpty()){
                System.out.println("No mirror words!");
            }
        }
    }
}
