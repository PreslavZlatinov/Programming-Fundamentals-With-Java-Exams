import java.util.*;
import java.util.stream.Collectors;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String values = scanner.nextLine();

        List<Integer> valuesList = Arrays.stream(values.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int sumValue = 0;

        for (int i = 0; i < valuesList.size(); i++) {
            sumValue += valuesList.get(i);
        }

        double averageValue = 1.0*sumValue/valuesList.size();

        List<Integer> topNumbers = new ArrayList<>();

        for (int i = 0; i < valuesList.size(); i++) {
            if(valuesList.get(i)>averageValue){
                topNumbers.add(valuesList.get(i));
            }
        }

        Collections.sort(topNumbers);
        Collections.reverse(topNumbers);

        if(topNumbers.size()>=5){
            for (int i = 0; i < 5; i++) {
                System.out.print(topNumbers.get(i) + " ");
            }
        }
        else if(topNumbers.size()==0){
            System.out.println("No");
        }
        else{

            for (int i = 0; i < topNumbers.size(); i++) {
                System.out.print(topNumbers.get(i) + " ");
            }
        }

    }
}
