package yxinfo.dct.inteface.dto.base;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * Created by hanley on 2016/6/23.
 *
 * APP首页菜单
 */
public class AppMenuDTO extends BaseDTO {

    private static final long serialVersionUID = -7732287014225920607L;
    private Integer id;

    //名称
    private String fname;

    //唯一编号
    private String fcode;

    private String icon;

    //备注
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AppMenuDTO{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", fcode='" + fcode + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    @Override
    public boolean equals( Object o ) {
        if ( o == null || getClass() != o.getClass() ) return false;
        AppMenuDTO that = (AppMenuDTO) o;
        if ( !fcode.equals( that.fcode ) ) return false;
        return true;
    }
}
