package me.pwcong.rtfrxmvp;

import android.util.TypedValue;

import com.google.gson.Gson;

import org.junit.Test;

import me.pwcong.rtfrxmvp.mvp.bean.NewsBean;
import me.pwcong.rtfrxmvp.network.Api;
import me.pwcong.rtfrxmvp.network.TouTiaoService;
import rx.Subscriber;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
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
    public void testValue(){


    }


}