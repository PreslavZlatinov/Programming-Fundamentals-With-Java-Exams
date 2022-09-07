import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,String> pieceComposer = new LinkedHashMap<>();
        Map<String,String> pieceKey = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] pieceInfo = scanner.nextLine().split("\\|");

            String piece = pieceInfo[0];
            String composer = pieceInfo[1];
            String key = pieceInfo[2];

            pieceComposer.put(piece,composer);
            pieceKey.put(piece,key);
        }

        String command = scanner.nextLine();

        while (!command.equals("Stop")){

            String[] commandToArray = command.split("\\|");

            String commandType = commandToArray[0];
            String pieceName = commandToArray[1];

            switch (commandType){
                case "Add":
                    String composer = commandToArray[2];
                    String key = commandToArray[3];
                    if(!pieceComposer.containsKey(pieceName)){
                        pieceComposer.put(pieceName,composer);
                        pieceKey.put(pieceName,key);
                        System.out.printf("%s by %s in %s added to the collection!\n",pieceName,composer,key);
                    }else {
                        System.out.println(pieceName + " is already in the collection!");
                    }
                    break;

                case "Remove":
                    if(pieceComposer.containsKey(pieceName)){
                        pieceComposer.remove(pieceName);
                        pieceKey.remove(pieceName);
                        System.out.printf("Successfully removed %s!\n",pieceName);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n",pieceName);
                    }
                    break;

                case "ChangeKey":
                    if(pieceKey.containsKey(pieceName)){
                        String newKey = commandToArray[2];
                        pieceKey.put(pieceName,newKey);
                        System.out.printf("Changed the key of %s to %s!\n",pieceName,newKey);
                    }else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.\n",pieceName);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        for (Map.Entry<String, String> e1 : pieceComposer.entrySet()) {
            for (Map.Entry<String, String> e2 : pieceKey.entrySet()) {
                if(e1.getKey().equals(e2.getKey())){
                    System.out.printf("%s -> Composer: %s, Key: %s\n",e1.getKey(),e1.getValue(),e2.getValue());
                }
            }

        }

    }
}
