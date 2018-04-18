package yxinfo.dct.inteface.dto.res;

import yxinfo.dct.inteface.dto.BaseDTO;

public class ResUploadBoundDTO extends BaseDTO {

    private static final long serialVersionUID = -5697159668314722717L;

    private Integer id;

    //约束编号
    private String fcode;

    //后缀名限制
    private String suffix;

    //单文件大小限制（单位为KB）
    private Integer singleSize;

    //总文件大小限制（单位为KB）
    private Integer totalSize;

    //图片服务器上传目录
    private String ossObj;

    //是否是临时文件
    private Boolean isTemp;

    //临时文件保存时间
    private Integer tempLife;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getSingleSize() {
        return singleSize;
    }

    public void setSingleSize(Integer singleSize) {
        this.singleSize = singleSize;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public String getOssObj() {
        return ossObj;
    }

    public void setOssObj(String ossObj) {
        this.ossObj = ossObj;
    }

    public Boolean getTemp() {
        return isTemp;
    }

    public void setTemp(Boolean temp) {
        isTemp = temp;
    }

    public Integer getTempLife() {
        return tempLife;
    }

    public void setTempLife(Integer tempLife) {
        this.tempLife = tempLife;
    }
}