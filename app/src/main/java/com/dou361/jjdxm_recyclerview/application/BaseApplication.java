package com.dou361.jjdxm_recyclerview.application;

import android.app.Application;
import android.os.Handler;

import com.dou361.baseutils.utils.LogType;
import com.dou361.baseutils.utils.UtilsManager;

/**
 * Created by chenguanming on 2016/12/10.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilsManager.init(this, "", new Handler(), Thread.currentThread());
        UtilsManager.getInstance().setDebugEnv(true);
        UtilsManager.getInstance().setLogLevel(LogType.LEVEL_ERROR);
    }
}
