package me.pwcong.rtfrxmvp.mvp.bean;

/**
 * Created by pwcong on 2016/8/26.
 */
public class PM25 {

    String key;
    int show_desc;
    pm25 pm25;
    String dateTime;
    String cityName;

    public PM25(String key, int show_desc, PM25.pm25 pm25, String dateTime, String cityName) {
        this.key = key;
        this.show_desc = show_desc;
        this.pm25 = pm25;
        this.dateTime = dateTime;
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "PM25{" +
                "key='" + key + '\'' +
                ", show_desc=" + show_desc +
                ", pm25=" + pm25 +
                ", dateTime='" + dateTime + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getShow_desc() {
        return show_desc;
    }

    public void setShow_desc(int show_desc) {
        this.show_desc = show_desc;
    }

    public PM25.pm25 getPm25() {
        return pm25;
    }

    public void setPm25(PM25.pm25 pm25) {
        this.pm25 = pm25;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public class pm25 {
        String curPm;
        String pm25;
        String pm10;
        int level;
        String quality;
        String des;

        public pm25(String curPm, String pm25, String pm10, int level, String quality, String des) {
            this.curPm = curPm;
            this.pm25 = pm25;
            this.pm10 = pm10;
            this.level = level;
            this.quality = quality;
            this.des = des;
        }

        @Override
        public String toString() {
            return "pm25{" +
                    "curPm='" + curPm + '\'' +
                    ", pm25='" + pm25 + '\'' +
                    ", pm10='" + pm10 + '\'' +
                    ", level=" + level +
                    ", quality='" + quality + '\'' +
                    ", des='" + des + '\'' +
                    '}';
        }

        public String getCurPm() {
            return curPm;
        }

        public void setCurPm(String curPm) {
            this.curPm = curPm;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getPm10() {
            return pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }
    }

}
