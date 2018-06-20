package strings.t01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrazyLogger {
    private StringBuilder logger = new StringBuilder();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY ':' hh-mm");

    public void log(String message) {
        String s = dateFormat.format(new Date());
        logger.append(s).append(" - ").append(message).append("\n");
    }

    public void print() {
        System.out.println(logger.toString());
    }

    public void searchByPeriod(String beginTime, String endTime) throws ParseException {
        Date begin = dateFormat.parse(beginTime);
        Date end = dateFormat.parse(endTime);

        int next = 0;
        int prev = 0;
        while (next != logger.length()-1) {
            next = logger.indexOf("\n", prev);
            String line = logger.substring(prev, next);
            String currentTime = line.substring(0, 18);

            Date current = dateFormat.parse(currentTime);
            if (current.getTime() > begin.getTime() && current.getTime() < end.getTime())
                System.out.println(line);

            prev = next + 1;
        }
    }

    public String searchByString(String byString) {
        Pattern pattern = Pattern.compile(".*" + byString + ".*\\n");
        Matcher matcher = pattern.matcher(logger.toString());
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            result.append(matcher.group().trim()).append("\n");
        }

        return result.toString();
    }

    public String searchByTime(String byTime) {
        return searchByString(byTime);
    }

}
