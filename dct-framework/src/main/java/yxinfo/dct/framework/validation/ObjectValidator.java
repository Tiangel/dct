package yxinfo.dct.framework.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yxinfo.dct.framework.exception.DctException;

import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 参数检验器
 * Created by dy on 2016/06/20.
 */
public class ObjectValidator {

    /**
     * 检验参数
     * @param validBos 待检验参数
     * @throws DctException 参数检验异常
     */
    public static void validate( List<ValidBO> validBos ) throws DctException {

        if ( validBos == null || validBos.size() == 0 ) return;

        Map<String, String> errDetails = new HashMap<String, String>();
        for ( ValidBO validBo : validBos ) {

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Class[] groups = validBo.getValid().groups();

            if ( validBo.getForValid() != null && validBo.getForValid() instanceof List ) {
                for (  Object validObj : (List) validBo.getForValid() ) {
                    validateOne( groups, validObj, validator );
                }
            } else {
                validateOne( groups, validBo.getForValid(), validator );
            }
        }
    }

    /**
     * 检验参数
     * @param groups
     * @param obj
     * @throws DctException
     */
    public static void validate( Object obj, Class... groups ) throws DctException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> constraintViolations = null;
        if ( groups == null || groups.length == 0 ) {
            constraintViolations = validator.validate( obj );
        } else {
            constraintViolations = validator.validate( obj, groups );
        }
        for ( ConstraintViolation<Object> constraintViolation : constraintViolations ) {
            String message = constraintViolation.getMessage();
            throw new DctException( message );
        }
    }

    private static void validateOne( Class[] groups, Object obj, Validator validator ) throws DctException {
        Set<ConstraintViolation<Object>> constraintViolations = null;
        if ( groups == null || groups.length == 0 ) {
            constraintViolations = validator.validate( obj );
        } else {
            constraintViolations = validator.validate( obj, groups );
        }
        for ( ConstraintViolation<Object> constraintViolation : constraintViolations ) {
            String message = constraintViolation.getMessage();
            String key = constraintViolation.getPropertyPath().toString();
            log.info( "参数[{}]未通过校验, 错误码: {}", key, message );
            throw new DctException( message );
        }
    }

    private static final Logger log = LoggerFactory.getLogger( ObjectValidator. class );

}
