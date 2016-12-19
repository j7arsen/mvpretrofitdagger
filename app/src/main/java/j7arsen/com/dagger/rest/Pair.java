package j7arsen.com.dagger.rest;

/**
 * Created by arsen on 15.12.16.
 */

public class Pair {

    private Object mObject;

    public Pair(Object object){
        this.mObject = object;
    }

    public Object getObject() {
        return mObject;
    }

    public void setObject(Object mObject) {
        this.mObject = mObject;
    }
}
