package com.dou361.jjdxm_recyclerview;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dou361.baseutils.utils.DateUtils;
import com.dou361.baseutils.utils.UIUtils;
import com.dou361.jjdxm_recyclerview.adapter.ListBeanAdapter;
import com.dou361.jjdxm_recyclerview.bean.TimeBean;
import com.dou361.recyclerview.swipe.SwipeMenuRecyclerView;
import com.dou361.recyclerview.widget.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {

    @Bind(R.id.recycler_view)
    SwipeMenuRecyclerView recyclerView;
    @Bind(R.id.swipe_layout)
    SwipeRefreshLayout swipeLayout;

    private ListBeanAdapter adapter;
    private int currentPosition;
    private String TAG = this.getClass().getSimpleName();

    private List<TimeBean> list = new ArrayList<TimeBean>();
    private String[] arrs = new String[]{"http://tupian.enterdesk.com/2014/mxy/01/10/03/11.jpg"
            , "http://image.tianjimedia.com/uploadImages/2013/324/E85BW32E3U69_1000x500.jpg"
            , "http://pic.yesky.com/uploadImages/2014/315/00/J3U360Y9NYJ2.jpg"
            , "http://www.redvi.com/uploadfile/hy/6c/kt/edo42ay1aaj.jpg"
            , "http://c11.eoemarket.com/app0/210/210768/icon/437326.png"
            , "http://tupian.enterdesk.com/2015/xll/02/26/2/rili2.jpg"
            , "http://img5.duitang.com/uploads/item/201504/16/20150416H0755_LfSyA.jpeg"
            , "http://image.tianjimedia.com/uploadImages/2013/150/VD58N0X2J2Q8.jpg"
            , "http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1210/16/c2/14454649_1350371218906.jpg"
            , "http://image.tianjimedia.com/uploadImages/2015/083/30/VVJ04M7P71W2.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        swipeLayout.setOnRefreshListener(mOnRefreshListener);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));// 布局管理器。
        recyclerView.setHasFixedSize(true);// 如果Item够简单，高度是确定的，打开FixSize将提高性能。
        recyclerView.setItemAnimator(new DefaultItemAnimator());// 设置Item默认动画，加也行，不加也行。
        recyclerView.addItemDecoration(new DividerItemDecoration(this, UIUtils.dip2px(8), true, getResources().getColor(R.color.color_bg_01), false, true, false));
        // 添加滚动监听。
        recyclerView.addOnScrollListener(mOnScrollListener);

        adapter = new ListBeanAdapter(this, list);
        recyclerView.setAdapter(adapter);

        swipeLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeLayout.setRefreshing(true);
            }
        });
        if (mOnRefreshListener != null) {
            mOnRefreshListener.onRefresh();
        }
    }

    /**
     * 刷新监听。
     */
    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            recyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    list.clear();
                    list.addAll(loadData());
                    adapter.notifyDataSetChanged();
                    swipeLayout.setRefreshing(false);
                }
            }, 1500);
        }
    };

    /**
     * 加载更多
     */
    private RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            if (!recyclerView.canScrollVertically(1)) {
                if (list.size() <= 0) {
                    return;
                }
                recyclerView.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        list.addAll(loadData());
                        adapter.notifyDataSetChanged();
                    }
                }, 1500);
            }
        }
    };

    /**
     * 模拟加载数据
     */
    private List<TimeBean> loadData() {
        List<TimeBean> temp = new ArrayList<>();
        Random rd = new Random();
        for (int i = 0; i < 5; i++) {
            TimeBean liveBean = new TimeBean();
            liveBean.setTitle("标题" + i);
            liveBean.setDescription("简介" + i);
            liveBean.setStartTime(DateUtils.getCurrentTimeMillis() + rd.nextInt(1000 * 60 * 60 * 24 * 2));
            liveBean.setThumb(arrs[rd.nextInt(10)]);
            temp.add(liveBean);
        }
        return temp;
    }


}
