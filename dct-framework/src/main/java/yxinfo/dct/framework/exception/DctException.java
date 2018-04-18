package yxinfo.dct.framework.exception;


/**
 * 自定义异常
 * Created by dy on 2016/06/20.
 */
public class DctException extends RuntimeException {

    private static final long serialVersionUID = -2188163149122750886L;

    private String code;

    public DctException(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String toString() {
        return this.code;
    }
}
