package yxinfo.dct.framework.validation.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解 @DctValid
 *      注解在Service方法的参数上时, ValidatorAspect校验此参数
 * Created by dy on 2016/06/20.
 */
@Target( { ElementType.PARAMETER } )
@Retention( RetentionPolicy.RUNTIME )
@Documented
public @interface DctValid {

    Class<?>[] groups() default {};

}
