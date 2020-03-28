package CountDownTimer.model;

public class Timer {
    private String minutes;
    private String seconds;

    public Timer(String minutes, String seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Timer() {

    }

    public String getMinutes() {
        return minutes;
    }

    public void setMinutes(String minutes) {
        this.minutes = minutes;
    }

    public String getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return this.minutes + " : " + this.seconds;
    }
}
