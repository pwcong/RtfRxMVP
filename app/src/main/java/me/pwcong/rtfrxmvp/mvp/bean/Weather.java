package me.pwcong.rtfrxmvp.mvp.bean;

import java.util.Arrays;

/**
 * Created by pwcong on 2016/8/26.
 */
public class Weather {

    String date;
    WeatherInfo info;
    String week;
    String nongli;

    public Weather(String date, WeatherInfo info, String week, String nongli) {
        this.date = date;
        this.info = info;
        this.week = week;
        this.nongli = nongli;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "date='" + date + '\'' +
                ", info=" + info +
                ", week='" + week + '\'' +
                ", nongli='" + nongli + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public WeatherInfo getInfo() {
        return info;
    }

    public void setInfo(WeatherInfo info) {
        this.info = info;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getNongli() {
        return nongli;
    }

    public void setNongli(String nongli) {
        this.nongli = nongli;
    }

    public class WeatherInfo{

        String[] dawn;
        String[] day;
        String[] night;

        public WeatherInfo(String[] dawn, String[] day, String[] night) {
            this.dawn = dawn;
            this.day = day;
            this.night = night;
        }

        @Override
        public String toString() {
            return "WeatherInfo{" +
                    "dawn=" + Arrays.toString(dawn) +
                    ", day=" + Arrays.toString(day) +
                    ", night=" + Arrays.toString(night) +
                    '}';
        }

        public String[] getDawn() {
            return dawn;
        }

        public void setDawn(String[] dawn) {
            this.dawn = dawn;
        }

        public String[] getDay() {
            return day;
        }

        public void setDay(String[] day) {
            this.day = day;
        }

        public String[] getNight() {
            return night;
        }

        public void setNight(String[] night) {
            this.night = night;
        }
    }


}
