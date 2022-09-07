import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            String differentStringEveryTime = scanner.nextLine();
            Pattern pattern = Pattern.compile("@#+(?<product>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+");
            Matcher matcher = pattern.matcher(differentStringEveryTime);
            StringBuilder groupCode = new StringBuilder();

            if (matcher.find()) {
                String product = matcher.group("product");
                for (int j = 0; j < product.length(); j++) {
                    if (Character.isDigit(product.charAt(j))) {
                        groupCode.append(product.charAt(j));
                    }
                }

                if (groupCode.length() != 0) {
                    System.out.println("Product group: " + groupCode);
                } else {
                    System.out.println("Product group: 00");
                }
            } else {
                System.out.println("Invalid barcode");
            }
        }

    }
}
