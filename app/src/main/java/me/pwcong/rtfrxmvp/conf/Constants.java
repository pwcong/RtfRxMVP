package me.pwcong.rtfrxmvp.conf;

import me.pwcong.rtfrxmvp.R;

/**
 * Created by pwcong on 2016/8/19.
 */
public abstract class Constants {

    public static final String TYPE ="type";
    public static final String TITLE="title";
    public static final String URL_CONTENT="url_content";
    public static final String URL_IMG="url_img";

    public static final String CITY_NAME ="city_name";

    public static final String PRE_NAME="rtfrxmvp";

    public static final int[] WEATHER_ICONS ={R.drawable.type_one_sunny,R.drawable.type_one_cloudytosunny,     //ok
            R.drawable.type_one_cloudy,R.drawable.type_one_small_rain,R.drawable.type_one_thunder_rain,     //ok
            R.drawable.type_one_thunder_rain_snow,R.drawable.type_one_light_rain_snow,R.drawable.type_one_small_rain,R.drawable.type_one_mid_rain,   //9
            R.drawable.type_one_heavy_rain,R.drawable.type_one_heavy_rain,R.drawable.type_one_heavy_rain,R.drawable.type_one_heavy_rain,   //13
            R.drawable.type_one_small_snow,R.drawable.type_one_mid_snow,R.drawable.type_one_snow,R.drawable.type_one_snow,R.drawable.type_one_snow,  //18
            R.drawable.type_one_fog,R.drawable.type_one_ice_rain,R.drawable.type_one_cloudy,R.drawable.type_one_small_rain,R.drawable.type_one_mid_rain,   //23
            R.drawable.type_one_heavy_rain,R.drawable.type_one_heavy_rain,R.drawable.type_one_heavy_rain,R.drawable.type_one_small_snow,R.drawable.type_one_mid_snow,    //28
            R.drawable.type_one_snow,R.drawable.type_one_fog,R.drawable.type_one_fog,R.drawable.type_one_cloudy,R.drawable.type_one_fog};  //33


    public static final int TAG_HEADER=0;
    public static final int TAG_DIVIDER_1=1;
    public static final int TAG_DIVIDER_2=2;
    public static final int TAG_RECYCLER_VERTICAL=3;
    public static final int TAG_RECYCLER_HORIZONTAL=4;

    public static final int[] LIFEINFO_TYPE ={R.string.chuanyi,R.string.ganmao,R.string.kongtiao,R.string.wuran,R.string.xiche,R.string.yundong,R.string.ziwaixian};

    public static final int[] LIFEINFO_ICONS ={R.drawable.ic_tshirt_crew_grey600_48dp,R.drawable.ic_pill_grey600_48dp,R.drawable.ic_air_conditioner_grey600_48dp,R.drawable.ic_delete_variant_grey600_48dp,R.drawable.ic_car_wash_grey600_48dp,
            R.drawable.ic_run_grey600_48dp,R.drawable.ic_sunglasses_grey600_48dp};


    public static final String ASC="asc";
    public static final String DESC="desc";

    public static final int PAGESIZE=10;





}
