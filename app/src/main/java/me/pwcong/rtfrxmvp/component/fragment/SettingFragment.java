package me.pwcong.rtfrxmvp.component.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import me.pwcong.rtfrxmvp.R;

/**
 * Created by pwcong on 2016/9/1.
 */
public class SettingFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preference_setting);

    }
}
