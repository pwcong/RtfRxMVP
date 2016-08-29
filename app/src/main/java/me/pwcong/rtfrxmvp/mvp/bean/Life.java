package me.pwcong.rtfrxmvp.mvp.bean;

import java.util.Arrays;

/**
 * Created by pwcong on 2016/8/26.
 */
public class Life {

    String date;
    LifeInfo info;

    public Life(String date, LifeInfo info) {
        this.date = date;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Life{" +
                "date='" + date + '\'' +
                ", info=" + info +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LifeInfo getInfo() {
        return info;
    }

    public void setInfo(LifeInfo info) {
        this.info = info;
    }

    public class LifeInfo{

        String[] chuanyi;
        String[] ganmao;
        String[] kongtiao;
        String[] wuran;
        String[] xiche;
        String[] yundong;
        String[] ziwaixian;

        public LifeInfo(String[] chuanyi, String[] ganmao, String[] kongtiao, String[] wuran, String[] xiche, String[] yundong, String[] ziwaixian) {
            this.chuanyi = chuanyi;
            this.ganmao = ganmao;
            this.kongtiao = kongtiao;
            this.wuran = wuran;
            this.xiche = xiche;
            this.yundong = yundong;
            this.ziwaixian = ziwaixian;
        }

        @Override
        public String toString() {
            return "LifeInfo{" +
                    "chuanyi=" + Arrays.toString(chuanyi) +
                    ", ganmao=" + Arrays.toString(ganmao) +
                    ", kongtiao=" + Arrays.toString(kongtiao) +
                    ", wuran=" + Arrays.toString(wuran) +
                    ", xiche=" + Arrays.toString(xiche) +
                    ", yundong=" + Arrays.toString(yundong) +
                    ", ziwaixian=" + Arrays.toString(ziwaixian) +
                    '}';
        }

        public String[] getChuanyi() {
            return chuanyi;
        }

        public void setChuanyi(String[] chuanyi) {
            this.chuanyi = chuanyi;
        }

        public String[] getGanmao() {
            return ganmao;
        }

        public void setGanmao(String[] ganmao) {
            this.ganmao = ganmao;
        }

        public String[] getKongtiao() {
            return kongtiao;
        }

        public void setKongtiao(String[] kongtiao) {
            this.kongtiao = kongtiao;
        }

        public String[] getWuran() {
            return wuran;
        }

        public void setWuran(String[] wuran) {
            this.wuran = wuran;
        }

        public String[] getXiche() {
            return xiche;
        }

        public void setXiche(String[] xiche) {
            this.xiche = xiche;
        }

        public String[] getYundong() {
            return yundong;
        }

        public void setYundong(String[] yundong) {
            this.yundong = yundong;
        }

        public String[] getZiwaixian() {
            return ziwaixian;
        }

        public void setZiwaixian(String[] ziwaixian) {
            this.ziwaixian = ziwaixian;
        }
    }


}
