import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int 세로, 가로;
    private static int maxSafeArea = Integer.MIN_VALUE;
    private static int[][] rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        세로 = Integer.parseInt(st.nextToken());
        가로 = Integer.parseInt(st.nextToken());

        rooms = new int[세로][가로];

        for (int i = 0; i < 세로; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 가로; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        createWall(0);

        System.out.println(maxSafeArea);
    }

    private static void createWall(int wall) {
        if (wall == 3) {
            countSafeArea();
            return;
        }

        for (int i = 0; i < 세로; i++) {
            for (int j = 0; j < 가로; j++) {
                if (rooms[i][j] == 0) {
                    rooms[i][j] = 1;
                    createWall(wall+1);
                    rooms[i][j] = 0;
                }
            }
        }
    }

    private static void countSafeArea() {
        int[][] copyRooms = new int[세로][가로];
        // 맵 배열 복사
        for (int i = 0; i < 세로; i++) {
            copyRooms[i] = Arrays.copyOfRange(rooms[i], 0, 가로);
        }

        // 바이러스 감염
        for (int i = 0; i < 세로; i++) {
            for (int j = 0; j < 가로; j++) {
                if (copyRooms[i][j] == 2) {
                    virus(copyRooms, i, j);
                }
            }
        }

        // 빈방 찾기
        int cnt = 0;
        for (int i = 0; i < 세로; i++) {
            for (int j = 0; j < 가로; j++) {
                if (copyRooms[i][j] == 0) {
                    cnt++;
                }
            }
        }

        maxSafeArea = Math.max(maxSafeArea, cnt);
    }

    private static void virus(int[][] copyRooms, int r, int c) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> positions = new LinkedList<>();

        positions.add(new int[]{r, c});

        while(!positions.isEmpty()) {
            int[] cur = positions.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (checkIndex(nr, nc) && copyRooms[nr][nc] == 0) {
                    copyRooms[nr][nc] = 3;
                    positions.add(new int[]{nr, nc});
                }
            }
        }
    }

    private static boolean checkIndex(int r, int c) {
        return r >= 0 && r < 세로 && c >= 0 && c < 가로;
    }
}