package com.dou361.recyclerview.swipe;

import android.content.Context;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

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
 * 创建日期：2016/10/28 10:40
 * <p/>
 * 描 述：滑动的菜单管理
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class SwipeMenu {

    @IntDef({HORIZONTAL, VERTICAL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private SwipeMenuLayout mSwipeMenuLayout;

    private int mViewType;

    private int orientation;

    private List<SwipeMenuItem> mSwipeMenuItems;

    public SwipeMenu(SwipeMenuLayout swipeMenuLayout, int viewType) {
        this.mSwipeMenuLayout = swipeMenuLayout;
        this.mViewType = viewType;
        this.mSwipeMenuItems = new ArrayList<>(2);
    }

    /**
     * Set a percentage.
     *
     * @param openPercent such as 0.5F.
     */
    public void setOpenPercent(float openPercent) {
        if (openPercent != mSwipeMenuLayout.getOpenPercent()) {
            openPercent = openPercent > 1 ? 1 : (openPercent < 0 ? 0 : openPercent);
            mSwipeMenuLayout.setOpenPercent(openPercent);
        }
    }

    /**
     * The duration of the set.
     *
     * @param scrollerDuration such 500.
     */
    public void setScrollerDuration(int scrollerDuration) {
        this.mSwipeMenuLayout.setScrollerDuration(scrollerDuration);
    }

    /**
     * Set the menu orientation.
     *
     * @param orientation use {@link SwipeMenu#HORIZONTAL} or {@link SwipeMenu#VERTICAL}.
     * @see SwipeMenu#HORIZONTAL
     * @see SwipeMenu#VERTICAL
     */
    public void setOrientation(@OrientationMode int orientation) {
        if (orientation != HORIZONTAL && orientation != VERTICAL)
            throw new IllegalArgumentException("Use SwipeMenu#HORIZONTAL or SwipeMenu#VERTICAL.");
        this.orientation = orientation;
    }

    /**
     * Get the menu orientation.
     *
     * @return {@link SwipeMenu#HORIZONTAL} or {@link SwipeMenu#VERTICAL}.
     */
    @OrientationMode
    public int getOrientation() {
        return orientation;
    }

    public void addMenuItem(SwipeMenuItem item) {
        mSwipeMenuItems.add(item);
    }

    public void removeMenuItem(SwipeMenuItem item) {
        mSwipeMenuItems.remove(item);
    }

    public List<SwipeMenuItem> getMenuItems() {
        return mSwipeMenuItems;
    }

    public SwipeMenuItem getMenuItem(int index) {
        return mSwipeMenuItems.get(index);
    }

    public Context getContext() {
        return mSwipeMenuLayout.getContext();
    }

    public int getViewType() {
        return mViewType;
    }
}
