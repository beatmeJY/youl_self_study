import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ResearchInstitute {

    public static void main(String[] args) {
        int[][] arrays = inputValue();
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.println("arrays[" + i + "][" + j + "] = " + arrays[i][j]);
            }
        }
    }

    private static int[][] inputValue() {
        int[][] results = new int[8][8];
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
