import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Pattern patter = Pattern.compile("(.+)>(?<numbers>[0-9]{3})\\|(?<lower>[a-z]{3})\\|(?<upper>[A-Z]{3})\\|(?<symbols>[^<>]{3})<\\1");

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = patter.matcher(input);

            if(matcher.find()){
                StringBuilder encryptedPassword = new StringBuilder();
                String numbers = matcher.group("numbers");
                String lower = matcher.group("lower");
                String upper = matcher.group("upper");
                String symbols = matcher.group("symbols");
                encryptedPassword.append(numbers);
                encryptedPassword.append(lower);
                encryptedPassword.append(upper);
                encryptedPassword.append(symbols);
                System.out.println("Password: " + encryptedPassword);
            } else{
                System.out.println("Try another password!");
            }
        }
    }
}
