import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String prices = scanner.nextLine();

        double taxes = 0;
        double priceWithoutTaxes = 0;

        while(!(prices.equals("special")) || !(prices.equals("regular"))){
            if(prices.equals("special") || prices.equals("regular")){
                break;
            }
            Double pricesToDouble = Double.parseDouble(prices);
            if(pricesToDouble <0){
                System.out.println("Invalid price!");
            }
            else{
                priceWithoutTaxes += pricesToDouble;
                taxes += pricesToDouble*0.2;
            }

            prices = scanner.nextLine();
        }

        double totalPriceWithTaxes = priceWithoutTaxes + taxes;

        if(priceWithoutTaxes==0){
            System.out.println("Invalid order!");
        }
        else if(prices.equals("special")){
            totalPriceWithTaxes -= totalPriceWithTaxes*0.1;
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n",priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$\n",taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$",totalPriceWithTaxes);
        }
        else if(prices.equals("regular")){
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n",priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$\n",taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$",totalPriceWithTaxes);
        }

    }
}
