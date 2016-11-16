package com.dou361.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

import com.dou361.recyclerview.hodler.BaseViewHolder;
import com.dou361.recyclerview.listener.OnItemClickListener;

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
 * 创建日期：2016/10/5 17:54
 * <p>
 * 描 述：RecyclerView的Adapter的基类
 * <p>
 * <p>
 * 修订历史：
 * <p>
 * ========================================
 */
public abstract class BaseRecyclerViewAdapter<T> extends Adapter<ViewHolder> {


    /**
     *用来确定每一个item如何进行排列摆放
     * LinearLayoutManager 相当于ListView的效果
     GridLayoutManager相当于GridView的效果
     StaggeredGridLayoutManager 瀑布流
     */
    /**第一步：设置布局管理器**/
//    rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    /**第二步：添加分割线**/
//    itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST);
//    rv.addItemDecoration(itemDecoration);
    /**第三步：设置适配器**/
//    rvAdapter = new RvAdapter(this, datas);
//    rv.setAdapter(rvAdapter);

    /**
     * 上下文
     */
    protected Context mContext;
    /**
     * 接收传递过来的数据
     */
    private List<T> mDatas;
    /**
     * 获得holder
     */
    private BaseViewHolder baseHolder;
    protected OnItemClickListener mListener;

    public BaseRecyclerViewAdapter(Context mContext, List<T> mDatas) {
        this.mContext = mContext;
        setmDatas(mDatas);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getItemHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder != null) {
            baseHolder = (BaseViewHolder) holder;
            baseHolder.setPosition(position);
            baseHolder.setData(mDatas.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public List<T> getmDatas() {
        return mDatas;
    }

    public void setmDatas(List<T> mDatas) {
        this.mDatas = mDatas;
    }

    /**
     * 获得Holder
     */
    public abstract BaseViewHolder getItemHolder(ViewGroup parent, int viewType);

    /**
     * 设置Item点击监听
     *
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

}