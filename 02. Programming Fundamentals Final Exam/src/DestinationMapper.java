import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String places = scanner.nextLine();

        List<String> validDestinations = new LinkedList<>();

        Pattern pattern = Pattern.compile("([=|/])(?<place>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(places);

        while (matcher.find()) {
            validDestinations.add(matcher.group("place"));
        }

        int lengthSum = 0;

        System.out.print("Destinations: ");
        for (int i = 0; i < validDestinations.size(); i++) {
            int wordLength = validDestinations.get(i).length();
            lengthSum += wordLength;
            if(i==validDestinations.size()-1){
                System.out.print(validDestinations.get(i));
            }
            else{
                System.out.print(validDestinations.get(i) + ", ");
            }
        }

        System.out.println("\nTravel Points: " + lengthSum);
    }
}
