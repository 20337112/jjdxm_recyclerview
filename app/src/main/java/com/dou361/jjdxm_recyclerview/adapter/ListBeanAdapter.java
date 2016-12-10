package com.dou361.jjdxm_recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dou361.jjdxm_recyclerview.R;
import com.dou361.jjdxm_recyclerview.bean.TimeBean;
import com.dou361.jjdxm_recyclerview.holder.ListBeanItemHolder;
import com.dou361.recyclerview.adapter.BaseRecyclerViewAdapter;
import com.dou361.recyclerview.hodler.BaseViewHolder;

import java.util.List;

/**
 * ========================================
 * <p>
 * 版 权：dou361.com 版权所有 （C） 2015
 * <p>
 * 作 者：陈冠明
 * <p>
 * 个人网站：http://www.dou361.com
 * <p>
 * 版 本：1.0
 * <p>
 * 创建日期：2016/3/9
 * <p>
 * 描 述：直播列表
 * <p>
 * <p>
 * 修订历史：
 * <p>
 * ========================================
 */
public class ListBeanAdapter extends BaseRecyclerViewAdapter<TimeBean> {


    public ListBeanAdapter(Context mContext, List<TimeBean> mDatas) {
        super(mContext, mDatas);
    }

    @Override
    public View onCreateContentView(ViewGroup parent, int viewType) {
        return LayoutInflater.from(mContext).
                inflate(R.layout.holder_item_list, parent, false);
    }

    @Override
    public BaseViewHolder getItemHolder(View contentView, int viewType) {
        return new ListBeanItemHolder(mContext, mListener, contentView);
    }

}
