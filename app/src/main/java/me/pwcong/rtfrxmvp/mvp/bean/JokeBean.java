package me.pwcong.rtfrxmvp.mvp.bean;

import java.util.List;

/**
 * Created by pwcong on 2016/8/30.
 */
public class JokeBean {

    int error_code;
    String reason;
    Result result;

    public JokeBean(int error_code, String reason, Result result) {
        this.error_code = error_code;
        this.reason = reason;
        this.result = result;
    }

    @Override
    public String toString() {
        return "JokeBean{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
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

    public class Result {

        List<Joke> data;

        public Result(List<Joke> data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "data=" + data +
                    '}';
        }

        public List<Joke> getData() {
            return data;
        }

        public void setData(List<Joke> data) {
            this.data = data;
        }
    }

}
