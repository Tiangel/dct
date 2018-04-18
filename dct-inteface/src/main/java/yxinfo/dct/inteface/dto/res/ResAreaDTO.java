package yxinfo.dct.inteface.dto.res;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.List;

public class ResAreaDTO extends BaseDTO {

    private static final long serialVersionUID = -314618863664989145L;

    private Integer id;

    //名称
    private String fname;

    //父地区id
    private Integer pid;

    //级别（1国家，2省，3市，4区/县，5街道）
    private Short level;

    //子地区
    private List<ResAreaDTO> child;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Short getLevel() {
        return level;
    }

    public void setLevel(Short level) {
        this.level = level;
    }

    public List<ResAreaDTO> getChild() {
        return child;
    }

    public void setChild( List<ResAreaDTO> child ) {
        this.child = child;
    }
}