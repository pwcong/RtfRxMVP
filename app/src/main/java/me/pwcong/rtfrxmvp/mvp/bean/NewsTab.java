package me.pwcong.rtfrxmvp.mvp.bean;

/**
 * Created by pwcong on 2016/8/22.
 */
public class NewsTab {

    String type;
    String title;

    public NewsTab(String type, String title) {
        this.type = type;
        this.title = title;
    }

    @Override
    public String toString() {
        return "NewsTab{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
