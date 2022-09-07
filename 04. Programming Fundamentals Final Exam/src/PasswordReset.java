import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder password = new StringBuilder(scanner.nextLine());
        String command = scanner.nextLine();

        while(!command.equals("Done")){
            String[] commandToArray = command.split("\\s+");

            String commandType = commandToArray[0];

            switch (commandType){
                case "TakeOdd":
                    StringBuilder newPass = new StringBuilder();
                    for (int i = 1; i < password.length(); i++) {
                        if(i%2!=0){
                            newPass.append(password.charAt(i));
                        }
                    }

                    password = newPass;

                    System.out.println(password);
                    break;

                case "Cut":
                    int index = Integer.parseInt(commandToArray[1]);
                    int length = Integer.parseInt(commandToArray[2]);
                    int endIndex = index + length;

                    password.delete(index,endIndex);
                    System.out.println(password);
                    break;

                case "Substitute":
                    String substring = commandToArray[1];
                    String substitute = commandToArray[2];

                    if(password.toString().contains(substring)){
                        password = new StringBuilder(password.toString().replaceAll(substring, substitute));
                        System.out.println(password);
                    }
                    else{
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Your password is: " + password);
    }
}
