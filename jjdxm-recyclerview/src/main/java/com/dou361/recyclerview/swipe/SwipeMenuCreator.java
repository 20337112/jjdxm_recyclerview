package com.dou361.recyclerview.swipe;

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
 * 描 述：滑动菜单构造器
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public interface SwipeMenuCreator {

    /**
     * Create menu for recyclerVie item.
     *
     * @param swipeLeftMenu  The menu on the left.
     * @param swipeRightMenu The menu on the right.
     * @param viewType       The view type of the new view.
     */
    void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType);

}
