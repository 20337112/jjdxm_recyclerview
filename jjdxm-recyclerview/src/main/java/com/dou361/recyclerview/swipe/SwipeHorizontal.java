package com.dou361.recyclerview.swipe;

import android.view.View;
import android.widget.OverScroller;

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
 * 创建日期：2016/10/28 11:06
 * <p/>
 * 描 述：横向滑动
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public abstract class SwipeHorizontal {

    private int direction;
    private View menuView;
    protected Checker mChecker;

    public SwipeHorizontal(int direction, View menuView) {
        this.direction = direction;
        this.menuView = menuView;
        mChecker = new Checker();
    }

    public abstract boolean isMenuOpen(final int scrollX);

    public abstract boolean isMenuOpenNotEqual(final int scrollX);

    public abstract void autoOpenMenu(OverScroller scroller, int scrollX, int duration);

    public abstract void autoCloseMenu(OverScroller scroller, int scrollX, int duration);

    public abstract Checker checkXY(int x, int y);

    public abstract boolean isClickOnContentView(int contentViewWidth, float x);

    public int getDirection() {
        return direction;
    }

    public View getMenuView() {
        return menuView;
    }

    public int getMenuWidth() {
        return menuView.getWidth();
    }

    public static final class Checker {
        public int x;
        public int y;
        public boolean shouldResetSwipe;
    }

}
