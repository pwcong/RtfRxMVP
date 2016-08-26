package me.pwcong.rtfrxmvp.mvp.bean;

/**
 * Created by pwcong on 2016/8/26.
 */
public class Realtime {
    String city_code;
    String city_name;
    String date;
    String time;
    int week;
    String moon;
    long dataUptime;
    Weather weather;
    Wind wind;

    public Realtime(String city_code, String city_name, String date, String time, int week, String moon, long dataUptime, Weather weather, Wind wind) {
        this.city_code = city_code;
        this.city_name = city_name;
        this.date = date;
        this.time = time;
        this.week = week;
        this.moon = moon;
        this.dataUptime = dataUptime;
        this.weather = weather;
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "Realtime{" +
                "city_code='" + city_code + '\'' +
                ", city_name='" + city_name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", week=" + week +
                ", moon='" + moon + '\'' +
                ", dataUptime=" + dataUptime +
                ", weather=" + weather +
                ", wind=" + wind +
                '}';
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getMoon() {
        return moon;
    }

    public void setMoon(String moon) {
        this.moon = moon;
    }

    public long getDataUptime() {
        return dataUptime;
    }

    public void setDataUptime(long dataUptime) {
        this.dataUptime = dataUptime;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public class Wind{
        String direct;
        String power;
        String offset;
        String windspeed;

        public Wind(String direct, String power, String offset, String windspeed) {
            this.direct = direct;
            this.power = power;
            this.offset = offset;
            this.windspeed = windspeed;
        }

        @Override
        public String toString() {
            return "Wind{" +
                    "direct='" + direct + '\'' +
                    ", power='" + power + '\'' +
                    ", offset='" + offset + '\'' +
                    ", windspeed='" + windspeed + '\'' +
                    '}';
        }

        public String getDirect() {
            return direct;
        }

        public void setDirect(String direct) {
            this.direct = direct;
        }

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public String getOffset() {
            return offset;
        }

        public void setOffset(String offset) {
            this.offset = offset;
        }

        public String getWindspeed() {
            return windspeed;
        }

        public void setWindspeed(String windspeed) {
            this.windspeed = windspeed;
        }
    }





    public class Weather{

        String temperature;
        String humidity;
        String info;
        String img;

        public Weather(String temperature, String humidity, String info, String img) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.info = info;
            this.img = img;
        }

        @Override
        public String toString() {
            return "Weather{" +
                    "temperature='" + temperature + '\'' +
                    ", humidity='" + humidity + '\'' +
                    ", info='" + info + '\'' +
                    ", img='" + img + '\'' +
                    '}';
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }
}
