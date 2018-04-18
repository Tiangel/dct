package yxinfo.dct.inteface.dto.res.biz;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * Created by dy on 2016/7/1.
 */
public class RetUploadFileDTO extends BaseDTO {

    private static final long serialVersionUID = 4041260769212121147L;

    // 原文件名
    private String oriFileName;

    // 静态资源id
    private Integer staticId;

    // 地址
    private String url;

    // 是否上传成功
    private boolean isSuccess;

    public RetUploadFileDTO() {}

    public RetUploadFileDTO(String oriFileName, Integer staticId, String url) {
        this.oriFileName = oriFileName;
        this.staticId = staticId;
        this.url = url;
    }

    public String getOriFileName() {
        return oriFileName;
    }

    public void setOriFileName(String oriFileName) {
        this.oriFileName = oriFileName;
    }

    public Integer getStaticId() {
        return staticId;
    }

    public void setStaticId(Integer staticId) {
        this.staticId = staticId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
