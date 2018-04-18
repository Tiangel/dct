package yxinfo.dct.framework.validation;

import yxinfo.dct.framework.validation.annotation.DctValid;

/**
 * 待校验参数Bo
 * Created by dy on 2016/06/20.
 */
public class ValidBO {

    private Object forValid;
    private DctValid valid;

    public ValidBO(Object forCheck, DctValid valid) {
        this.forValid = forCheck;
        this.valid = valid;
    }

    public Object getForValid() {
        return forValid;
    }

    public void setForValid(Object forValid) {
        this.forValid = forValid;
    }

    public DctValid getValid() {
        return valid;
    }

    public void setValid(DctValid valid) {
        this.valid = valid;
    }
}
