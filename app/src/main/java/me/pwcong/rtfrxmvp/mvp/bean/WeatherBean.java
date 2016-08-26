package me.pwcong.rtfrxmvp.mvp.bean;

import java.util.List;

/**
 * Created by pwcong on 2016/8/26.
 */
public class WeatherBean {

    String reason;
    Result result;
    int error_code;

    public WeatherBean(String reason, Result result, int error_code) {
        this.reason = reason;
        this.result = result;
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                ", error_code=" + error_code +
                '}';
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public class Result{

        Data data;

        public Result(Data data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "data=" + data +
                    '}';
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }
    }

    public class Data{

        Realtime realtime;
        Life life;
        List<Weather> weather;
        PM25 pm25;

        public Data(Realtime realtime, Life life, List<Weather> weather, PM25 pm25) {
            this.realtime = realtime;
            this.life = life;
            this.weather = weather;
            this.pm25 = pm25;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "realtime=" + realtime +
                    ", life=" + life +
                    ", weather=" + weather +
                    ", pm25=" + pm25 +
                    '}';
        }

        public Realtime getRealtime() {
            return realtime;
        }

        public void setRealtime(Realtime realtime) {
            this.realtime = realtime;
        }

        public Life getLife() {
            return life;
        }

        public void setLife(Life life) {
            this.life = life;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(List<Weather> weather) {
            this.weather = weather;
        }

        public PM25 getPm25() {
            return pm25;
        }

        public void setPm25(PM25 pm25) {
            this.pm25 = pm25;
        }
    }


}
