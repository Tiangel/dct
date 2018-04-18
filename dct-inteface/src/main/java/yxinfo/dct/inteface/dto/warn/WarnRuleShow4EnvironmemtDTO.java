package yxinfo.dct.inteface.dto.warn;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * @author sxd
 * @date 2016/8/25 11:51
 */
public class WarnRuleShow4EnvironmemtDTO extends BaseDTO {

    /**
     * 主键id
     */
    private Integer id;

    private String LabName;

    private String tempLeft;

    private String tempRight;

    private String humLeft;

    private String humRight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabName() {
        return LabName;
    }

    public void setLabName(String labName) {
        LabName = labName;
    }

    public String getTempLeft() {
        return tempLeft;
    }

    public void setTempLeft(String tempLeft) {
        this.tempLeft = tempLeft;
    }

    public String getTempRight() {
        return tempRight;
    }

    public void setTempRight(String tempRight) {
        this.tempRight = tempRight;
    }

    public String getHumLeft() {
        return humLeft;
    }

    public void setHumLeft(String humLeft) {
        this.humLeft = humLeft;
    }

    public String getHumRight() {
        return humRight;
    }

    public void setHumRight(String humRight) {
        this.humRight = humRight;
    }
}
