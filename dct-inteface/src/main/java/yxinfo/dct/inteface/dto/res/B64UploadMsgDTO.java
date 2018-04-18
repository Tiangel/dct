package yxinfo.dct.inteface.dto.res;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.List;

/**
 * Created by dy on 2016/10/17.
 */
public class B64UploadMsgDTO extends BaseDTO {

    private static final long serialVersionUID = -7127767242335242751L;

    private String bizCode;

    private List<B64UploadDTO> files;

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode( String bizCode ) {
        this.bizCode = bizCode;
    }

    public List<B64UploadDTO> getFiles() {
        return files;
    }

    public void setFiles( List<B64UploadDTO> files ) {
        this.files = files;
    }
}
