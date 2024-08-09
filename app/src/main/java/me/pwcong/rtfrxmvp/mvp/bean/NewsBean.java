package me.pwcong.rtfrxmvp.mvp.bean;

import java.util.List;

/**
 * Created by pwcong on 2016/8/21.
 */
public class NewsBean {

    String reason;
    Result result;
    int error_code;

    public NewsBean(String reason, Result result, int error_code) {
        this.reason = reason;
        this.result = result;
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "NewsBean{" +
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

    public class Result {

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
