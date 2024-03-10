import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ResearchInstitute {

    int mapX;
    int mapY;
    int[][] maps;

    int resultMaxCount = Integer.MIN_VALUE;

    public void main(String[] args) {
        inputValue();
        start();
        System.out.println(resultMaxCount);
    }

    private void start() {
        // 빈칸들 벽 세우기
        setWall(0);
    }

    private void setWall(int wallCount) {
        if (wallCount == 3) {
            // 감염 시작
            startInfection();
            // 빈칸 찾기


            return;
        }

        // 벽 세우기
        for (int i = 0; i < mapY; i++) {
            for (int j = 0; j < mapX; j++) {
                if (maps[i][j] == 0) {
                    maps[i][j] = 1;
                    setWall(wallCount++);
                    maps[i][j] = 0;
                }
            }
        }
    }

    private void startInfection() {


    }

    private void inputValue() {
        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in))
        {
            // 맵 최대 크기 구하기
            String line = buffer.readLine();
            String[] firstLine = line.split("\\s");
            mapX = Integer.parseInt(firstLine[1]);
            mapY = Integer.parseInt(firstLine[0]);

            // 맵 만들기
            int count = 0;
            while ((line = buffer.readLine()) != null && !line.equals("")) {
                String[] stringLine = line.split("\\s");
                for (int i = 0; i < stringLine.length; i++) {
                    maps[count][i] = Integer.parseInt(stringLine[i]);
                }
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
