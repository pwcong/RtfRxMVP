package me.pwcong.rtfrxmvp.component.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import me.pwcong.rtfrxmvp.R;
import me.pwcong.rtfrxmvp.conf.Constants;
import me.pwcong.rtfrxmvp.manager.SharedPreferencesManager;

/**
 * Created by pwcong on 2016/9/1.
 */
public class SettingFragment extends PreferenceFragment {

    private final String TAG=getClass().getSimpleName();

    CheckBoxPreference mPushMsgAgreePre;
    Preference mPushMsgTimerPre;
    CheckBoxPreference mShowEnterAgreePre;

    boolean mPushMsgAgree;
    int mPushMsgTimer;
    boolean mShowEnterAgree;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initVariable();
        initPreference();

        Log.i(TAG, "onCreate: OK");

    }

    private void initView(){
        addPreferencesFromResource(R.xml.preference_setting);
    }


    private void initVariable(){

        mPushMsgAgree= SharedPreferencesManager.getInstance().getBoolean(Constants.PUSH_MSG_AGREE,true);
        mPushMsgTimer=SharedPreferencesManager.getInstance().getInt(Constants.PUSH_MSG_TIMER,1);
        mShowEnterAgree=SharedPreferencesManager.getInstance().getBoolean(Constants.SHOW_ENTER_AGREE,true);

    }


    private void initPreference(){

        mPushMsgAgreePre = (CheckBoxPreference) getPreferenceManager().findPreference(Constants.PUSH_MSG_AGREE);
        mPushMsgAgreePre.setChecked(mPushMsgAgree);

        mPushMsgAgreePre.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {

                if((boolean)o){

                    mPushMsgTimerPre.setEnabled(true);
                    SharedPreferencesManager.getInstance().edit().putBoolean(Constants.PUSH_MSG_AGREE,(boolean)o).apply();

                }else {

                    mPushMsgTimerPre.setEnabled(false);
                    SharedPreferencesManager.getInstance().edit().putBoolean(Constants.PUSH_MSG_AGREE,(boolean)o).apply();
                }

                return true;
            }
        });


        mPushMsgTimerPre = getPreferenceManager().findPreference(Constants.PUSH_MSG_TIMER);
        mPushMsgTimerPre.setEnabled(SharedPreferencesManager.getInstance().getBoolean(Constants.PUSH_MSG_AGREE,true));
        mPushMsgTimerPre.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {

                showTimerSelectDialog();

                return true;
            }
        });



        mShowEnterAgreePre = (CheckBoxPreference) getPreferenceManager().findPreference(Constants.SHOW_ENTER_AGREE);
        mShowEnterAgreePre.setChecked(mShowEnterAgree);
        mShowEnterAgreePre.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {

                SharedPreferencesManager.getInstance().edit().putBoolean(Constants.SHOW_ENTER_AGREE,(boolean)o).apply();

                return true;
            }
        });

    }

    private void showTimerSelectDialog(){

        View view_update = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_update, (ViewGroup) getActivity().findViewById(R.id.dialog_root));

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view_update);

        final AlertDialog dialog = builder.create();

        final TextView tv_hour = (TextView) view_update.findViewById(R.id.tv_hour);
        String hourString=SharedPreferencesManager.getInstance().getInt(Constants.PUSH_MSG_TIMER,1)+"小时";
        tv_hour.setText(hourString);

        final SeekBar seekbar = (SeekBar) view_update.findViewById(R.id.seekbar);
        seekbar.setMax(23);
        seekbar.setProgress(SharedPreferencesManager.getInstance().getInt(Constants.PUSH_MSG_TIMER,0)-1);

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String t= String.valueOf(i+1) + "小时";
                tv_hour.setText(t);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                SharedPreferencesManager.getInstance().edit().putInt(Constants.PUSH_MSG_TIMER,seekbar.getProgress()+1).apply();

                dialog.dismiss();
            }
        });

        dialog.show();

    }

}
