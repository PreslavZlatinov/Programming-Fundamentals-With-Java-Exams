import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=/])(?<city>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);

        List<String> destinations = new LinkedList<>();

        while (matcher.find()){
            String city = matcher.group("city");
            destinations.add(city);
        }

        int travelPoints = 0;

        System.out.print("Destinations: ");

        for (int i = 0; i < destinations.size(); i++) {
            if(i== destinations.size()-1){
                System.out.print(destinations.get(i));
                travelPoints += destinations.get(i).length();
            }
            else{
                System.out.print(destinations.get(i)+", ");
                travelPoints += destinations.get(i).length();
            }
        }

        System.out.println("\nTravel Points: " + travelPoints);

    }
}
