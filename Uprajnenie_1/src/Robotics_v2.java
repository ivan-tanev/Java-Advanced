import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Robotics_v2 {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> inputData = Arrays.stream(reader.readLine().split(";"))
                .collect(Collectors.toList());
        int[] time = Arrays.stream(reader.readLine().split(":"))
                .mapToInt(Integer::parseInt).toArray();
        int startTime = time[0]*3600 +time[1]*60 +time[2];
        String[] robotNames = new String[inputData.size()];
        int[] robotTime = new int[inputData.size()];
        int[] robotCurrentTime = new int[robotTime.length];

        for (int i = 0; i <inputData.size() ; i++) {
            String[] tokens = inputData.get(i).split("-");
            robotNames[i] = tokens[0];
            robotTime[i] = Integer.parseInt(tokens[1]);
        }
        Deque<String> queue = new ArrayDeque<>();
        String input ="";
        while (!"End".equals(input=reader.readLine())){
            queue.offer(input);
        }

        while (!queue.isEmpty()){
            startTime++;
            String product =queue.poll();
            boolean allBusy = true;
            for (int i = 0; i <robotCurrentTime.length ; i++) {
                if (robotCurrentTime[i] !=0){
                    robotCurrentTime[i]--;
                }
            }
            for (int i = 0; i <robotNames.length ; i++) {
                if (robotCurrentTime[i] ==0){
                    robotCurrentTime[i] = robotTime[i];
                    int hour = (startTime /3600) % 24;
                    int minute = (startTime /60) %60;
                    int seconds = startTime % 60;
                    System.out.printf("%s - %s [%s]%n", robotNames[i], product,
                            String.format("%02d:%02d:%02d", hour, minute, seconds));
                    allBusy = false;
                    break;
                }

            }
            if (allBusy){
                queue.offer(product);
            }


        }


    }
}