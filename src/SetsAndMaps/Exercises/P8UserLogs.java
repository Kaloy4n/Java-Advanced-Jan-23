package SetsAndMaps.Exercises;

import java.util.*;

public class P8UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // username -> list of all IPs
        // for each IP -> count of occurrence

        TreeMap<String,LinkedHashMap<String, Integer>> data = new TreeMap<>();

        String input = scanner.nextLine();

        while(!input.equals("end")) {
            //input "IP=192.23.30.40 message='Hello&derps.' user=destroyer"
            //input.split(" ") -> ["IP=192.23.30.40", "message='Hello&derps.'", "user=destroyer"]
            //input.split(" ")[0] -> ["IP=192.23.30.40".split("=") -> ["IP", "92.23.30.40"]
            //input.split(" ")[1] -> ["message='Hello&derps.'".split("=") -> ["message", "'Hello&derps.'"]
            //input.split(" ")[2] -> ["user=destroyer".split("=") -> ["user", "destroyer"]

            String ip = input.split("\\s+")[0].split("=")[1];
            //String message = input.split("\\s+")[1].split("=")[1];
            String userName = input.split("\\s+")[2].split("=")[1];

            data.putIfAbsent(userName, new LinkedHashMap<>());

            Map<String, Integer> currentIps = data.get(userName);

            currentIps.putIfAbsent(ip, 0);
            currentIps.put(ip, currentIps.get(ip) + 1);
            input = scanner.nextLine();
        }

        for (String userName : data.keySet()) {
            System.out.println(userName + ": ");
            //ip addresses of the usernames
            Map<String, Integer> currentIps = data.get(userName);

            // count of IPs, which are stored as keys
            int countIps = currentIps.size();

            for (String ip : currentIps.keySet()) {
                if (countIps != 1) {
                    //when is not my last IP address
                    System.out.print(ip + " => " + currentIps.get(ip) + ", ");
                } else {
                    //when is my last IP address
                    System.out.println(ip + " => " + currentIps.get(ip) + ".");
                }
                countIps--;
            }
        }
    }
}
