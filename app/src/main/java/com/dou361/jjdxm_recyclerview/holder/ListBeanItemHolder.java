package com.dou361.jjdxm_recyclerview.holder;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dou361.baseutils.utils.DateUtils;
import com.dou361.jjdxm_recyclerview.R;
import com.dou361.jjdxm_recyclerview.bean.TimeBean;
import com.dou361.recyclerview.hodler.BaseViewHolder;
import com.dou361.recyclerview.listener.OnItemClickListener;

import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * ========================================
 * <p/>
 * 版 权：dou361.com 版权所有 （C） 2015
 * <p/>
 * 作 者：陈冠明
 * <p/>
 * 个人网站：http://www.dou361.com
 * <p/>
 * 版 本：1.0
 * <p/>
 * 创建日期：2016/3/9
 * <p/>
 * 描 述：
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class ListBeanItemHolder extends BaseViewHolder<TimeBean> {


    @Bind(R.id.iv_trumb)
    ImageView ivTrumb;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.tv_content)
    TextView tvContent;
    @Bind(R.id.ll_start_panel)
    LinearLayout llStartPanel;
    @Bind(R.id.tv_timer)
    TextView tvTimer;
    @Bind(R.id.ll_timer)
    LinearLayout llTimer;
    TimeBean mData;
    private long strStartTime;
    private long countTime;
    private CountDownTimer countDownTimer;

    public ListBeanItemHolder(Context mContext, OnItemClickListener listener, View itemView) {
        super(mContext, listener, itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void refreshView() {
        mData = getData();
        tvTitle.setText(mData.getTitle());
        tvContent.setText(mData.getDescription());
        Glide.with(mContext)
                .load(mData.getThumb())
                .into(ivTrumb);
        strStartTime = mData.getStartTime();
        countTime = strStartTime - DateUtils.getCurrentTimeMillis();
        if (countTime < 24 * 60 * 60 * 1000) {
            //一天内
            startCountDown(countTime);
            llTimer.setVisibility(View.VISIBLE);
            llStartPanel.setVisibility(View.GONE);
        } else {
            //一天后
            tvTimer.setText(getStringDayTime((int) (countTime / 1000)));
            llTimer.setVisibility(View.VISIBLE);
            llStartPanel.setVisibility(View.GONE);
        }
    }

    @Override
    public void onViewRecycled() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
        if(tvTimer!=null){
            tvTimer.setText("");
        }
    }

    /**
     * 开启计时器,成功回调******view-->对应的item的view ,millisUntilFinished-->剩余时间
     * 结束直接返回item中的view
     */

    private void startCountDown(long millis) {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
        countDownTimer = new CountDownTimer(millis, 1000) {
            @Override
            public void onTick(long time) {
                tvTimer.setText(getStringTime((int) (time / 1000)));

            }

            @Override
            public void onFinish() {
                llTimer.setVisibility(View.GONE);
                llStartPanel.setVisibility(View.VISIBLE);
            }
        };
        countDownTimer.start();
    }

    private String getStringTime(int cnt) {

        int hour = cnt / 3600;

        int min = cnt % 3600 / 60;

        int second = cnt % 60;

        return String.format(Locale.CHINA, "%02d:%02d:%02d", hour, min, second);

    }

    private String getStringDayTime(int cnt) {

        int day = cnt / (3600 * 24);

        return String.format(Locale.CHINA, "%02d", day) + "天";

    }

}
