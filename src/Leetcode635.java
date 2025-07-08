import java.util.ArrayList;
import java.util.List;

public class Leetcode635 {


}

class LogSystem {

    List<Log> logs;

    public LogSystem() {
        logs = new ArrayList<>();
    }

    public void put(int id, String timestamp) {
        Log log = new Log(id,timestamp);
        logs.add(log);
    }

    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> logIds = new ArrayList<>();
        for(Log log : this.logs){
            if(checkValidTimestamp(log.timestamp,start,end,granularity))
                logIds.add(log.id);
        }
        return logIds;
    }

    private boolean checkValidTimestamp(Timestamp timestamp, String start, String end, String granularity){
        Timestamp startTimestamp = new Timestamp(start);
        Timestamp endTimestamp = new Timestamp(end);
        boolean startTimestampPast = false;
        boolean endTimestampFuture = false;
        boolean validYear = timestamp.year >= startTimestamp.year && timestamp.year <= endTimestamp.year;
        if(timestamp.year > startTimestamp.year)
            startTimestampPast = true;
        if(timestamp.year < endTimestamp.year)
            endTimestampFuture = true;
        boolean validMonth = true;
        if(validYear && (!startTimestampPast || !endTimestampFuture)){
            if(timestamp.year == startTimestamp.year)
                if(timestamp.month < startTimestamp.month)
                    validMonth = false;
            if(timestamp.year == endTimestamp.year)
                if(timestamp.month > endTimestamp.month)
                    validMonth = false;
            if(timestamp.month > startTimestamp.month)
                startTimestampPast = true;
            if(timestamp.month < endTimestamp.month)
                endTimestampFuture = true;
        }
        boolean validDay = true;
        if(validMonth && !startTimestampPast && !endTimestampFuture){
            if(timestamp.month == startTimestamp.month)
                if(timestamp.day < startTimestamp.day)
                    validDay = false;
            if(timestamp.month == endTimestamp.month)
                if(timestamp.day > endTimestamp.day)
                    validDay = false;
            if(timestamp.day > startTimestamp.day)
                startTimestampPast = true;
            if(timestamp.day < endTimestamp.day)
                endTimestampFuture = true;
        }
        boolean validHour = true;
        if(validDay && !startTimestampPast && !endTimestampFuture){
            if(timestamp.day == startTimestamp.day)
                if(timestamp.hour < startTimestamp.hour)
                    validHour = false;
            if(timestamp.day == endTimestamp.day)
                if(timestamp.hour > endTimestamp.hour)
                    validHour = false;
            if(timestamp.hour > startTimestamp.hour)
                startTimestampPast = true;
            if(timestamp.hour < endTimestamp.hour)
                endTimestampFuture = true;
        }
        boolean validMinute = true;
        if(validHour && !startTimestampPast && !endTimestampFuture){
            if(timestamp.hour == startTimestamp.hour)
                if(timestamp.min < startTimestamp.min)
                    validMinute = false;
            if(timestamp.hour == endTimestamp.hour)
                if(timestamp.min > endTimestamp.min)
                    validMinute = false;
            if(timestamp.min > startTimestamp.min)
                startTimestampPast = true;
            if(timestamp.min < endTimestamp.min)
                endTimestampFuture = true;
        }
        boolean validSecond = true;
        if(validMinute && !startTimestampPast && !endTimestampFuture){
            if(timestamp.min == startTimestamp.min)
                if(timestamp.sec < startTimestamp.sec)
                    validSecond = false;
            if(timestamp.min == endTimestamp.min)
                if(timestamp.sec > endTimestamp.sec)
                    validSecond = false;
        }

        switch (granularity){
            case "Year":
                return validYear;
            case "Month":
                return validYear && validMonth;
            case "Day":
                return validYear && validMonth && validDay;
            case "Hour":
                return validYear && validMonth && validDay && validHour;
            case "Minute":
                return validYear && validMonth && validDay && validHour && validMinute;
            case "Second":
                return validYear && validMonth && validDay && validHour && validMinute && validSecond;
            default:
                return false;
        }
    }
}

class Log{
    int id;
    Timestamp timestamp;
    public Log(int id, String timestamp){
        this.id = id;
        this.timestamp = new Timestamp(timestamp);
    }
}

class Timestamp{
    int year;
    int month;
    int day;
    int hour;
    int min;
    int sec;

    public Timestamp(String timestampStr){
        String[] strArray = timestampStr.split(":");
        this.year = Integer.parseInt(strArray[0]);
        this.month = Integer.parseInt(strArray[1]);
        this.day = Integer.parseInt(strArray[2]);
        this.hour = Integer.parseInt(strArray[3]);
        this.min = Integer.parseInt(strArray[4]);
        this.sec = Integer.parseInt(strArray[5]);

    }
}
