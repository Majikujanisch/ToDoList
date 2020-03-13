
public class Task {
    private String TaskHeader;
    private String TaskText;
    private int year, month, day, hour, minute;

    public String getTaskText() {
        return TaskText;
    }
    public void setTaskText(String taskText) {
        TaskText = taskText;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        if(year > 2019) {
            this.year = year;
        }
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        if(month < 13 && month > 0) {
            this.month = month;
        }
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        if(day < 32 && day >0) {
            this.day = day;
        }
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        if(hour < 24 && hour > -1) {
            this.hour = hour;
        }
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        if(minute > -1 && minute < 60){
            this.minute = minute;
        }
    }
    public Task() {
        this("","",0,0,0);
    }
    public Task(String taskHeader, String taskText, int year, int month, int day, int hour, int minute) {
        TaskHeader = taskHeader;
        TaskText = taskText;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }
    public Task(String taskHeader, String taskText, int year, int month, int day) {
        TaskHeader = taskHeader;
        TaskText = taskText;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public java.lang.String toString() {
        return "Task{" +
                "TaskHeader='" + TaskHeader + '\'' +
                ", TaskText='" + TaskText + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", minute=" + minute +
                '}';
    }
}
