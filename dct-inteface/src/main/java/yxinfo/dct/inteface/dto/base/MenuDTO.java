package yxinfo.dct.inteface.dto.base;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.List;

/**
 * Created by hanley on 2016/6/30.
 * PC端后台菜单
 */
public class MenuDTO extends BaseDTO {

    private static final long serialVersionUID = 1283788969586985838L;

    private Integer id;

    //名称
    private String fname;

    //图标
    private String icon;

    //路由
    private String ref;

    private List<MenuDTO> childs;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<MenuDTO> getChilds() {
        return childs;
    }

    public void setChilds(List<MenuDTO> childs) {
        this.childs = childs;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
