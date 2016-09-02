package me.pwcong.rtfrxmvp.rxbus.event;

/**
 * Created by pwcong on 2016/9/2.
 */
public class MainActivityEvent {

    int type;
    Object massage;

    @Override
    public String toString() {
        return "MainActivityEvent{" +
                "type=" + type +
                ", massage=" + massage +
                '}';
    }

    public MainActivityEvent(int type, Object massage) {
        this.type = type;
        this.massage = massage;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getMassage() {
        return massage;
    }

    public void setMassage(Object massage) {
        this.massage = massage;
    }



}
