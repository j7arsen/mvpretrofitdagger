package j7arsen.com.dagger.utils;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import j7arsen.com.dagger.app.TestApplication;

/**
 * Created by ghost on 29.03.2016.
 */
public class FieldConverter {

    public static String getString(int resId) {
        return TestApplication.mInstance.getResources().getString(resId);
    }

    public static String[] getStringArray(int resId) {
        return TestApplication.mInstance.getResources().getStringArray(resId);
    }

    public static int getColor(int resId) {
        return ContextCompat.getColor(TestApplication.mInstance, resId);
    }

    public static Drawable getDrawable(int resId) {
        return ContextCompat.getDrawable(TestApplication.mInstance, resId);
    }

}
