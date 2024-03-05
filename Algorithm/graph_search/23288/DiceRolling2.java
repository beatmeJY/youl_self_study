import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class DiceRolling2 {

    static int nowMapWidth;
    static int nowMapHeight;
    public static DiceMap diceMap = new DiceMap();


    public static void main(String[] args) {
        inputValue();
    }

    class Dice {
        private static int up = 2;
        private static int down = 5;
        private static int right = 3;
        private static int left = 4;
        private static int top = 1;
        private static int bottom = 6;
        private static int temporary;

        public static int getBottom() {
            return bottom;
        }

        public Dice() {
        }

        public static void eastRolling() {
            temporary = right;
            right = top;
            top = left;
            left = bottom;
            bottom = temporary;
            nowMapWidth++;
        }

        public static void westRolling() {
            temporary = right;
            right = bottom;
            bottom = left;
            left = top;
            top = temporary;
            nowMapWidth--;
        }

        public static void southRolling() {
            temporary = top;
            top = up;
            up = bottom;
            bottom = down;
            down = temporary;
            nowMapHeight++;
        }

        public static void northRolling() {
            temporary = top;
            top = down;
            down = bottom;
            bottom = up;
            up = temporary;
            nowMapHeight--;
        }
    }

    static class DiceMap {
        int up;
        int down;
        int right;
        int left;

        public DiceMap() {
        }

        public void setMap(String[] tokens) {

        }
    }

    private static void inputValue() {
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in))
        {
            String line;
            DiceMap lastMap = diceMap;
            while ((line = buffer.readLine()) != null && !line.equals("")) {
                String[] tokens = line.split("\\s");
                lastMap.setMap(tokens);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
