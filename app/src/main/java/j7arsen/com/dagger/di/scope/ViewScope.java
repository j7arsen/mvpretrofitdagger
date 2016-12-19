package j7arsen.com.dagger.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Arsen on 06.10.2016.
 */
@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewScope {
}
