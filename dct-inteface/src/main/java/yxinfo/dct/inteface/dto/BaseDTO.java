package yxinfo.dct.inteface.dto;


import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * Created by hanley on 2016/6/15.
 */
public abstract class BaseDTO implements Serializable {

    private static final long serialVersionUID = 1539792933961409444L;

    public <T> T toDTO(Object target) {
        if ( target == null ) return null;
        try {
            copyProperties(target, this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return (T) this;
    }


    public <T> T toModel(Class<T> tClass) {
        try {
            Constructor<?> constructor = tClass.getConstructor();
            Object o = constructor.newInstance();
            copyProperties(this, o);
            return (T) o;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private void copyProperties(Object source, Object target ) throws InvocationTargetException, IllegalAccessException {

        if ( source == null || target == null) return;

        Method[] sourceMethods = source.getClass().getDeclaredMethods();
        Method[] targetMethods = target.getClass().getDeclaredMethods();

        Method sourceMethod = null, targetMethod = null;
        String sourceMethodName = null, targetMethodName = null;

        int length = sourceMethods.length;

        for ( int i = 0; i < length; ++i ) {

            sourceMethod = sourceMethods[i];
            sourceMethodName = sourceMethod.getName();

            if ( !sourceMethodName.contains("get") ) continue;

            targetMethodName = "set" + sourceMethodName.substring(3);

            targetMethod = findMethodByName(targetMethods, targetMethodName);

            if ( targetMethod == null ) continue;

            Object value = sourceMethod.invoke(source, new Object[0] );

            if ( value == null ) continue;

            if ( value instanceof Collection ) {
                Collection<?> newValue = (Collection<?>) value;

                if ( newValue.size() <= 0 ) continue;
            }

            targetMethod.invoke(target, new Object[] { value} );
        }

    }

    public Method findMethodByName(Method[] methods, String name) {

        for (int j = 0; j < methods.length; j++) {

            if (methods[j].getName().equals(name)) {

                return methods[j];
            }

        }
        return null;
    }
}
