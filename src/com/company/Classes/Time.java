package com.company.Classes;

public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.setHours(hours);
        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours % 24;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes >= 60) {
            this.minutes = minutes % 60;
            hours++;
        } else {
            this.minutes = minutes;
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds >= 60) {
            this.seconds = seconds % 60;
            minutes++;
        } else {
            this.seconds = seconds;
        }
    }

    public String TimesOfDay() {
        String result = "";
        result += this.hours < 6 ? "ночь" : this.hours < 12 ? "утро" : this.hours < 18 ? "день" : this.hours < 24 ? "вечер" : "";
        return result;
    }

    public Time Plus(Time t1) {
        return new Time(this.hours + t1.hours, this.minutes + t1.minutes, this.seconds + t1.seconds);
    }

    public Time Minus(Time t1) {
        int hour = this.hours;
        int minute = this.minutes;
        int second = this.seconds;
        if (second - t1.seconds < 0) {
            second = second - t1.seconds + 60;
            minute--;
        } else {
            second = second - t1.minutes;
        }
        if (minute - t1.minutes < 0) {
            minute = minute - t1.minutes + 60;
            hour--;
        } else {
            minute = minute - t1.minutes;
        }
        if (hour - t1.hours < 0) {
            hour = hour - t1.hours + 24;
        } else {
            hour = hour - t1.hours;
        }
        return new Time(hour, minute, second);
    }

    public boolean isLarger(Time t1) {
        boolean flag = false;
        if (this.hours - t1.hours > 0) {
            flag = true;
        } else if (this.hours - t1.hours == 0) {
            if (this.minutes - t1.minutes > 0) {
                flag = true;
            } else if (this.minutes - t1.minutes == 0) {
                if (this.seconds - t1.seconds > 0) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public boolean isSmaller(Time t1) {
        boolean flag = true;
        if (this.hours - t1.hours > 0) {
            flag = false;
        } else if (this.hours - t1.hours == 0) {
            if (this.minutes - t1.minutes > 0) {
                flag = false;
            } else if (this.minutes - t1.minutes == 0) {
                if (this.seconds - t1.seconds > 0) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        String result = "";
        result += hours < 10 ? "0" + hours : hours;
        result += ":";
        result += minutes < 10 ? "0" + minutes : minutes;
        result += ":";
        result += seconds < 10 ? "0" + seconds : seconds;
        return result;
    }
}
