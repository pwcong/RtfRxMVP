package me.pwcong.rtfrxmvp.mvp.bean;

import java.util.List;

/**
 * Created by pwcong on 2016/8/21.
 */
public class NewsBean {

    String reason;
    Result result;


    public NewsBean(String reason, Result result) {
        this.reason = reason;
        this.result = result;
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
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

    public class Result{


        int stat;
        List<News> data;

        public Result(int stat, List<News> data) {
            this.stat = stat;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "stat=" + stat +
                    ", data=" + data +
                    '}';
        }

        public int getStat() {
            return stat;
        }

        public void setStat(int stat) {
            this.stat = stat;
        }

        public List<News> getData() {
            return data;
        }

        public void setData(List<News> data) {
            this.data = data;
        }
    }



}
