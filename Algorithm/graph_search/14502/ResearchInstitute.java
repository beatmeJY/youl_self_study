import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ResearchInstitute {

    public static void main(String[] args) {
        int[][] arrays = inputValue();
//        for (int i = 0; i < arrays.length; i++) {
//            for (int j = 0; j < arrays[i].length; j++) {
//                System.out.println("arrays[" + i + "][" + j + "] = " + arrays[i][j]);
//            }
//        }
        int result = search(arrays);
        System.out.println(result);
    }

    public static int search(int[][] arrays) {
        int result = 0;
        for (int i = 0; i < arrays[0][0]; i++) {
            for (int j = 0; j < arrays[0][1]; j++) {

            }
        }
        return result;
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
