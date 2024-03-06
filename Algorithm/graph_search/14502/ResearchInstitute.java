import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ResearchInstitute {


    public static void main(String[] args) {
        inputValue();
    }

    


    private static void inputValue() {
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in))
        {
            String line;
            while ((line = buffer.readLine()) != null && !line.equals(""))
            {
                String[] tokens = line.split("\\s");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
