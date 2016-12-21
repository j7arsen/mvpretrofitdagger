package j7arsen.com.dagger.data;

/**
 * Created by arsen on 15.12.16.
 */

public class Pair<T> {

    private T mValue;

    public Pair(T value){
        this.mValue = value;
    }

    public Object getValue() {
        return mValue;
    }

    public void setValue(T value) {
        this.mValue = value;
    }
}
