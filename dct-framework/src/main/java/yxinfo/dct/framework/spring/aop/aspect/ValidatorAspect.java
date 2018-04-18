package yxinfo.dct.framework.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import yxinfo.dct.framework.exception.DctException;
import yxinfo.dct.framework.validation.ObjectValidator;
import yxinfo.dct.framework.validation.ValidBO;
import yxinfo.dct.framework.validation.annotation.DctValid;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 校验参数校验切点
 * Created by dy on 2016/06/20.
 */
@Component
@Aspect
public class ValidatorAspect extends BaseAspect {

    /**
     * Service层切点
     */
    @Pointcut( "@annotation(yxinfo.dct.framework.validation.annotation.DctValidator)" )
    public void serviceAspect() {

    }

    /**
     * 前置拦截service层调用, 校验参数
     * @param joinPoint
     */
    @Before( "serviceAspect()" )
    public void doBefore( JoinPoint joinPoint ) throws DctException {

        String targetClassName = joinPoint.getTarget().getClass().getName();
        String targetMethodName = joinPoint.getSignature().getName();
        log.debug( "【ValidatorAspect】拦截Service: {}, 方法: {}", targetClassName, targetMethodName );

        // 获取切点方法
        Method targetMethod = getTargetMethod( joinPoint );
        if ( targetMethod == null ) return;

        // 获取待校验参数及其对应@DctValid注解
        List<ValidBO> validBoList = new ArrayList<ValidBO>();
        try {
            Annotation[][] parameterAnnotations = targetMethod.getParameterAnnotations();
            if ( parameterAnnotations == null || parameterAnnotations.length == 0 ) {
                return;
            }
            int i = 0;
            Object[] arguments = joinPoint.getArgs();
            for ( Annotation[] parameterAnnotation : parameterAnnotations ) {
                for ( Annotation annotation : parameterAnnotation ) {
                    if ( annotation instanceof DctValid ) {
                        DctValid valid = (DctValid) annotation;
                        validBoList.add( new ValidBO( arguments[i], valid  ) );
                        break;
                    }
                }
                i++;
            }
        } catch ( Exception e ) {
            log.error( "拦截@DctValidator异常, {}", e.getMessage(), e );
        }

        // 校验参数
        ObjectValidator.validate( validBoList );
    }

    private static final Logger log = LoggerFactory.getLogger( ValidatorAspect. class );

}
