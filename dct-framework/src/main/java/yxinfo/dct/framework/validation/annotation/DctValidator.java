package yxinfo.dct.framework.validation.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解 @DctValidator
 *      注解在Service方法上时, ValidatorAspect会拦截并校验带有@DctValid注解的参数
 * Created by dy on 2016/06/19.
 */
@Target( { ElementType.METHOD } )
@Retention( RetentionPolicy.RUNTIME )
@Documented
public @interface DctValidator {
}
