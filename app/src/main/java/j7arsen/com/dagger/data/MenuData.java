package j7arsen.com.dagger.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ghost on 29.03.2016.
 */
public class MenuData implements Parcelable {

    public static final int LOGIN = 0;
    public static final int COMPANY = 1;
    public static final int NEWS = 2;
    public static final int CALENDAR = 3;
    public static final int LIBRARY = 4;
    public static final int MAP = 5;
    public static final int BANK_REQUISITES = 6;
    public static final int SETTINGS = 7;
    public static final int HELP = 8;
    public static final int ABOUT = 9;
    public static final int LOGOUT = 10;


    public static final int PROFILE = -1;

    private String mTitle;
    private String mScreenTitle;
    private int mId;

    public MenuData(int id, String title, String screen_title) {
        mId = id;
        mTitle = title;
        mScreenTitle = screen_title == null ? title : screen_title;
    }

    public MenuData(int id, String title) {
        this(id, title, null);
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getScreenTitle() {
        return mScreenTitle;
    }

    public void setScreenTitle(String mScreenTitle) {
        this.mScreenTitle = mScreenTitle;
    }

    public int getId() {
        return mId;
    }

    public void setId(int mId) {
        this.mId = mId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTitle);
        dest.writeString(this.mScreenTitle);
        dest.writeInt(this.mId);
    }

    protected MenuData(Parcel in) {
        this.mTitle = in.readString();
        this.mScreenTitle = in.readString();
        this.mId = in.readInt();
    }

    public static final Parcelable.Creator<MenuData> CREATOR = new Parcelable.Creator<MenuData>() {
        @Override
        public MenuData createFromParcel(Parcel source) {
            return new MenuData(source);
        }

        @Override
        public MenuData[] newArray(int size) {
            return new MenuData[size];
        }
    };
}
