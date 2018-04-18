package yxinfo.dct.framework.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by dy on 2016/06/20.
 */
abstract class BaseAspect {

    /**
     * 获取切点方法
     * @param joinPoint
     * @return
     */
    public Method getTargetMethod( JoinPoint joinPoint ) {

        Method targetMethod = null;
        try {
            String targetName = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            Class targetClass = Class.forName( targetName );
            Class[] parameterTypes = ( (MethodSignature)joinPoint.getSignature() ).getMethod().getParameterTypes();
            targetMethod = targetClass.getMethod( methodName, parameterTypes );

        } catch ( Exception e ) {
            log.info( "GetTargetMethod Error, {}", e.getMessage(), e );
        }
        return targetMethod;
    }

    /**
     * 获取obj的field属性值, 不存在则返回null
     * @param obj
     * @param fieldName
     * @return
     */
    public Object getObjField( Object obj, String fieldName ) {
        if ( obj == null ) return null;
        try {
            Field field = obj.getClass().getField( fieldName);
            return field.get( obj );
        } catch ( Exception e ) {}
        return null;
    }

    private static final Logger log = LoggerFactory.getLogger( BaseAspect. class );
}
