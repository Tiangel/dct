package yxinfo.dct.inteface.dto.base;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.Set;

/**
 * Created by hanley on 2016/6/30.
 *
 * PC端管理后台菜单
 */
public class AdminMenuDTO extends BaseDTO {

    private static final long serialVersionUID = -6128426528947682983L;

    private Integer id;

    //名称
    private String fname;

    //父菜单id
    private Integer pid;

    //图标
    private String icon;

    //默认访问控制器id
    private Integer defActId;

    //所属功能模块id
    private Integer modId;

    private Set<AdminMenuDTO> chlidMenu;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getDefActId() {
        return defActId;
    }

    public void setDefActId(Integer defActId) {
        this.defActId = defActId;
    }

    public Integer getModId() {
        return modId;
    }

    public void setModId(Integer modId) {
        this.modId = modId;
    }

    public Set<AdminMenuDTO> getChlidMenu() {
        return chlidMenu;
    }

    public void setChlidMenu(Set<AdminMenuDTO> chlidMenu) {
        this.chlidMenu = chlidMenu;
    }
}
