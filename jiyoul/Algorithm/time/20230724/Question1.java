import java.util.HashMap;
import java.util.LinkedHashMap;

public class Question1 {

    public static void main(String[] args) {
//        int[] solution = solution("2021:04:12 16:08:35", new String[]{"01:06:30:00", "01:04:12:00"});
//        int[] solution = solution("2021:04:12 16:08:35", new String[]{"01:06:30:00", "00:01:12:00"});
//        int[] solution = solution("2021:04:12 16:10:42", new String[]{"01:06:30:00"});
//        int[] solution = solution("2021:04:12 16:10:42", new String[]{"00:06:30:00"});
        int[] solution = solution("2021:04:12 16:08:35", new String[]{"01:06:30:00", "01:01:12:00", "00:00:09:25"});
        System.out.println("저축 성공 여부 : " + solution[0] + ", 저축일자 : " + solution[1]);
    }

    public static int[] solution(String s, String[] times) {
        int[] result = new int[]{1, 1};
        int minuteSecond = 60;
        int hourSecond = minuteSecond * 60;
        int daySecond = hourSecond * 24;
        int monthSecond = daySecond * 30;
        int yearSecond = monthSecond * 12;

        s = s.replace(" ", ":");
        String[] startDay = s.split(":");

        long startDaySecond = (Long.parseLong(startDay[0]) * yearSecond) + (Integer.parseInt(startDay[1]) * monthSecond) + (Integer.parseInt(startDay[2]) * daySecond) +
                (Integer.parseInt(startDay[3]) * hourSecond) + (Integer.parseInt(startDay[4]) * minuteSecond) + Integer.parseInt(startDay[5]);

        long startDaySecond1 = startDaySecond;
        HashMap<Long, Integer> resultMap = new LinkedHashMap<>();
        resultMap.put(startDaySecond1 / daySecond, 1);
        for (String time : times) {
            String[] split = time.split(":");
            long plusDaySecond = Integer.parseInt(split[0]) * daySecond + (Integer.parseInt(split[1]) * hourSecond) + (Integer.parseInt(split[2]) * minuteSecond) + Integer.parseInt(split[3]);
            startDaySecond1 = startDaySecond1 + plusDaySecond;
            Long day = startDaySecond1 / daySecond;
            resultMap.put(day, resultMap.computeIfAbsent(day, k -> 0) + 1);
        }

        long startDaySecond2 = startDaySecond;
        long lastDaySecond = 0l;
        for (Long aLong : resultMap.keySet()) {
            startDaySecond2 = startDaySecond2 + daySecond;
            if (aLong >= startDaySecond2) result[0] = 0;
            lastDaySecond = aLong;
        }

        result[1] = (int) (lastDaySecond - startDaySecond / daySecond) + 1;
        return result;
    }
}
