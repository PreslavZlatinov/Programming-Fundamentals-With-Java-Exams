import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWordsV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern patter = Pattern.compile("([#@])(?<first>[A-Za-z]{3,})\\1{2}(?<second>[A-Za-z]{3,})\\1");
        Matcher matcher = patter.matcher(input);

        List<String> mirrorWords = new LinkedList<>();

        int wordPairsCount = 0;

        while (matcher.find()){
            wordPairsCount++;
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");

            StringBuilder firstWordReversed = new StringBuilder();
            StringBuilder secondWordReversed = new StringBuilder();

            for (int i = firstWord.length()-1; i >= 0 ; i--) {
                firstWordReversed.append(firstWord.charAt(i));
            }

            for (int i = secondWord.length()-1; i >= 0 ; i--) {
                secondWordReversed.append(secondWord.charAt(i));
            }

            if(firstWordReversed.toString().equals(secondWord) && secondWordReversed.toString().equals(firstWord)){
                String wordToAdd = firstWord + " <=> " + secondWord;
                mirrorWords.add(wordToAdd);
            }
        }

        if(wordPairsCount==0){
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        }else{
            System.out.printf("%d word pairs found!\n",wordPairsCount);
            if(mirrorWords.isEmpty()){
                System.out.println("No mirror words!");
            }else{
                System.out.println("The mirror words are:");
                for (int i = 0; i < mirrorWords.size(); i++) {
                    if(i == mirrorWords.size()-1){
                        System.out.print(mirrorWords.get(i));
                    }else{
                        System.out.print(mirrorWords.get(i) + ", ");
                    }
                }
            }
        }
    }
}
