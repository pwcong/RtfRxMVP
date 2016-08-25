package me.pwcong.rtfrxmvp.citypicker.model;

/**
 * author zaaach on 2016/1/26.
 */
public class City {

    String name;
    String pinyin;

    public City(String name, String pinyin) {
        this.name = name;
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}
