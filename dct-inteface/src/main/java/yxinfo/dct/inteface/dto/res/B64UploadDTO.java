package yxinfo.dct.inteface.dto.res;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * Created by dy on 2016/10/17.
 */
public class B64UploadDTO extends BaseDTO {

    private static final long serialVersionUID = 1136043838400740752L;

    private String file;

    private String fileName;

    private Integer staticId;

    private byte[] bytes;

    public String getFile() {
        return file;
    }

    public void setFile( String file ) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName( String fileName ) {
        this.fileName = fileName;
    }

    public Integer getStaticId() {
        return staticId;
    }

    public void setStaticId( Integer staticId ) {
        this.staticId = staticId;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes( byte[] bytes ) {
        this.bytes = bytes;
    }
}
