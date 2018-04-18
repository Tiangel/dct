package yxinfo.dct.inteface.dto.ctrl;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * 设备和仪器绑定关系
 * @author sxd
 * @date 2016/8/20 15:48
 */
public class CtrlEquAndInstShowDTO extends BaseDTO {

    /**
     * 设备编号
     */
    private String equNo;

    private String equName;
    /**
     * 仪器名称
     */
    private String InstName;
    /**
     * 实验室名称
     */
    private String labName;

    public String getEquNo() {
        return equNo;
    }

    public void setEquNo(String equNo) {
        this.equNo = equNo;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public String getInstName() {
        return InstName;
    }

    public void setInstName(String instName) {
        InstName = instName;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }
}
