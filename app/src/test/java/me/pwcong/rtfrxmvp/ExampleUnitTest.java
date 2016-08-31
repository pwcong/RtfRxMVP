package me.pwcong.rtfrxmvp;

import android.util.Log;
import android.util.TypedValue;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.mvp.bean.JokeBean;
import me.pwcong.rtfrxmvp.mvp.bean.NewsBean;
import me.pwcong.rtfrxmvp.mvp.bean.WeatherBean;
import me.pwcong.rtfrxmvp.network.Api;
import me.pwcong.rtfrxmvp.network.JokeService;
import me.pwcong.rtfrxmvp.network.TouTiaoService;
import me.pwcong.rtfrxmvp.network.WeatherService;
import me.pwcong.rtfrxmvp.utils.StringUtils;
import me.pwcong.rtfrxmvp.utils.TimeUtils;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    private final String TAG=getClass().getSimpleName();

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void testRetrofit() throws Exception{

        TouTiaoService service=new TouTiaoService();
        service.getNews("top", Api.KEY_TOUTIAO, new Subscriber<NewsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(NewsBean newsBean) {
                System.out.println(newsBean.getResult().getData().get(0).getTitle());
                System.out.println("Hello");
            }
        });

        System.out.println("Hello");
    }


    @Test
    public void testGsonData() throws Exception{

        String data="{\n" +
                "    \"reason\": \"成功的返回\",\n" +
                "    \"result\": {\n" +
                "        \"stat\": \"1\",\n" +
                "        \"data\": [\n" +
                "            {\n" +
                "                \"title\": \"巫山云雨枉断肠：女摄影师Erika Lust记录的性爱\",\n" +
                "                \"date\": \"2016-06-13 10:31\",\n" +
                "                \"author_name\": \"POCO摄影\",\n" +
                "                \"thumbnail_pic_s\": \"http://09.imgmini.eastday.com/mobile/20160613/20160613103108_7b015493398e7fd13dda3a5c\n" +
                "e315b1c8_1_mwpm_03200403.jpeg\",\n" +
                "                \"thumbnail_pic_s02\": \"http://09.imgmini.eastday.com/mobile/20160613/20160613103108_7b015493398e7fd13dda3a5ce315\n" +
                "b1c8_1_mwpl_05500201.jpeg\",\n" +
                "                \"thumbnail_pic_s03\": \"http://09.imgmini.eastday.com/mobile/20160613/20160613103108_7b015493398e7fd13dda3a5ce315\n" +
                "b1c8_1_mwpl_05500201.jpeg\",\n" +
                "                \"url\": \"http://mini.eastday.com/mobile/160613103108379.html?qid=juheshuju\",\n" +
                "                \"uniquekey\": \"160613103108379\",\n" +
                "                \"type\": \"头条\",\n" +
                "                \"realtype\": \"娱乐\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"title\": \"巫山云雨枉断肠：女摄影师Erika Lust记录的性爱\",\n" +
                "                \"date\": \"2016-06-13 10:31\",\n" +
                "                \"author_name\": \"POCO摄影\",\n" +
                "                \"thumbnail_pic_s\": \"http://09.imgmini.eastday.com/mobile/20160613/20160613103108_7b015493398e7fd13dda3a5c\n" +
                "e315b1c8_1_mwpm_03200403.jpeg\",\n" +
                "                \"thumbnail_pic_s02\": \"http://09.imgmini.eastday.com/mobile/20160613/20160613103108_7b015493398e7fd13dda3a5ce315\n" +
                "b1c8_1_mwpl_05500201.jpeg\",\n" +
                "                \"thumbnail_pic_s03\": \"http://09.imgmini.eastday.com/mobile/20160613/20160613103108_7b015493398e7fd13dda3a5ce315\n" +
                "b1c8_1_mwpl_05500201.jpeg\",\n" +
                "                \"url\": \"http://mini.eastday.com/mobile/160613103108379.html?qid=juheshuju\",\n" +
                "                \"uniquekey\": \"160613103108379\",\n" +
                "                \"type\": \"头条\",\n" +
                "                \"realtype\": \"娱乐\"\n" +
                "            },\n" +
                "        ]\n" +
                "    }\n" +
                "}";

        Gson gson=new Gson();
        NewsBean newsBean = gson.fromJson(data, NewsBean.class);

        System.out.print(newsBean.toString());


    }

    @Test
    public void testVector(){

        String t="Haha";

        Vector<String> strings=new Vector<>();

        strings.add(t);
        for(int i=0;i<10;i++){
            strings.add("Hello "+i);
        }

        System.out.println(strings);

        strings.remove(t);

        System.out.println(strings);

    }

    @Test
    public void testWeather(){

        WeatherService service=new WeatherService();
        service.getWeather("深圳", Api.KEY_WEATHER, new Subscriber<WeatherBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(WeatherBean weatherBean) {
                System.out.print(weatherBean.toString());
            }
        });

    }

    @Test
    public void testStringToInt(){

        List<String> list=new ArrayList<>();
        list.add("Hello World 1");
        list.add("Hello World 2");
        list.add("Hello World 3");
        list.add("Hello World 4");
        list.add("Hello World 5");


        Integer integer = Integer.valueOf("1");
        System.out.print(list.get(integer));

    }

    @Test
    public void testTime(){

        System.out.print(TimeUtils.getCurTimeString());



    }

    @Test
    public void testJoke(){

        JokeService service=new JokeService();

        long curTimeMills = TimeUtils.getCurTimeMills();
        String time=curTimeMills+"";
        time=time.substring(0,10);

        service.getJoke(Constants.DESC, 1, Constants.PAGESIZE, time, Api.KEY_JOKE, new Subscriber<JokeBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(JokeBean jokeBean) {
                System.out.print(jokeBean.toString());
            }
        });

    }

    @Test
    public void testString(){

        String s="多云 　　";

        if(s.contains("云"))
            System.out.print(s);

    }




}