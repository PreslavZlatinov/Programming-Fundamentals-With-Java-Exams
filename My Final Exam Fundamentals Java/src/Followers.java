import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Followers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Integer> followerReactions = new LinkedHashMap<>();

        while (!command.equals("Log out")){

            String[] commandArray = command.split(": ");

            String commandType = commandArray[0];
            String username = commandArray[1];

            switch (commandType){
                case "New follower":
                    if(!followerReactions.containsKey(username)){
                        followerReactions.put(username,0);
                    }
                    break;

                case "Like":
                    int reactionCount  = Integer.parseInt(commandArray[2]);
                    if(!followerReactions.containsKey(username)){
                        followerReactions.put(username,reactionCount);
                    } else{
                        followerReactions.put(username,followerReactions.get(username) + reactionCount);
                    }
                    break;

                case "Comment":
                    if(!followerReactions.containsKey(username)){
                        followerReactions.put(username,1);
                    } else{
                        followerReactions.put(username,followerReactions.get(username) + 1);
                    }
                    break;

                case "Blocked":
                    if(!followerReactions.containsKey(username)){
                        System.out.println(username + " doesn't exist.");
                    } else{
                        followerReactions.remove(username);
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(followerReactions.size() + " followers");
        for (Map.Entry<String, Integer> entry : followerReactions.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(),entry.getValue());
        }

    }
}
