package android.support.v7.widget.helper;

import android.support.v7.widget.helper.ItemTouchHelper;

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
 * 创建日期：2016/10/28 11:36
 * <p/>
 * 描 述：item触摸帮助类，注意包路径不能更改，否则获取不到mCallback
 * <p/>
 * <p/>
 * 修订历史：
 * <p/>
 * ========================================
 */
public class CompatItemTouchHelper extends ItemTouchHelper {

    public CompatItemTouchHelper(ItemTouchHelper.Callback callback) {
        super(callback);
    }

    /**
     * Developer callback which controls the behavior of ItemTouchHelper.
     *
     * @return {@link Callback}
     */
    public ItemTouchHelper.Callback getCallback() {
        return mCallback;
    }
}
