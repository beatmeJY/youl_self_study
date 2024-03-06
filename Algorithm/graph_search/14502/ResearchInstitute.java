import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ResearchInstitute {

    Node[][] roomList;

    public void main(String[] args) {
        int[][] arrays = inputValue();
//        for (int i = 0; i < arrays.length; i++) {
//            for (int j = 0; j < arrays[i].length; j++) {
//                System.out.println("arrays[" + i + "][" + j + "] = " + arrays[i][j]);
//            }
//        }
        createNode(arrays);
//        System.out.println(result);
    }

    private void createNode(int[][] arrays) {
        Node node;
        for (int i = 1; i <= arrays[0][0]; i++) {
            for (int j = 0; j < arrays[0][1]; j++) {
                if (i == 1 || j == 0) {
                    node = new Node(arrays[i][j]);
                    roomList[i - 1][j] = node;
                    

                }
            }
        }

    }

    class Node {
        Node up;
        Node right;
        Node down;
        Node left;
        int value;
        int initValue;
        boolean check = false;

        public Node(int value) {
            this.initValue = value;
            this.value = value;
        }

        public void init() {
            this.value = initValue;
            boolean check = false;
        }

        public boolean checkInfection() {
            if (value == 1) {
                return false;
            }
            if (value == 2) {
                return true;
            }
            if (value == 0) {
                if ((up != null && up.checkInfection()) ||
                    (right != null && right.checkInfection()) ||
                    (down != null && down.checkInfection()) ||
                    (left != null && left.checkInfection())) {
                    value = 2;
                    return true;
                }
                return true;
            }
            return false;
        }
    }



    public static void infection() {

    }

    private static int[][] inputValue() {
        int[][] results = new int[9][8];
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in))
        {
            String line;
            int count = 0;
            while ((line = buffer.readLine()) != null && !line.equals(""))
            {
                String[] stringLine = line.split("\\s");
                for (int i = 0; i < stringLine.length; i++) {
                    results[count][i] = Integer.parseInt(stringLine[i]);
                }
                count++;
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return results;
    }
}
