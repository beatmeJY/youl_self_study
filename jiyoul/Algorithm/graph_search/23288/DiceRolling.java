import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiceRolling {

    static int[][] map;
    static int[] dice = {2,4,1,3,5,6};;
    static int rollingCount;
    static int nowCount = 0;
    static int totalScore = 0;
    static int nowMapWidth = 0;
    static int nowMapHeight = 0;
    static int nowDirection = 2;

    public static void main(String[] args) {
        inputValue();
        startRolling();
        System.out.println(totalScore);
    }

    private static void startRolling() {
        if (rollingCount == 0) {
            return;
        }
        while (nowCount < rollingCount){
            nowCount++;
            setDirection();
            rolling();
        }
    }

    private static void setDirection() {
        if (dice[5] > map[nowMapWidth][nowMapHeight]) {
            nowDirection++;
            if (nowDirection > 4) {
                nowDirection = 1;
            }
        }
        if (dice[5] < map[nowMapWidth][nowMapHeight]) {
            nowDirection--;
            if (nowDirection < 1) {
                nowDirection = 4;
            }
        }
    }

    private static void rolling() {
        switch (nowDirection) {
            case 1 : eastRolling();
            case 2 : westRolling();
            case 3 : southRolling();
            case 4 : northRolling();
        }
        totalScore += map[nowMapWidth][nowMapHeight];
    }

    static void createMap(String[] array, int mapHeight) {
        if (map == null) {
            map = new int[Integer.parseInt(array[0])][Integer.parseInt(array[1])];
            rollingCount = Integer.parseInt(array[2]);
            return;
        }
        for (int index = 0; index < array.length; index++) {
            map[mapHeight][index] = Integer.parseInt(array[index]);
        }
    }

    private static int[] eastRolling() {
        nowMapWidth++;
        return new int[] {dice[0], dice[2], dice[3], dice[5], dice[4], dice[1]};
    }

    private static int[] westRolling() {
        nowMapWidth--;
        return new int[] {dice[0], dice[5], dice[1], dice[2], dice[4], dice[3]};
    }

    private static int[] southRolling() {
        nowMapHeight++;
        return new int[] {dice[5], dice[1], dice[0], dice[3], dice[2], dice[4]};
    }

    private static int[] northRolling() {
        nowMapHeight--;
        return new int[] {dice[2], dice[1], dice[4], dice[3], dice[5], dice[0]};
    }


    private static void inputValue() {
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in))
        {
            String line;
            int mapHeight = 0;
            while ((line = buffer.readLine()) != null && !line.equals(""))
            {
                String[] tokens = line.split("\\s");
                createMap(tokens, mapHeight);
                mapHeight++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
