package me.pwcong.rtfrxmvp.mvp.presenter;

import me.pwcong.rtfrxmvp.mvp.bean.JokeBean;
import me.pwcong.rtfrxmvp.mvp.model.BaseModel;
import me.pwcong.rtfrxmvp.mvp.model.JokeFragmentModelImpl;
import me.pwcong.rtfrxmvp.mvp.view.BaseView;
import rx.Subscriber;

/**
 * Created by pwcong on 2016/8/30.
 */
public class JokeFragmentPresenterImpl extends BasePresenter<BaseView.JokeFragmentView>
        implements BasePresenter.JokeFragmentPresenter {

    BaseModel.JokeFragmentModel model;

    public JokeFragmentPresenterImpl(BaseView.JokeFragmentView view) {
        super(view);
        model = new JokeFragmentModelImpl();
    }

    @Override
    public void initData(int page) {

        view.showHeadProgress();

        model.getData(page, new Subscriber<JokeBean>() {
            @Override
            public void onCompleted() {
                view.hideHeadProgress();
            }

            @Override
            public void onError(Throwable e) {
                view.hideHeadProgress();
                view.showError();
            }

            @Override
            public void onNext(JokeBean jokeBean) {
                if (jokeBean.getError_code() == 0) {
                    view.setData(jokeBean.getResult().getData());
                } else {
                    view.showError();
                }

            }
        });

    }

    @Override
    public void loadMore(int page) {

        model.getData(page, new Subscriber<JokeBean>() {
            @Override
            public void onCompleted() {
                view.hideHeadProgress();
            }

            @Override
            public void onError(Throwable e) {

                view.showError();
            }

            @Override
            public void onNext(JokeBean jokeBean) {
                if (jokeBean.getError_code() == 0) {
                    view.loadMore(jokeBean.getResult().getData());
                } else {
                    view.showError();
                }

            }
        });
    }
}
