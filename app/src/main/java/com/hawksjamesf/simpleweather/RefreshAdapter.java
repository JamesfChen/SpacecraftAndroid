package com.hawksjamesf.simpleweather;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hawksjamesf.simpleweather.bean.fifteendaysbean.SkyConBean;
import com.hawksjamesf.simpleweather.bean.fifteendaysbean.TempeBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.inflate;

/**
 * Copyright ® 2017
 * Shanghai wind-mobi
 * All right reserved.
 *
 * @author:chenjinfa
 * @since:2017/6/29
 */

public class RefreshAdapter extends BaseAdapter {

    private Activity mActivity;
    private List<SkyConBean> mSkyConBeans;
    private List<TempeBean> mTempeBeans;

    public RefreshAdapter(Activity activity) {
        mActivity = activity;
    }


    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflate(mActivity, R.layout.item_weather, null);
        ViewHolder holder = new ViewHolder(view);
        holder.mRvFiftenDaysForecast.setData(mTempeBeans, mSkyConBeans);


        return view;
    }


    public void setData(List<TempeBean> tempeBeans, List<SkyConBean> skyconBeans) {
        mTempeBeans = tempeBeans;
        mSkyConBeans = skyconBeans;

    }


    static class ViewHolder {

        @BindView(R.id.rv_fiften_days_forecast)
        FifteenDaysView mRvFiftenDaysForecast;
        @BindView(R.id.realtime_date)
        TextView mRealtimeDate;
        @BindView(R.id.realtime_week)
        TextView mRealtimeWeek;
        @BindView(R.id.realtime_city)
        TextView mRealtimeCity;
        @BindView(R.id.iv_realtime_condition)
        ImageView mIvRealtimeCondition;
        @BindView(R.id.realtime_temperature)
        TextView mRealtimeTemperature;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}
