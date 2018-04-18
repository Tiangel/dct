package yxinfo.dct.inteface.dto.warn;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * @author sxd
 * @date 2016/7/27 9:21
 */
public class WarnShow4AppDTO extends BaseDTO {
    private static final long serialVersionUID = 5027598385646630072L;
    //预警名称
    private String name;
    //颜色(1绿色，2黄色，3红色)
    private Integer color;

    private String itemNo;

    private Integer orgId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public WarnShow4AppDTO() {
    }

    public WarnShow4AppDTO(String name, Integer color, String itemNo) {
        this.name = name;
        this.color = color;
        this.itemNo = itemNo;
    }

    @Override
    public String toString() {
        return "WarnShow4AppDTO{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", itemNo='" + itemNo + '\'' +
                ", orgId=" + orgId +
                '}';
    }
}
