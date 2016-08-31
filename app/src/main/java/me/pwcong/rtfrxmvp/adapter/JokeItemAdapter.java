package me.pwcong.rtfrxmvp.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.mvp.bean.Joke;
import me.pwcong.rtfrxmvp.utils.StringUtils;

/**
 * Created by pwcong on 2016/8/30.
 */
public class JokeItemAdapter  extends BaseQuickAdapter<Joke>{


    public JokeItemAdapter(List<Joke> data) {
        super(R.layout.item_joke,data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Joke joke) {

        baseViewHolder.setText(R.id.tv_content, "        "+StringUtils.toDBC(joke.getContent()).replaceAll("  ","\n        ").replaceAll("&nbsp;",""))
                .setText(R.id.tv_updatetime,joke.getUpdatetime());

    }
}
